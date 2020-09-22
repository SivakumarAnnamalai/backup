package com.virtusapolaris

/**
  * Created by siva on 23/5/16.
  */

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{HTable, Put}
import org.apache.spark.SparkConf
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka._

object StreamingProcessV2{
  case class Customer(id:String,firstName:String,city:String)

  def main(args:Array[String]): Unit ={

    val sparkConf = new SparkConf().setAppName("Lambda Architecture Streaming Data")
    //sparkConf.set("","")
    val ssc = new StreamingContext(sparkConf, Seconds(2))
    val tableName="customer_realtime"
    val hiveContext = new HiveContext(ssc.sparkContext)
    import hiveContext.implicits._
    val (zkQuorum,group,topics) = ("localhost:2181","test-consumer-group",Map("customer"->1))
    val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topics).map(_._2)

    lines.foreachRDD(iter =>{
      iter.foreach(y =>{
        val tableName="customer_realtime"
        val hbaseConf = HBaseConfiguration.create()
        val table = new HTable(hbaseConf, tableName)
        val cf = "cf1".getBytes()
        val cq = "City".getBytes()
        var t = y.split(",")
        val rowKey = t(0).getBytes()
        val value = t(6).getBytes()
        val firstName = t(2).getBytes()
        var p = new Put(rowKey)
        p.add(cf,cq,value)
        p.add(cf,"FirstName".getBytes(),firstName)
        table.put(p)
        table.flushCommits()
        table.close()
      })
    })

    lines.foreachRDD{iter =>{
      iter.map(y =>{
        val row = y.split(",")
        Customer(row(0),row(2),row(6))
      }).toDF.write.mode("append").format("orc").save("/user/hive/warehouse/customer_realtime")

    }}

    lines.print()
    lines.count().print()
    ssc.start
    ssc.awaitTermination()
  }
}
