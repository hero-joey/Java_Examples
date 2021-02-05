import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

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
        JavaRDD<Integer> integerJavaRDD = javaRDD.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) throws Exception {
                return integer * integer;
            }
        });
        integerJavaRDD.foreach(new VoidFunction<Integer>() {
            @Override
            public void call(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });

        JavaPairRDD<Integer, String> javaPairRDD = javaRDD.mapToPair(new PairFunction<Integer, Integer, String>() {
            @Override
            public Tuple2<Integer, String> call(Integer integer) throws Exception {
                return new Tuple2<>(integer, "index_" + integer);
            }
        });

        javaPairRDD.foreach(new VoidFunction<Tuple2<Integer, String>>() {
            @Override
            public void call(Tuple2<Integer, String> integerStringTuple2) throws Exception {
                System.out.println(integerStringTuple2._1);
                System.out.println(integerStringTuple2._2);
            }
        });

        javaSparkContext.close();


    }
}
