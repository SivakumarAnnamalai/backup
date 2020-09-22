import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._ 
val conf = new SparkConf().setAppName("NetworkWordCount")
conf.set("spark.driver.allowMultipleContexts","true")
val ssc = new StreamingContext(conf, Seconds(15))
val lines = ssc.socketTextStream("10.5.113.188", 9999)
ssc.checkpoint("./checkpoints/")
val words = lines.flatMap(_.split(" "))
val pairs = words.map(word => (word, 1))
pairs.print
ssc.start()





val updateFunc = (values: Seq[Int], state: Option[Int]) => {
val currentCount = values.foldLeft(0)(_ + _)
val previousCount = state.getOrElse(0)
Some(currentCount + previousCount)
}
val windowedWordCounts = pairs.updateStateByKey(updateFunc)
windowedWordCounts.saveAsTextFiles("file:///tmp/sout")
windowedWordCounts.print

