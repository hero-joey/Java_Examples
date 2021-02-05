import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

/**
 * @description: HelloWorldApplication
 * @date: 2021/2/4 14:30
 * @author: maccura
 * @version: 1.0
 */
public class HelloWorldApp {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("HelloWorld");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<Integer> distData = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> javaRDD = javaSparkContext.parallelize(distData);


    }
}
