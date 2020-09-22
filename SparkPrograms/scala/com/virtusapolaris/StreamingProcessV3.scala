package com.virtusapolaris

/**
  * Created by siva on 23/5/16.
  */

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{HTable, Put}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.SparkConf
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka._

object StreamingProcessV3{
  case class Customer(id:String,transactionAmount:String,streetName:String,city:String)

  def main(args:Array[String]): Unit ={

    val sparkConf = new SparkConf().setAppName("Lambda Architecture - Streaming Data")
    val ssc = new StreamingContext(sparkConf, Seconds(10))
    val tableName="customer_realtime"
    val hiveContext = new HiveContext(ssc.sparkContext)
    import hiveContext.implicits._
    val (zkQuorum,group,topics) = ("localhost:2181","test-consumer-group",Map("customer"->1))
    val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topics).map(_._2)

    // writing the data to hive
    lines.foreachRDD{iter =>{
      iter.map(y =>{
        val row = y.split(",")
        Customer(row(0),row(1),row(3),row(4))
      }).toDF.write.mode("append").format("orc").save("/user/hive/warehouse/customer_realtime")
    }}

    // writing the data to hbase
    lines.foreachRDD{iter =>{

      // input data
      val df1 = iter.map(y =>{
        val row = y.split(",")
        Customer(row(0),row(1),row(3),row(4))
      }).toDF

      // required data for join
      val df2 = hiveContext.read.format("jdbc").
        option("url","jdbc:mysql://localhost:3306/test").option("dbtable","CustomerMapping").option("user","root").option("password","root").load()

      // join and select required fields
      val df3 = df1.join(df2,df1("id")===df2("id")).select(df1("id"),df2("title"),df2("firstname"),df2("lastname"),df1("streetName"),df1("city"))

      // actual writing to hbase by each row
      df3.foreach(y=> {
        val hbaseConf = HBaseConfiguration.create()
        val table = new HTable(hbaseConf, tableName)
        val cf = "cf1".getBytes()
        val cq1 = "City".getBytes()
        val cq2 = "FirstName".getBytes()
        val rowKey = y(0).toString.getBytes()
        val city = y(5).toString.getBytes()
        val firstName = y(2).toString.getBytes()
        var p = new Put(rowKey)
        p.add(cf, cq1, city)
        p.add(cf, cq2, firstName)
        table.put(p)
        table.flushCommits()
        table.close()
      })

      import org.apache.spark.sql.functions._
      val df4 = df1.groupBy("city").agg(sum("transactionAmount").as("TransactionAmount"))

      df4.foreach(y=> {
        val tableName = "customer_realtime_city"
        val hbaseConf = HBaseConfiguration.create()
        import org.apache.hadoop.hbase.client.{HTable,Get}
        val table = new HTable(hbaseConf, tableName)
        var row = new Get(y(0).toString.getBytes())
        row.addFamily("City".getBytes())
        row.addColumn("City".getBytes(),"TransactionAmount".getBytes())
        val result = table.get(row)
        val data = result.getValue("City".getBytes(),"TransactionAmount".getBytes());
        var amount:Double=0
        if(data != null){
          try{
            amount = Bytes.toString(data).toDouble;
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
        }

        val cf = "City".getBytes()
        val cq1 = "TransactionAmount".getBytes()
        val rowKey = y(0).toString.getBytes()
        var transactionAmount:Double = amount
        try{
          transactionAmount= amount + y(1).toString.toDouble
        }catch {
          case e:NullPointerException => {
            println("Null pointer Exception "+e+" "+y)
          }
          case e:NullPointerException => {
            println("Null pointer Exception "+e+" "+y)
          }
          case e:IllegalArgumentException =>{
            println("Illegal Argument Exception "+e+" "+y)
          }
        }
        var p = new Put(rowKey)
        p.add(cf, cq1, transactionAmount.toString.getBytes)
        table.put(p)
        table.flushCommits()
        table.close()
      })
    }}

    lines.print()
    ssc.start
    ssc.awaitTermination()
  }
}
