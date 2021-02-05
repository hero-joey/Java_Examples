import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

/**
 * @description: SimpleApplication
 * @date: 2021/2/4 13:55
 * @author: maccura
 * @version: 1.0
 */
public class SimpleApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SimpleApplication")
                .getOrCreate();
        String filePath = "file://" + "/usr/local/spark/README.md";
        Dataset<String> logData = spark.read().textFile(filePath).cache();

        System.out.println("FileData Read Start");
        System.out.println(logData.toString());
        System.out.println("FileData Read Finish");

        long numAs = logData.filter((FilterFunction<String>) s -> s.contains("a")).count();
        long numBs = logData.filter((FilterFunction<String>) s -> s.contains("b")).count();
        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        spark.stop();
    }
}
