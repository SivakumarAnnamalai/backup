package org.siva

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by siva on 5/5/16.
  */
object MapPartitionsTest extends App{

  val conf = new SparkConf()
  conf.setAppName("Map Partitions Example")
  val sc = new SparkContext(conf)

  val a = Array(1,2,3,4,5,6)
  val r1 = sc.parallelize(a)
  val r2 = r1.mapPartitions(x=>{var y=10;x.map(_+y)})
  r2.collect().foreach(println)

}
