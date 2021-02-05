import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;

import java.io.PrintStream;
import java.util.List;
import java.util.function.Consumer;

/**
 * @description: MultiFilesReadApp
 * @date: 2021/2/4 14:54
 * @author: maccura
 * @version: 1.0
 */
public class MultiFilesReadApp {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("MultiFilesReadApp");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        String filePath = "file:///home/hero/spark/data";

        //列区所有文件名称和内容
        JavaPairRDD<String, String> javaPairRDD = javaSparkContext.wholeTextFiles(filePath);
        List<String> files = javaPairRDD.keys().collect();
        for (String file : files) {
            System.out.println(file);
        }

        //读取所有文件内容
        JavaRDD<String> javaRDD = javaSparkContext.textFile(filePath);

        //collect函数用于将所有结果汇聚到本节点，可能导致内存溢出，可以取其中某些行
        javaRDD.collect().forEach(System.out::println);
        javaRDD.take(100).forEach(System.out::println);

        //计算中间结果，可以保存在内存中，使用cache方法或者persist方法
        JavaRDD<Integer> lineLengths = javaRDD.map(s -> s.length()).cache();
        lineLengths.persist(StorageLevel.MEMORY_ONLY());

        int totalLength = lineLengths.reduce((a, b) -> a + b);

        javaSparkContext.close();

    }
}
