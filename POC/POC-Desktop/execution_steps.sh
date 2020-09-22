Startup steps
1) Start hadoop - start-all.sh
2) Start hbase - start-hbase.sh
3) Start hive metastore - nohup hive --service metastore &
4) Start Kafka broker - kafka-server-start.sh $KAFKA_HOME/config/server.properties
5) Start phoenix Shell - sqlline.py localhost:2181
## import data into HDFS using sqoop
hdfs dfs -rm -R /tmp/customer
sqoop-import --connect jdbc:mysql://localhost:3306/test -username root -password root --table customer -m 1 --target-dir /tmp/customer


## Run Batch process to insert the data
spark-submit --class com.virtusapolaris.BatchProcessV4 /home/bigdata/projects/SparkPrograms/target/spark-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp/customer /tmp/out2 

## Run streaming process to insert the data
spark-submit --class com.virtusapolaris.StreamingProcessV4 /home/bigdata/projects/SparkPrograms/target/spark-1.0-SNAPSHOT-jar-with-dependencies.jar

## send data to SparkStreaming from Kafka
head /home/bigdata/Downloads/CustomersData.txt |  kafka-console-producer.sh --broker-list localhost:9092 --topic customer

## 
spark-submit --class test.FlumeSparkStreaming /home/bigdata/projects/SparkPrograms/target/spark-1.0-SNAPSHOT-jar-with-dependencies.jar

## Modified File
head /home/bigdata/Downloads/CustomersWithDuplicates.txt | awk -F',' '{print $1","$2","substr(rand(),6)*100","$3","$4","$5","$6","$7","$8","$9","$10","$10","$11","$12","$13","$14","$15","$16}'

cat /home/bigdata/Downloads/CustomersWithDuplicates.txt | awk -F',' '{print $1","substr(rand(),6)*100","$5","$6","$7","$8","$9","$10","$11","$12","$13","$14","$15","$16}' > /home/bigdata/Downloads/CustomersData.txt

cat /home/bigdata/Downloads/CustomersWithDuplicates.txt | awk -F',' '{print $1","$2","$3","$4}' > /home/bigdata/Downloads/CustomersMapping.txt

## Wordcount example in spark
spark-submit --class  org.apache.spark.examples.JavaWordCount spark-examples-1.6.0-hadoop2.6.0.jar /test.txt



