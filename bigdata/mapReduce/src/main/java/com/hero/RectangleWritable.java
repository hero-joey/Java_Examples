package com.hero;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @description: RectangleWritable
 * @date: 2021/1/27 11:08
 * @author: maccura
 * @version: 1.0
 */
public class RectangleWritable implements WritableComparable<RectangleWritable> {
    private int length;
    private int width;

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
    }

    public RectangleWritable(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int compareTo(RectangleWritable rectangleWritable) {
        return Integer.compare(this.length * this.width, rectangleWritable.getLength() * rectangleWritable.getWidth());
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.write(length);
        dataOutput.write(width);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.length = dataInput.readInt();
        this.width = dataInput.readInt();
    }
}
