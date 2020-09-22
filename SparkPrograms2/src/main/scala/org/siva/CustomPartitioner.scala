package org.siva

import org.apache.spark.Partitioner

/**
  * Created by siva on 5/5/16.
  */
class CustomPartitioner extends Partitioner{
  def numPartitions = 10;

  def getPartition(key: Any): Int ={
    key.toString.length % numPartitions;
  }

  override def equals(other:Any):Boolean=
    other.isInstanceOf[CustomPartitioner]


}
