import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * @description: SimpleSqlApp
 * @date: 2021/2/5 15:00
 * @author: maccura
 * @version: 1.0
 */
public class SimpleSqlApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SimpleSql")
                .config("master", "local")
                .getOrCreate();

        String filePath = "file://" + "/home/hero/spark/data/people.json";
        Dataset<Row> df = spark.read().json(filePath);
        df.show();
        System.out.println("########");
        df.printSchema();

        System.out.println("########");
        df.select("name").show();

        System.out.println("########");
        df.select(new Column("name"), new Column("age").plus(1)).show();

        System.out.println("########");
        // Select people older than 21
        df.filter(new Column("age").gt(21)).show();

        // Count people by age
        df.groupBy("age").count().show();

        spark.close();
    }
}
