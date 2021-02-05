import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

import java.util.Arrays;
import java.util.List;

/**
 * @description: RddSampleApp
 * @date: 2021/2/5 9:55
 * @author: maccura
 * @version: 1.0
 */
public class RddSampleApp {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("HelloWorld");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<Integer> distData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10);
        JavaRDD<Integer> javaRDD = javaSparkContext.parallelize(distData);
        System.out.println("Count: " + javaRDD.count());

        List<Integer> squares = javaRDD.map(x -> x * x).collect();
        System.out.println("Square: ");
        squares.forEach(System.out::println);

        javaRDD.map(x -> x * x).saveAsTextFile("file:///home/hero/spark/data/rdd");

        Integer sum = javaRDD.reduce((Function2<Integer, Integer, Integer>) (integer, integer2) -> {
            System.out.println("integer1, integer2:" + integer + " " + integer2);
            System.out.println(Thread.currentThread().getName());
            return integer + integer2;
        });
        System.out.println(sum);
    }
}
