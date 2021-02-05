import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * @description: SqlQueriesGlobalViewApp
 * @date: 2021/2/5 16:22
 * @author: maccura
 * @version: 1.0
 */
public class SqlQueriesGlobalViewApp {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SqlQueriesGlobalViewApp")
                .getOrCreate();

        String filePath = "file://" + "/home/hero/spark/data/people.json";
        Dataset<Row> df = spark.read().json(filePath);
        // Register the DataFrame as a SQL temporary view
        df.createOrReplaceGlobalTempView("people");

        // Global temporary view is tied to a system preserved database `global_temp`
        spark.sql("SELECT * FROM global_temp.people").show();
        // +----+-------+
        // | age|   name|
        // +----+-------+
        // |null|Michael|
        // |  30|   Andy|
        // |  19| Justin|
        // +----+-------+

        // Global temporary view is cross-session
        spark.newSession().sql("SELECT * FROM global_temp.people").show();

        spark.close();
    }
}
