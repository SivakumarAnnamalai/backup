package test

/**
  * Created by siva on 4/16/16.
  */

import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka._
object KafkaSparkStreaming extends App{
  val sparkConf = new SparkConf().setAppName("KafkaWordCount")
  //sparkConf.set("spark.driver.allowMultipleContexts","true")
  val ssc = new StreamingContext(sparkConf, Seconds(6))
  val (zkQuorum,group,topics) = ("localhost:2181","test-consumer-group",Map("test"->1))
  val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topics).map(_._2)
  lines.print
  lines.saveAsTextFiles("StreamData")
  ssc.start
  ssc.awaitTermination()
}
