package com.virtusa;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

/**
 * Created by sivakumaran on 9/28/2016.
 */
public class DataIngestV1 {
    public static void main(String args[]) throws IOException {
        if(args.length!=2){
            System.out.println("Please provide two arguments source and target");
            System.out.println("USAGE: java DataIngestV1 /data/file1.csv /rawdata/20160928/");
            System.exit(1);
        }

        // input file
        String source = args[0];

        //output dir
        String target = args[1];

        //Input stream for the file in local file system to be written to HDFS
        InputStream in = new BufferedInputStream(new FileInputStream(source));

        //Get configuration of Hadoop system
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://localhost:8020/");

       //Destination file in HDFS
        FileSystem fs = FileSystem.get(URI.create(target), conf);
        OutputStream out = fs.create(new Path(target));

        //Copy file from local to HDFS
        IOUtils.copyBytes(in, out, 4096, true);

        System.out.println(target + " copied to HDFS");
    }
}
