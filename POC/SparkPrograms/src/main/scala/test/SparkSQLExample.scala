package test

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by siva on 5/7/16.
  */
object SparkSQLExample extends App{
  val conf = new SparkConf()
  conf.setAppName("Spark SQL Example")
  val sc = new SparkContext(conf)
  val sqlContext = new SQLContext(sc)

  val df = sqlContext.read.json("file:///home/siva/ApacheProjects" +
    "/spark/examples/src/main/resources/people.json")
  df.show()
  df.printSchema()
  df.select("name").show()
  df.groupBy("age").count().show()

//  val hbaseContext = new HBaseContext(sc, config);
//  hbaseContext.bulkDelete[Array[Byte]](rdd,
 //   tableName,
 //   putRecord => new Delete(putRecord),
  //  4);

}
