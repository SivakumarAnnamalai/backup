package test

import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by siva on 5/1/16.
  */
object Wordcount extends App{
  val runmode = args(0)
  val inputdir = args(1)
  val outputdir = args(2)

  val conf = new SparkConf()
  conf.setMaster(runmode)
  conf.setAppName("Wordcount")

  val sc = new SparkContext(conf)
  val inputRDD = sc.textFile(inputdir)
  val wordsRDD = inputRDD.flatMap(x=>x.split(" "))
  val wordsPairRDD = wordsRDD.map(word=>(word,1))
  val wordCountRDD = wordsPairRDD.reduceByKey((x,y)=>x+y)
  wordCountRDD.saveAsTextFile(outputdir)
}
