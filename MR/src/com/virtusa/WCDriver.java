package com.virtusa;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WCDriver {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException{
		
		Job job = Job.getInstance();
		
		FileInputFormat.addInputPath(job, new Path("/test.txt"));
		FileOutputFormat.setOutputPath(job, new Path("/wout1"));
		
		job.setMapperClass(WCMapper.class);
		job.setReducerClass(WCReducer.class);
		job.setJarByClass(WCDriver.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		job.setJobName("Simple Wordcount example");
				
		job.waitForCompletion(true);
		
		
	}

}
