HBASE_PATH=`$HBASE_HOME/bin/hbase classpath`
spark-shell --driver-class-path $HBASE_PATH

import org.apache.hadoop.hbase.HBaseConfiguration
val conf = HBaseConfiguration.create()
val tableName="spark_table"
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
conf.set(TableInputFormat.INPUT_TABLE,tableName)
import org.apache.hadoop.hbase.client.HBaseAdmin
val admin = new HBaseAdmin(conf)
admin.isTableAvailable(tableName)

## Table creation
import org.apache.hadoop.hbase.{HTableDescriptor, HColumnDescriptor}
val tableDesc = new HTableDescriptor(tableName)
tableDesc.addFamily(new HColumnDescriptor("cf".getBytes()))
admin.createTable(tableDesc)

## insert data
import org.apache.hadoop.hbase.client.{HTable,Put}
val table = new HTable(conf, tableName)
var row = new Put("dummy".getBytes())
row.add("cf".getBytes(), "content".getBytes(), "Test data".getBytes())
table.put(row)
table.flushCommits()

## get Data
import org.apache.hadoop.hbase.HBaseConfiguration
val conf = HBaseConfiguration.create()
val tableName="customer_realtime"
import org.apache.hadoop.hbase.client.{HTable,Put}
val table = new HTable(conf, tableName)


val filesRDD = sc.wholeTextFiles("hdfs://localhost/fedora/TextFiles")
filesRDD.foreachPartition { iter =>
 val hbaseConf = HBaseConfiguration.create()
 val table = new HTable(hbaseConf, tableName)
 iter.foreach { x =>
 var p = new Put(x._1.getBytes())
 p.add("cf".getBytes(),"content".getBytes(),x._2.getBytes())
 table.put(p)
 }}



val conf = HBaseConfiguration.create()
conf.set(TableInputFormat.INPUT_TABLE, "students")
val r1=sc.textFile("file:///home/bigdata/students.txt")
val r2 = r1.map(x=>{val y=x.split(" ");(y(0),y(1))})


## Apache phoenix
## login
sqlline.py localhost:2181
## Queries
create view "hao" (pk varchar primary key,"cf"."c1" varchar);
create view "customer" (pk varchar primary key,"cf1"."City"
 varchar,"cf1"."Phone" varchar);
create view "customer_realtime" (pk varchar primary key,"cf1"."City"
 varchar,"cf1"."FirstName");

select "City",count(*) as cnt from "customer" group by "City" having count(*)>5 order by cnt desc limit 10;


spark-submit --class com.virtusapolaris.StreamingProcess /home/bigdata/projects/SparkPrograms/target/spark-1.0-SNAPSHOT-jar-with-dependencies.jar



## Header details
ID,Title,FirstName,Surname,BuildingNumber,StreetName,City,State,ZIP,Country,Phone,eMail,Comments,DoB,Gender,DateMod

   // case class Customer(ID:String,Title:String,FirstName:String,Surname:String,
              //          BuildingNumber:String,StreetName:String,City:String,State:String,
                   //     ZIP:Int,Country:String,Phone:String,eMail:String,Comments:String,
                    //    DoB:String,Gender:String,DateMod:String)



val dStream = ssc.socketTextStream("localhost", 9999, StorageLevel.MEMORY_AND_DISK_SER)

dStream.filter(_.contains("ERROR")).map( s => (s.split(" ")(0), 1) ).reduceByKey(_+_)




