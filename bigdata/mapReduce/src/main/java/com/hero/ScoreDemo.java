
package com.hero;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Spliterators;
import java.util.StringTokenizer;

public class ScoreDemo {

	static final String INPUT_PATH = "hdfs://hadoop1:9000/mapreduce/score";
	static final String OUTPUT_PATH = "hdfs://hadoop1:9000/mapreduce/score/result";

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf);

		//清空输出目录
		Path outputPath = new Path(OUTPUT_PATH);
		if (fileSystem.exists(outputPath)) {
			fileSystem.delete(outputPath, true);
		}


		Job job = Job.getInstance(conf, "Rectangle Sort");
		//运行jar类
		job.setJarByClass(ScoreDemo.class);

		job.setInputFormatClass(TextInputFormat.class);
		//设置map
		job.setMapperClass(ScoreMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		//设置reduce
		job.setReducerClass(ScoreReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		//设置输入格式
		job.setInputFormatClass(TextInputFormat.class);
		Path inputPath = new Path(INPUT_PATH);
		FileInputFormat.addInputPath(job, inputPath);

		//设置输出格式
		job.setOutputFormatClass(TextOutputFormat.class);
		FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

	static class ScoreMapper extends
			Mapper<LongWritable, Text, Text, IntWritable> {
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line_content = value.toString();
			if (line_content != null && line_content.length() > 0) {
				String[] splits = line_content.split(" ");
				String name = splits[0];
				int score = Integer.parseInt(splits[1]);
				System.out.println("name: " + name + "score: " + score);
				context.write(new Text(name), new IntWritable(score));
			}
		}
	}


	static class ScoreReducer extends
			Reducer<Text, IntWritable, Text, IntWritable> {
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int sum = 0;
			int count = 0;
			for (IntWritable value : values) {
				sum += value.get();
				count++;
			}
			int average = sum / count;
			context.write(key, new IntWritable(average));
		}

	}
}
