import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by siva on 5/7/16.
  */
object SparkStreamingExample {

  def main(args:Array[String]): Unit ={

    val conf = new SparkConf();
    val ssc = new StreamingContext(conf, Seconds(2))
    val lines = ssc.socketTextStream("localhost", 9999)
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()

  }
}
