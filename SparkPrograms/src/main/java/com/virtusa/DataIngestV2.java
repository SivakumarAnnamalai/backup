package com.virtusa;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

/**
 * Created by sivakumar annamalai on 9/28/2016.
 */
public class DataIngestV2 {
    public static void main(String args[]) throws IOException {
        if(args.length!=2){
            System.out.println("Please provide two arguments source(file/dir) and targetdir");
            System.out.println("USAGE: java DataIngestV2 /data/file1.csv /rawdata/20160928");
            System.exit(1);
        }

        // input file/dir
        String source = args[0];

        //output dir
        String target = args[1];

        //Get configuration of Hadoop system
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.1.6:8020/");

        File path = new File(source);
        if(path.isFile()){
            writeFileToHDFS(source,target,conf);
        }else if(path.isDirectory()){
            for(File file:path.listFiles()){
                writeFileToHDFS(file.getAbsolutePath(),target,conf);
            }
        }
    }

    public static void writeFileToHDFS(String source,String target,Configuration conf){

        try {
            //Input stream for the file in local file system to be written to HDFS
            InputStream in = new BufferedInputStream(new FileInputStream(source));

            String targetFile = target+"/"+source.substring(source.lastIndexOf("\\")+1);
            //System.out.println(source+targetFile);
            //Destination file in HDFS
            FileSystem fs = FileSystem.get(URI.create(targetFile), conf);
            OutputStream out = fs.create(new Path(targetFile));

            //Copy file from local to HDFS
            IOUtils.copyBytes(in, out, 4096, true);
        }catch (IOException e){
            System.out.println("Error occured while pushing the file "+source+" to HDFS");
            System.out.println("Error Details: "+e.getMessage());
            return;
        }
        System.out.println(source + " copied to HDFS Successfully");
    }
}
