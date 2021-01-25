package com.hero;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Hello world!
 *
 */
public class HadoopApp
{
    static FileSystem getFileSystem() throws Exception {
        URI uri = new URI("hdfs://hadoop1:9000/");
        // 使用HDFS文件系统并提供服务器路径，端口号在core-site.xml中配置
        Configuration configuration = new Configuration();
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        return FileSystem.get(uri, configuration);
    }

    public static void createDirectory() throws Exception {
       FileSystem fileSystem = getFileSystem();
       Path directoryPath = new Path("/dir/create");
       fileSystem.mkdirs(directoryPath);
    }

    public static void createFile() throws Exception {
        byte[] buff = "Hello Daxiong\n".getBytes();
        FileSystem hdfs = getFileSystem();
        Path filePath = new Path("/test/create");
        FSDataOutputStream outputStream = hdfs.create(filePath);
        outputStream.write(buff, 0, buff.length);
        outputStream.close();

    }

    public static void main( String[] args )
    {
        try {
            createFile();
            createDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
