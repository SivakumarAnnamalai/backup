package com.virtusa;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by sivakumaran on 10/2/2016.
 */
public class DataProfiling {
    private static final String PROFILING_TABLE_NAME = "transaction";
    private static final String PROFILING_CURRENCY_TABLE_NAME = "transaction_by_currency";

    public static void main(String args[]){
        if(args.length!=2){
            System.out.println("Please provide two arguments source(file/dir) in HDFS and Timestamp for report");
            System.out.println("USAGE: spark-submit --class com.virtusa.DataProfiling jarlocation /data/20161002 201610021220");
            System.exit(1);
        }

        String source = args[0];
        String timestamp = args[1];
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("Data Profiling");
        //sparkConf.setMaster("local");

        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        javaSparkContext.setLogLevel("WARN");

        SQLContext sqlContext = new HiveContext(javaSparkContext);
        DataFrame inputDF = sqlContext.read().format("csv").option("header","true").load(source);
        //dataFrame.show();

        //dataFrame.describe("ID","TransDesc","TransRecordID","Currency").show();
        inputDF.registerTempTable("customer");
        String idQuery = "select "+timestamp+" as timestamp,'ID' as summary,count(1) as count,count(distinct(ID)) as Unique,'NA' as sum,'NA' as min,'NA' as max,'NA' as avg from customer union all ";
        String transDescQuery = "select "+timestamp+" as timestamp,'TransDesc' as summary,count(1) as count,count(distinct(ID)) as Unique,'NA' as sum,'NA' as min,'NA' as max,'NA' as avg from customer union all ";
        String transRecordIDQuery = "select "+timestamp+" as timestamp,'TransRecordID' as summary,count(1) as count,count(distinct(ID)) as Unique,sum(TransRecordID) as sum,min(TransRecordID) as min,max(TransRecordID) as max,avg(TransRecordID) as avg from customer  union all ";
        String currencyQuery = "select "+timestamp+" as timestamp,'Currency' as summary,count(1) as count,count(distinct(ID)) as Unique,'NA' as sum,'NA' as min,'NA' as max,'NA' as avg from customer union all ";
        String dateOfFeedTradeQuery = "select "+timestamp+" as timestamp,'DateOfFeedTrade' as summary,count(1) as count,count(distinct(ID)) as Unique,'NA' as sum,'NA' as min,'NA' as max,'NA' as avg from customer union all ";
        String maxNoOfTradesQuery = "select "+timestamp+" as timestamp,'MaxNoOfTrades' as summary,count(1) as count,count(distinct(ID)) as Unique,sum(`Max no of Trades`) as sum,min(`Max no of Trades`) as min,max(`Max no of Trades`) as max,avg(`Max no of Trades`) as avg from customer union all ";
        String approvalDateQuery = "select "+timestamp+" as timestamp,'ApprovalDate' as summary,count(1) as count,count(distinct(ID)) as Unique,'NA' as sum,'NA' as min,'NA' as max,'NA' as avg from customer union all ";
        //String approvalTimeQuery = "select "+timestamp+" as timestamp,'ApprovalTime' as summary,count(1) as count,count(distinct(ID)) as Unique,'NA' as sum,'NA' as min,'NA' as max,'NA' as avg from customer union all ";
        String riskStatusQuery = "select "+timestamp+" as timestamp,'RiskStatus' as summary,count(1) as count,count(distinct(ID)) as Unique,'NA' as sum,'NA' as min,'NA' as max,'NA' as avg from customer";

        // overall profiling
        DataFrame profilingDF = sqlContext.sql(idQuery+transDescQuery+transRecordIDQuery+currencyQuery+dateOfFeedTradeQuery+maxNoOfTradesQuery+approvalDateQuery+riskStatusQuery);
        profilingDF.show();
        //profilingDF.write().mode(SaveMode.Append).saveAsTable(PROFILING_TABLE_NAME);
        //profilingDF.write().mode(SaveMode.Append).json("/tmp/total/out1");

        // Currency level profiling
        DataFrame currencyDF = sqlContext.sql("select "+timestamp+" as timestamp,Currency,count(*) as count,sum(`Max no of Trades`) as TotalTrades,avg(`Max no of Trades`) AvgTrade,max(`Max no of Trades`) MaxTrade,min(`Max no of Trades`) MinTrade from customer group by Currency");
        currencyDF.show();
        //currencyDF.write().mode(SaveMode.Append).saveAsTable(PROFILING_CURRENCY_TABLE_NAME);
        currencyDF.write().mode(SaveMode.Append).json("/tmp/currency/out1");

    }
}
