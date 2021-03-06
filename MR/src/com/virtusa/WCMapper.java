package com.virtusa;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCMapper extends Mapper<LongWritable,Text,Text,LongWritable> {
	
	@Override
	public void map(LongWritable key,Text value, Context context) 
			throws IOException, InterruptedException{
		
		String words[] = value.toString().split(" ");
		
		for(String word:words){
			
			Text outputKey = new Text(word);
			LongWritable outputValue = new LongWritable(1);
			
			context.write(outputKey, outputValue);
		}
		
	}

}
