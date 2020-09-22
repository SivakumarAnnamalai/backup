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
spark-submit --class com.virtusapolaris.BatchProcessV4 /home/bigdata/projects/SparkPrograms/target/spark-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp/customer 

## Run streaming process to insert the data
spark-submit --class com.virtusapolaris.StreamingProcessV4 /home/bigdata/projects/SparkPrograms/target/spark-1.0-SNAPSHOT-jar-with-dependencies.jar

## send data to SparkStreaming from Kafka
head /home/bigdata/Downloads/CustomersData.txt |  kafka-console-producer.sh --broker-list localhost:9092 --topic customer
