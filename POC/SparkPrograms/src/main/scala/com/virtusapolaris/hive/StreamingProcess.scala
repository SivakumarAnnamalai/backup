package com.virtusapolaris.hive

/**
  * Created by siva on 23/5/16.
  */

import org.apache.spark.SparkConf
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka._

object StreamingProcess{
  case class Customer(id:String,firstName:String,city:String)

  def main(args:Array[String]): Unit ={

    val sparkConf = new SparkConf().setAppName("Lambda Architecture Streaming Data")
    val ssc = new StreamingContext(sparkConf, Seconds(2))
    val (zkQuorum,group,topics) = ("localhost:2181","test-consumer-group",Map("customer"->1))
    val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topics).map(_._2)
    val tableName="customer_realtime"
    val hiveContext = new HiveContext(ssc.sparkContext)
    import hiveContext.implicits._

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
