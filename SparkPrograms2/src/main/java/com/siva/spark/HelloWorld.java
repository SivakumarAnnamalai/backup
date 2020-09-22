package com.siva.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by sivakumaran on 9/27/2016.
 */
public class HelloWorld {
    public static void main(String args[]){
        SparkConf conf = new SparkConf();
        conf.setMaster("local");
        conf.setAppName("Spark Test in Java");
        JavaSparkContext javaSparkContext  = new JavaSparkContext(conf);
        JavaRDD<String> lines = javaSparkContext.textFile("test.txt");
        System.out.println(lines.count());
        System.out.println(lines.collect());
        //System.out.println(lines.map());
    }
}
