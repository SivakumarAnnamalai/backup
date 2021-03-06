package com.virtusapolaris

import org.apache.hadoop.fs.Path
import org.apache.hadoop.hbase.{HBaseConfiguration, KeyValue}
import org.apache.hadoop.hbase.client.HTable
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.hbase.mapreduce.{HFileOutputFormat, LoadIncrementalHFiles}
import org.apache.hadoop.mapreduce.Job
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by siva on 20/5/16.
  */
object BatchProcess{
  def main(args:Array[String]): Unit ={

    val inputdir = args(0)
    val outputdir = args(1)
    val tableName = args(2)

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
    val cityRdd = normalize(fileRDD,"cf1","City",0,6)
    val phoneRdd = normalize(fileRDD,"cf1","FirstName",0,2)

    cityRdd.saveAsNewAPIHadoopFile(outputdir+"1", classOf[ImmutableBytesWritable], classOf[KeyValue], classOf[HFileOutputFormat], job.getConfiguration())
    phoneRdd.saveAsNewAPIHadoopFile(outputdir+"2", classOf[ImmutableBytesWritable], classOf[KeyValue], classOf[HFileOutputFormat], job.getConfiguration())

    //Bulk load Hfiles to Hbase
    val bulkLoader = new LoadIncrementalHFiles(hbaseConf)
    bulkLoader.doBulkLoad(new Path(outputdir+"1",outputdir+"2"), table)

  }
  def normalize(rdd: RDD[String], columnFamily:String, columnQualifier:String, rowkeyPosition:Int, columnQualifierPosition:Int): RDD[(ImmutableBytesWritable,KeyValue)] = {

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
  }
}


