package org.siva

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by siva on 5/5/16.
  */
object BroadcastTest {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
    conf.setAppName("Broadcast variable Example")
    val sc = new SparkContext(conf)
    val lookup = Map("CSK"->"ChennaiSuperKings","MI"->"MumbaiIndians","RCB"->"RoyalChallengers")
    val bcLookup = sc.broadcast(lookup)
    val input = Array("CSK","RCB","GL")
    val r1 = sc.parallelize(input)
    val r2 = r1.map(x=>(x,bcLookup.value.get(x)))
    r2.collect.foreach(println)
  }

}
