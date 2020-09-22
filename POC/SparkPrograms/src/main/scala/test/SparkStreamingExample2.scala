package test

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by siva on 5/7/16.
  */
object SparkStreamingExample2 {

  def main(args:Array[String]): Unit ={

    val conf = new SparkConf();
    val ssc = new StreamingContext(conf, Seconds(5))
    val lines = ssc.textFileStream("file:///home/bigdata/" +
      "SparkStreamingSource")
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()

  }
}
