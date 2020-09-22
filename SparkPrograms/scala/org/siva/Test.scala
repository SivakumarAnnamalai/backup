package org.siva

import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.SparkContext

/**
  * Created by bigdata on 10/5/16.
  */
object Test extends App{
  for(x <- 1 to 10)
    println(x+ " "+x.toString+" "+Bytes.toBytes(x)+ " "+x.toString.getBytes());
}
