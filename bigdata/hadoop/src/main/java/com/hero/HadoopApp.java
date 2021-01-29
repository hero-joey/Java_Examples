package com.hero;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

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
        //configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        return FileSystem.get(uri, configuration);
    }

    public static void createDirectory() throws Exception {
       FileSystem hdfs = getFileSystem();
       Path directoryPath = new Path("/dir/create");
        hdfs.mkdirs(directoryPath);
    }

    public static void createFile() throws Exception {
        byte[] buff = "Hello Daxiong\n".getBytes();
        FileSystem hdfs = getFileSystem();
        Path filePath = new Path("/test/create");
        FSDataOutputStream outputStream = hdfs.create(filePath);
        outputStream.write(buff, 0, buff.length);
        outputStream.close();

    }

    public static void putFile() throws Exception {
        FileSystem hdfs = getFileSystem();

        Path delPath = new Path("/test/onlineupgrade");
        FileStatus[] fileStatuses = hdfs.listStatus(delPath);
        for (FileStatus fileStatus : fileStatuses) {
            System.out.println(fileStatus.getPath());
            System.out.println(fileStatus.getLen());
            System.out.println(fileStatus.getOwner());
        }

        hdfs.delete(delPath, true);
        Path srcPath = new Path("f://mysql-community-release-el7-5.noarch.rpm");
        Path dstPath = new Path("/test/onlineupgrade/mysql-community-release-el7-5.noarch.rpm");
        hdfs.copyFromLocalFile(srcPath, dstPath);
    }

    public static void getFile() throws Exception {
        FileSystem hdfs = getFileSystem();

        Path srcPath = new Path("/test/onlineupgrade/mysql-community-release-el7-5.noarch.rpm");
        Path dstPath = new Path("G://test");
        hdfs.copyToLocalFile(srcPath, dstPath);
    }

    public static void renameFile() throws Exception {
        FileSystem hdfs = getFileSystem();

        Path srcPath = new Path("/test/onlineupgrade/mysql-community-release-el7-5.noarch.rpm");
        Path dstPath = new Path("/test/onlineupgrade/mysql.rpm");
        hdfs.rename(srcPath, dstPath);
    }

    public static void fileLocation() throws Exception {
        FileSystem hdfs = getFileSystem();
        Path filePath = new Path("/test/hadoop-3.0.0.tar.gz");
        FileStatus fileStatus = hdfs.getFileStatus(filePath);

        BlockLocation[] blockLocations = hdfs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        for (BlockLocation blockLocation : blockLocations) {
            System.out.println(blockLocation.getOffset());
            System.out.println(blockLocation.getLength());

            for (String host : blockLocation.getHosts()) {
                System.out.println(host);
            }

            for (String storageId : blockLocation.getStorageIds()) {
                System.out.println(storageId);
            }
        }
    }

    public static void dataNodeList() throws Exception {
        FileSystem fs = getFileSystem();
        DistributedFileSystem hdfs = (DistributedFileSystem) fs;

        DatanodeInfo[] dataNodeStats = hdfs.getDataNodeStats();
        for (int i = 0; i < dataNodeStats.length; i++) {
            System.out.println("DataNode_" + i + "_Name:"
                    + dataNodeStats[i].getHostName());

        }

    }

    public static void main( String[] args )
    {
        try {
//            createFile();
//            createDirectory();
            //putFile();
            //getFile();
            //renameFile();
            //fileLocation();
            dataNodeList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
