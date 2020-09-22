package org.siva

import org.apache.spark._
import org.apache.spark.rdd.NewHadoopRDD
import org.apache.hadoop.hbase.{HBaseConfiguration, HTableDescriptor}
import org.apache.hadoop.hbase.client.HBaseAdmin
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HColumnDescriptor
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.mapred.JobConf
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.hbase.KeyValue
import org.apache.hadoop.hbase.mapreduce.HFileOutputFormat
import org.apache.hadoop.hbase.mapreduce.LoadIncrementalHFiles

/**
  * Created by bigdata on 20/5/16.
  */
object HBaseWithSpark extends App{
  val conf = HBaseConfiguration.create()
  val tableName = args(0)
  val outdir = args(1)
  val table = new HTable(conf, tableName)

  val sc = new SparkContext()
  sc.setLogLevel("WARN")

  conf.set(TableOutputFormat.OUTPUT_TABLE, tableName)
  val job = Job.getInstance(conf)
  job.setMapOutputKeyClass (classOf[ImmutableBytesWritable])
  job.setMapOutputValueClass (classOf[KeyValue])
  HFileOutputFormat.configureIncrementalLoad (job, table)

  // Generate 10 sample data:
  val num = sc.parallelize(Array("row1","row2","row3"))
  val rdd = num.map(x=>{
    val kv: KeyValue = new KeyValue(x.toString.getBytes, "cf".getBytes(), "c1".getBytes(), x.toString.getBytes() )
    (new ImmutableBytesWritable(Bytes.toBytes(x)), kv)
  })

  // Save Hfiles on HDFS
  //rdd.saveAsNewAPIHadoopFile(outdir, classOf[ImmutableBytesWritable], classOf[KeyValue], classOf[HFileOutputFormat], conf)
  rdd.saveAsNewAPIHadoopFile(outdir, classOf[ImmutableBytesWritable], classOf[KeyValue], classOf[HFileOutputFormat], job.getConfiguration())

  //Bulk load Hfiles to Hbase
  val bulkLoader = new LoadIncrementalHFiles(conf)
  bulkLoader.doBulkLoad(new Path(outdir), table)
}
