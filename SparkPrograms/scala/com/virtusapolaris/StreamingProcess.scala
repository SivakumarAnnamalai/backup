package com.virtusapolaris

/**
  * Created by siva on 23/5/16.
  */

import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka._
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{HTable, Put}

object StreamingProcess{
  def main(args:Array[String]): Unit ={

    val sparkConf = new SparkConf().setAppName("Lambda Architecture Streaming Data")
    val ssc = new StreamingContext(sparkConf, Seconds(2))
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

    /*lines.foreachRDD(iter =>
      iter.foreachPartition(x =>{
        if(x.length>0){
          println("Inside loop"+x.length)
          val tableName="customer_realtime"
          val hbaseConf = HBaseConfiguration.create()
          val table = new HTable(hbaseConf, tableName)
          val cf = "cf1".getBytes()
          val cq = "city".getBytes()
          x.foreach(y => {
            println("Inside hbase insertition loop")
            var t = y.split(",")
            val rowKey = t(0).getBytes()
            val value = t(6).getBytes()
            println(" Derived details: "+rowKey+" "+value)
            var p = new Put(rowKey)
            p.add(cf,cq,value)
            table.put(p)
            table.flushCommits()
          })
        }
      })*/

    lines.print()
    ssc.start
    ssc.awaitTermination()
  }
}
