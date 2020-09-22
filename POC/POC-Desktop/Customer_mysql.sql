## Create table
Create table customer(ID varchar(50),Title varchar(5),FirstName varchar(50),Surname varchar(50),BuildingNumber int,StreetName varchar(50),City varchar(50),State varchar(50),ZIP int,Country varchar(50),Phone varchar(50),eMail varchar(50),Comments varchar(50),DoB varchar(50),Gender varchar(5),DateMod varchar(50))

create table CustomerMapping(id varchar(20),title varchar(5),firstname varchar(50),lastname varchar(50));

## loading the data to the table
load data local infile '/home/bigdata/Downloads/CustomersWithDuplicates.txt' into table customer fields terminated by ',' lines terminated by '\n' ignore 1 rows;

load data local infile '/home/bigdata/Downloads/CustomersMapping.txt' into table CustomerMapping fields terminated by ',' lines terminated by '\n' ignore 1 rows;


sqoop-import --connect jdbc:mysql://localhost:3306/test -username root -password root --table customer 

## Starting hbase thrift server
hbase start thrift
sudo apt-get -y install gcc g++ libxml2-dev  libxslt-dev  libsasl2-dev libsasl2-modules-gssapi-mit  libmysqlclient-dev  python-dev  python-setuptools   libsqlite3-dev ant  libsasl2-dev  libsasl2-modules-gssapi-mit libkrb5-dev libtidy-0.99-0  libldap2-dev libssl-dev
