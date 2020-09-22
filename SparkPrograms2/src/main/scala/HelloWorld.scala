/**
  * Created by siva on 4/30/16.
  */
import org.apache.spark.{SparkConf, SparkContext}

object HelloWorld extends App{

  //def main(args:Array[String]): Unit ={
    println("Hello World")

    val sc = new SparkContext(new SparkConf().setMaster("local"))
    var l = sc.parallelize(List("hello Spark","Map Reduce"))
    println(l.map(x=>x.split(" ")))
    println(l.flatMap(x=>x.split(" ")))
    l.flatMap(_.split(" ")).foreach(println)


  //}

}
