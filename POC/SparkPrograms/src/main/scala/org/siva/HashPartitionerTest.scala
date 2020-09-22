package org.siva

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
  * Created by siva on 5/5/16.
  */
object HashPartitionerTest extends App{

  val conf = new SparkConf()
  conf.setAppName("HashPartitioner Example")
  val sc = new SparkContext(conf)

  val r1 = sc.textFile("/home/bigdata/test.txt")
  val r2 = r1.flatMap(_.split(" ")).map((_,1))
  r2.saveAsTextFile("/tmp/out1")

  r2.partitionBy(new HashPartitioner(2)).saveAsTextFile("/tmp/out2")

  //r2.partitionBy(new CustomPartitioner).saveAsTextFile("/tmp/out3")
}
