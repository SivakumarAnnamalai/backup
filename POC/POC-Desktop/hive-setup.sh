setting up hive
1) extract hive tarball
2) set hive home in bashrc
export HIVE_HOME=/home/bigdata/TrainingPackages/hive/apache-hive-2.0.0-bin
export PATH=$HIVE_HOME/bin:$PATH
3) setup metastore
cd $HIVE_HOME/scripts/metastore/upgrade/mysql
mysql -uroot -proot -e "create database metastore;use metastore;source hive-schema-2.0.0.mysql.sql;show tables"
4) copy hive-site.xml to conf
cp /home/bigdata/TrainingPackages/hive/hive-site.xml $HIVE_HOME/conf/
cp /home/bigdata/TrainingPackages/hive/hive-site.xml $SPARK_HOME/conf/
5) copy mysql connector to lib
cp /home/bigdata/TrainingPackages/hive/mysql-connector-java-5.1.27.jar $HIVE_HOME/lib/
cp /home/bigdata/TrainingPackages/hive/mysql-connector-java-5.1.27.jar $SPARK_HOME/lib/

