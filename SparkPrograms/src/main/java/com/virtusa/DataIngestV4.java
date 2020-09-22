package com.virtusa;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by sivakumar annamalai on 9/28/2016.
 */

public class DataIngestV4 {
    private static final String FILE_FORMAT = "csv";
    private static final String FILE_PREFIX = "customers";
    private static final String NAMENODE_PROPERTY ="fs.defaultFS";
    private static final String NAMENODE ="hdfs://192.168.1.2:8020";
    private static final String EXPECTED_HEADERS[] ={"ID","TransDesc","TransRecordID","Currency","Date Of Feed Trade","Max no of Trades","Approval Date","Approval Time","Approval Name","Risk Staus"};
    private static final String SLASH="\\";

    public static void main(String args[]) throws IOException {
        if(args.length!=4){
            System.out.println("Please provide Four arguments source(file/dir) targetdir ArchivalDir ArchivalFailureDir");
            System.out.println("Target dir is in HDFS and others are LFS");
            System.out.println("USAGE: java DataIngestV3 /data/file1.csv /rawdata/20160928 /archival/success /archival/failure");
            System.exit(1);
        }

        // input file/dir
        String source = args[0];

        //target dir
        String targetDir = args[1];

        // Archival success and failure dir
        String successDir = args[2];
        String failureDir = args[3];

        //Get configuration of Hadoop system
        Configuration conf = new Configuration();
        conf.set(NAMENODE_PROPERTY,NAMENODE);

        File path = new File(source);
        if(path.isFile()){
            writeFileToHDFS(source,targetDir,conf,successDir,failureDir);
        }else if(path.isDirectory()){
            for(File file:path.listFiles()){
                System.out.println("Processing file "+file.getAbsolutePath());
                writeFileToHDFS(file.getAbsolutePath(),targetDir,conf,successDir,failureDir);
            }
        }
    }

    // Method used to write the data to HDFS
    public static void writeFileToHDFS(String source,String target,Configuration conf,String successDir, String failureDir) throws IOException {
        // Checking the file details
        if (fileCheck(source)) {
            long count = Files.lines(Paths.get(source)).count();
            System.out.println("Number of lines in the file: "+count);
            try {
                //Input stream for the file in local file system to be written to HDFS
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source));
                if(!fileHeaderCheck(source,inputStream))
                    return;
                String targetFile = target + "/" + source.substring(source.lastIndexOf(SLASH) + 1);
                //Destination file in HDFS
                FileSystem fs = FileSystem.get(URI.create(targetFile), conf);
                OutputStream outputStream = fs.create(new Path(targetFile));

                //Copy file from local to HDFS
                IOUtils.copyBytes(inputStream, outputStream, 4096, true);
            } catch (IOException e) {
                System.err.println("Error occured while pushing the file " + source + " to HDFS "+e.getMessage());
                return;
            }
            System.out.println(source + " copied to HDFS Successfully");
            moveFile(source,successDir);
        }else {
            //moveFile();
            System.err.println(source + " File is not satisfying the format or filename");
            moveFile(source,failureDir);
        }
    }

    // Method used to check the file level condition
    public static boolean fileCheck(String source){
        String fileName = source.substring(source.lastIndexOf(SLASH)+1);
        if(fileName!= null && fileName.endsWith(FILE_FORMAT) && fileName.startsWith(FILE_PREFIX))
            return true;
        else
            return false;
    }

    // Method used to check file header
    public static boolean fileHeaderCheck(String source,InputStream inputStream) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        String header = r.readLine();
        String[] actualHeaders = header.split(",");
        if(EXPECTED_HEADERS.length == actualHeaders.length) {
            for (int i = 0; i<EXPECTED_HEADERS.length; i++){
                if(!EXPECTED_HEADERS[i].equals(actualHeaders[i]))
                    return false;
                else
                    System.err.println("Expected header name not matching with actual header in the file "+source);
            }
        }else {
            System.err.println("Expected number of headers not equal to Actual headers in the file "+source);
        }
        return true;
    }
    public static void moveFile(String source,String target){
        File sourceFile =new File(source);
        sourceFile.renameTo(new File(target + "/"+sourceFile.getName()));
        //System.out.println("File moved to Backup location successfully");
    }
}
