package com.hero;

import org.apache.hadoop.io.*;

/**
 * Hello world!
 *
 */
public class DataTypeDemo
{
    public static void testText() {
        System.out.println("testText");
        Text text = new Text("Hello Hadoop");
        System.out.println(text.getLength());
        System.out.println(text.find("a"));
        System.out.println(text.toString());
    }

    public static void testArrayWritable() {
        System.out.println("testArrayWritable");
        ArrayWritable arrayWritable = new ArrayWritable(IntWritable.class);
        IntWritable year  = new IntWritable(2021);
        IntWritable month = new IntWritable(1);
        IntWritable day = new IntWritable(26);

        arrayWritable.set(new IntWritable[] {year, month, day});
        System.out.println(String.format("year = %d, month = %d, day = %d",
                ((IntWritable)arrayWritable.get()[0]).get(),
                ((IntWritable)arrayWritable.get()[1]).get(),
                ((IntWritable)arrayWritable.get()[2]).get()));
    }

    public static void testMapWritable() {
        System.out.println("testMapWritable");
        MapWritable mapWritable = new MapWritable();

        Text nameKey = new Text("name");
        Text nameValue = new Text("tony");
        Text passwordKey = new Text("password");

        mapWritable.put(nameKey, nameValue);
        mapWritable.put(passwordKey, NullWritable.get());

        System.out.println(mapWritable.get(nameKey).toString());
        System.out.println(mapWritable.get(passwordKey).toString());
    }


    public static void main( String[] args )
    {
        testText();
        testArrayWritable();
        testMapWritable();
    }
}
