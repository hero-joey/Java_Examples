package com.hero;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;

/**
 * @description: RectangleCountDemo
 * @date: 2021/1/27 13:22
 * @author: maccura
 * @version: 1.0
 */
public class RectangleCountDemo {

    public static class RectangleMapper extends Mapper<LongWritable, Text, RectangleWritable, NullWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] splits = value.toString().split(" ");
            RectangleWritable rectangleWritable = new RectangleWritable(Integer.parseInt(splits[0]),
                    Integer.parseInt(splits[1]));
            context.write(rectangleWritable, NullWritable.get());
        }
    }

    public static class RectangleReducer extends Reducer<RectangleWritable, NullWritable, IntWritable, IntWritable> {
        @Override
        protected void reduce(RectangleWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
            context.write(new IntWritable(key.getLength()), new IntWritable(key.getWidth()));
        }
    }

    public static class RectanglePartition extends Partitioner<RectangleWritable, NullWritable> {
        @Override
        public int getPartition(RectangleWritable rectangleWritable, NullWritable nullWritable, int i) {
            if (rectangleWritable.getLength() == rectangleWritable.getWidth()) {
                return 0;
            } else  {
                return 1;
            }
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();

        String[] otherArgs = new GenericOptionsParser(configuration, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: rectangleCount <in> <out>");
            System.exit(-1);
        }

        JobConf conf = new JobConf();

        Job job = Job.getInstance(conf, "rectangle count");
        job.setJarByClass(RectangleCountDemo.class);
        job.setMapperClass(RectangleMapper.class);
        job.setMapOutputKeyClass(RectangleWritable.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setReducerClass(RectangleReducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);

        job.setPartitionerClass(RectanglePartition.class);
        job.setNumReduceTasks(2);

        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }

        FileOutputFormat.setOutputPath(job, new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true)? 0 : 1);
    }
}
