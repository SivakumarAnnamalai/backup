## creating directory
hdfs dfs -mkdir /test

## listing the files and directory under root
hdfs dfs -ls /

## create subdirectory dir1 under /test
hdfs dfs -mkdir /test/dir1

## create directory /d1/d2/d3/d4
hdfs dfs -mkdir -p /d1/d2/d3/d4

## list all the files and directories in HDFS
hdfs dfs -ls -R /

## pushing a file to hdfs
hdfs dfs -put /home/bigdata/test.txt /

## push test.txt to /d1/d2 directory
hdfs dfs -put /home/bigdata/test.txt /d1/d2/
hdfs dfs -put /home/bigdata/test.txt /d1/d21

## push test.txt file under /d1 named as test1.txt
hdfs dfs -put /home/bigdata/test.txt /d1/test1.txt

## copy HDFS file /test.txt to under /d1/d2/d3
hdfs dfs -cp /test.txt /d1/d2/d3/

## Rename /test.txt to /test_new.txt
hdfs dfs -mv /test.txt /test_new.txt

## Print contents of the HDFS file /d1/d2/d3/test.txt
hdfs dfs -cat /d1/d2/d3/test.txt

## print size of the file/directory
hdfs dfs -du -s /test.txt
hdfs dfs -du -s /d1

## print size of the file in human readable format
hdfs dfs -du -s -h /d1

## Removing directory
hdfs dfs -rmdir /test 
hdfs dfs -rm -R /d1/d2/d3 


































