
package com.hero;
import java.io.IOException;
import java.net.URI;

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

public class DedupDemo {

	static final String INPUT_PATH = "hdfs://hadoop1:9000/mapreduce/dedup";
	static final String OUTPUT_PATH = "hdfs://hadoop1:9000/mapreduce/dedup/result";

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
		job.setJarByClass(DedupDemo.class);

		job.setInputFormatClass(TextInputFormat.class);
		//设置map
		job.setMapperClass(DedupMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);

		//设置reduce
		job.setReducerClass(DedupReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);

		//设置输入格式
		job.setInputFormatClass(TextInputFormat.class);
		Path inputPath = new Path(INPUT_PATH);
		FileInputFormat.addInputPath(job, inputPath);

		//设置输出格式
		job.setOutputFormatClass(TextOutputFormat.class);
		FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));

		System.exit(job.waitForCompletion(true)? 0: 1);
	}

	static class DedupMapper extends
			Mapper<LongWritable, Text, Text, NullWritable> {

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line_content = value.toString();
			if (line_content != null && line_content.length() > 0) {
				System.out.println("map key: " + line_content);
				context.write(value, NullWritable.get());
			}

		}
	}

	static class DedupReducer extends
			Reducer<Text, NullWritable, Text, NullWritable> {
		@Override
		protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
			System.out.println("reduce key: " + key.toString());
			context.write(key, NullWritable.get());
		}
	}

}
