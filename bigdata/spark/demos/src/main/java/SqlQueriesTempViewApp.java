import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * @description: SqlQueriesApp
 * @date: 2021/2/5 15:35
 * @author: maccura
 * @version: 1.0
 */
public class SqlQueriesTempViewApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SimpleSql")
                .config("master", "local[2]")
                .getOrCreate();

        String filePath = "file://" + "/home/hero/spark/data/people.json";
        Dataset<Row> df = spark.read().json(filePath);
        // Register the DataFrame as a SQL temporary view
        df.createOrReplaceTempView("people");

        Dataset<Row> sqlDF = spark.sql("SELECT * FROM people");
        sqlDF.show();

        spark.close();
    }
}
