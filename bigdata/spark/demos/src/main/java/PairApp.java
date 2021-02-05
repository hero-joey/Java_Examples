import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.List;

/**
 * @description: PariApp
 * @date: 2021/2/4 16:08
 * @author: maccura
 * @version: 1.0
 */
public class PairApp {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("PairApp");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        String filePath = "file:///home/hero/spark/data/pair.txt";
        JavaRDD<String> lines = javaSparkContext.textFile(filePath);
        JavaPairRDD<String, Integer> pairs = lines.mapToPair(s -> new Tuple2(s, 1));
        List<Tuple2<String, Integer>> tuple2s = pairs.reduceByKey((a, b) -> a + b).collect();
        //同样可以排序
        //counts.sortByKey()
        System.out.println("Result begin ================");
        for (Tuple2<String, Integer> tuple2 : tuple2s) {
            System.out.println(tuple2._1 + ":" + tuple2._2);
        }

        System.out.println("Result End ================");
    }
}
