package org.siva

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by siva on 5/5/16.
  */
object AccumulatorTest{
  def main(args:Array[String]) {
    val conf = new SparkConf()
    conf.setAppName("Accumulator Example")

    val sc = new SparkContext(conf)
    var i = 0;
    val accum = sc.accumulator(0)
    val a = Array(1, 2, 3, 4)
    println("Value before operation: " + accum + " " + i)
    val r1 = sc.parallelize(a)
    r1.reduce((x,y)=>{accum+=1;i+=1;x+y})
    println("Value after operation: " + accum + " "+i)
  }
}
