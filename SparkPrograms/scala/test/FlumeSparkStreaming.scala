package test

/**
  * Created by siva on 4/16/16.
  */

import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.kafka._

object FlumeSparkStreaming extends App{
  val sparkConf = new SparkConf().setAppName("Flume - SparkStreaming")
  //sparkConf.set("spark.driver.allowMultipleContexts","true")
  val ssc = new StreamingContext(sparkConf, Seconds(30))
  val lines = FlumeUtils.createPollingStream(ssc, "localhost", 9999)
  lines.print
  ssc.start
  ssc.awaitTermination()
}
