import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by siva on 5/1/16.
  */
object Wordcount extends App{
 /* if(args.length !=3){
    println("Invalid input. Provide three arguments")
    println("Usage: Wordcount local inputdir outputdir")
    System.exit(1)
  }*/
  val runmode = "local"
  val inputdir = "test.txt"
  val outputdir = "out1"

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
