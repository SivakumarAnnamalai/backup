package com.virtusapolaris

import com.virtusapolaris.StreamingProcessV2.Customer
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hbase.client.{Get, HTable, Put}
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.hbase.mapreduce.{HFileOutputFormat, LoadIncrementalHFiles}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, KeyValue}
import org.apache.hadoop.mapreduce.Job
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by siva on 20/5/16.
  */
object BatchProcessV4{
  case class Customer(id:String,transactionAmount:String,streetName:String,city:String)

  def main(args:Array[String]): Unit ={

    val inputdir = args(0)
    val tableName = "customer"

    // Hbase details
    val hbaseConf = HBaseConfiguration.create()
    val table = new HTable(hbaseConf, tableName)
    hbaseConf.set(TableOutputFormat.OUTPUT_TABLE, tableName)
    val job = Job.getInstance(hbaseConf)
    job.setMapOutputKeyClass (classOf[ImmutableBytesWritable])
    job.setMapOutputValueClass (classOf[KeyValue])
    HFileOutputFormat.configureIncrementalLoad (job, table)

    // Spark details
    val sparkConf = new SparkConf()
    sparkConf.setAppName("Lambda Batch process")
    val sc = new SparkContext(sparkConf)
    val fileRDD = sc.textFile(inputdir)

    val hiveContext = new HiveContext(sc)
    import hiveContext.implicits._

    // Writing the data to hive table
    val df1 = fileRDD.map(y =>{
      val row = y.split(",")
      Customer(row(0),row(1),row(3),row(4))
    }).toDF();

    df1.write.mode("append").format("orc").save("/user/hive/warehouse/customer")

    // required data for join
    val df2 = hiveContext.read.format("jdbc").
      option("url","jdbc:mysql://localhost:3306/test").option("dbtable","CustomerMapping").option("user","root").option("password","root").load()

    // join and select required fields
    val df3 = df1.join(df2,df1("id")===df2("id")).select(df1("id"),df2("title"),df2("firstname"),df2("lastname"),df1("streetName"),df1("city"))

    // actual writing to hbase by each row
    df3.foreachPartition(x=> {
      val hbaseConf = HBaseConfiguration.create()
      var table = new HTable(hbaseConf, tableName)
      x.foreach(y => {
        val cf = "cf1".getBytes()
        val cq1 = "City".getBytes()
        val cq2 = "FirstName".getBytes()
        val rowKey = y(0).toString.getBytes()
        val city = y(5).toString.getBytes()
        val firstName = y(2).toString.getBytes()
        var p = new Put(rowKey)
        p.add(cf, cq1, city)
        p.add(cf, cq2, firstName)
        if( city.length > 0 && firstName.length>0)
          table.put(p)
      })
      table.flushCommits()
      table.close()
    })

    val df4 = df1.groupBy("city").agg(sum("transactionAmount").as("TransactionAmount"))

    // Writing City level aggregated transaction data to hbase
    df4.foreachPartition(x=> {
      val tableName = "customer_batch_city"
      val hbaseConf = HBaseConfiguration.create()
      var table = new HTable(hbaseConf, tableName)
      x.foreach(y=>{
        var amount:Double = 0;
        try{
          var row = new Get(y(0).toString.getBytes())
          row.addFamily("City".getBytes())
          row.addColumn("City".getBytes(),"TransactionAmount".getBytes())
          val result = table.get(row)
          val data = result.getValue("City".getBytes(),"TransactionAmount".getBytes());
          amount=0
          if(data != null) {
            amount = Bytes.toString(data).toDouble;
          }
        }catch {
          case e:NullPointerException => {
            println("Null pointer Exception "+e+" "+y)
          }
          case e:NumberFormatException => {
            println("Number format Exception "+e+" "+y)
          }
          case e:IllegalArgumentException =>{
            println("Illegal Argument Exception "+e+" "+y)
          }
        }


        val cf = "City".getBytes()
        val cq1 = "TransactionAmount".getBytes()
        val rowKey = y(0).toString.getBytes()
        var transactionAmount:Double = amount
        try{
          transactionAmount= amount + y(1).toString.toDouble
          var p = new Put(rowKey)
          p.add(cf, cq1, transactionAmount.toString.getBytes)
          //if(transactionAmount.toString.getBytes.length>0)
          table.put(p)
        }catch {
          case e:NullPointerException => {
            println("Null pointer Exception "+e+" "+y)
          }
          case e:NumberFormatException => {
            println("Number Format Exception "+e+" "+y)
          }
          case e:IllegalArgumentException =>{
            println("Illegal Argument Exception "+e+" "+y)
          }
        }

      })
      table.flushCommits()
      table.close()
    })

    // Writing the data to hbase table
   /* val cityRdd = normalize(fileRDD,"cf1","City",0,6)
    val phoneRdd = normalize(fileRDD,"cf1","FirstName",0,2)

    cityRdd.saveAsNewAPIHadoopFile(outputdir+"/"+cityRdd, classOf[ImmutableBytesWritable], classOf[KeyValue], classOf[HFileOutputFormat], job.getConfiguration())
    phoneRdd.saveAsNewAPIHadoopFile(outputdir+"/"+phoneRdd, classOf[ImmutableBytesWritable], classOf[KeyValue], classOf[HFileOutputFormat], job.getConfiguration())

    //Bulk load Hfiles to Hbase
    val bulkLoader = new LoadIncrementalHFiles(hbaseConf)
    bulkLoader.doBulkLoad(new Path(outputdir+"/"+cityRdd,outputdir+"/"+phoneRdd), table)*/


  }


  /*def normalize(rdd: RDD[String], columnFamily:String, columnQualifier:String, rowkeyPosition:Int, columnQualifierPosition:Int): RDD[(ImmutableBytesWritable,KeyValue)] = {

    val sortedRDD = rdd.map(x=>(x.split(",")(rowkeyPosition),x)).sortByKey().map(x=>x._2).filter(_.split(",").length>columnQualifierPosition)

    val cf = columnFamily.getBytes()
    val cq = columnQualifier.getBytes()
    sortedRDD.map(x=> {
        var t = x.split(",")
        val rowKey = t(rowkeyPosition).getBytes()
        val value = t(columnQualifierPosition).getBytes()
        val kv1 = new KeyValue(rowKey, cf, cq, value)
        (new ImmutableBytesWritable(rowKey), kv1)
    })
  }*/
}


