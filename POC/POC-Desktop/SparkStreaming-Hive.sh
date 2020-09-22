hiveContext.sql("create table customer_realtime (id string,firstname string,city string) stored as orc")








import org.apache.spark.sql.hive.orc._
import org.apache.spark.sql._
val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)
hiveContext.sql("create table yahoo_orc_table (date STRING, open_price FLOAT, high_price FLOAT, low_price FLOAT, close_price FLOAT, volume INT, adj_price FLOAT) stored as orc")
val yahoo_stocks = sc.textFile("hdfs://sandbox.hortonworks.com:8020/tmp/yahoo_stocks.csv")
val header = yahoo_stocks.first
val data = yahoo_stocks.filter(_ != header)
case class YahooStockPrice(date: String, open: Float, high: Float, low: Float, close: Float, volume: Integer, adjClose: Float)
val stockprice = data.map(_.split(",")).map(row => YahooStockPrice(row(0), row(1).trim.toFloat, row(2).trim.toFloat, row(3).trim.toFloat, row(4).trim.toFloat, row(5).trim.toInt, row(6).trim.toFloat)).toDF()
stockprice.registerTempTable("yahoo_stocks_temp")
val results = sqlContext.sql("SELECT * FROM yahoo_stocks_temp")

results.write.format("orc").save("yahoo_stocks_orc")
val yahoo_stocks_orc = hiveContext.read.format("orc").load("yahoo_stocks_orc")
yahoo_stocks_orc.registerTempTable("orcTest")
hiveContext.sql("SELECT * from orcTest").collect.foreach(println)




