
package com.hero;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class RectangleSortDemo {

	static final String INPUT_PATH = "hdfs://hadoop1:9000/mapreduce/rectangle";
	static final String OUTPUT_PATH = "hdfs://hadoop1:9000/mapreduce/rectangle/result";

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
		job.setJarByClass(RectangleSortDemo.class);

		job.setInputFormatClass(TextInputFormat.class);
		//设置map
		job.setMapperClass(RectangleMapper.class);
		job.setMapOutputKeyClass(RectangleWritable.class);
		job.setMapOutputValueClass(NullWritable.class);

		//设置reduce
		job.setReducerClass(RectangleReducer.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);

		//设置输入格式
		job.setInputFormatClass(TextInputFormat.class);
		Path inputPath = new Path(INPUT_PATH);
		FileInputFormat.addInputPath(job, inputPath);

		//设置输出格式
		job.setOutputFormatClass(TextOutputFormat.class);
		FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));

	//	FileOutputFormat.setCompressOutput(job, true); // job使用压缩
	//	FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class); // 设置压缩格式

		job.setPartitionerClass(RectanglePatitioner.class);
		job.setNumReduceTasks(2);
		job.waitForCompletion(true);
	}

	static class RectangleMapper extends
			Mapper<LongWritable, Text, RectangleWritable, NullWritable> {

		protected void map(LongWritable k1, Text v1, Context context)
				throws IOException, InterruptedException {
			String[] splits = v1.toString().split(" ");
			RectangleWritable k2 = new RectangleWritable(
					Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
			context.write(k2, NullWritable.get());
		}
	}

	static class RectangleReducer extends
			Reducer<RectangleWritable, NullWritable, IntWritable, IntWritable> {
		protected void reduce(RectangleWritable k2, Iterable<NullWritable> v2s,
				Context context) throws IOException, InterruptedException {
			context.write(new IntWritable(k2.getLength()),
					new IntWritable(k2.getWidth()));
		}
	}

}

class RectangleWritable implements WritableComparable<RectangleWritable> {

	int length, width;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public RectangleWritable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RectangleWritable(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

 
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(length);
		out.writeInt(width);
	}

	 
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.length = in.readInt();
		this.width = in.readInt();

	}

	 
	public int compareTo(RectangleWritable rectangleWritable) {
		// TODO Auto-generated method stub
		return Integer.compare(this.getLength() * this.getWidth(), rectangleWritable.getLength() * rectangleWritable.getWidth());
	}

}

	class RectanglePatitioner extends Partitioner<RectangleWritable, NullWritable> {
	@Override
	public int getPartition(RectangleWritable k2, NullWritable v2,
			int numReduceTasks) {

		if (k2.getLength() == k2.getWidth()) {
			return 0; // 正方式在任务0中汇总
		} else
			return 1;// 长方式在任务1中汇总
	}
}