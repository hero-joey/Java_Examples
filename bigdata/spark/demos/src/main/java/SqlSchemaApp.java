import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: SqlSchemaApp
 * @date: 2021/2/6 9:32
 * @author: maccura
 * @version: 1.0
 */
public class SqlSchemaApp {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SqlRddApp")
                .getOrCreate();

        // Create an RDD.
        String filePath = "file://" + "/home/hero/spark/data/people.txt";
        JavaRDD<String> peopleRDD = spark.sparkContext()
                .textFile(filePath, 1)
                .toJavaRDD();

        // The schema is encoded in a string
        String schemaString = "name age";

        // Generate the schema based on the string of schema
        List<StructField> fields = new ArrayList<>();

        StructField field = DataTypes.createStructField("name", DataTypes.StringType, true);
        fields.add(field);

        field = DataTypes.createStructField("age", DataTypes.IntegerType, true);
        fields.add(field);

        StructType schema = DataTypes.createStructType(fields);

        // Convert records of the RDD (people) to Rows
        JavaRDD<Row> rowRDD = peopleRDD.map(new Function<String, Row>() {
            @Override
            public Row call(String s) throws Exception {
                String[] attributes = s.split(",");
                String name = attributes[0];
                Integer age = Integer.parseInt(attributes[1].trim());

                return RowFactory.create(name, age);
            }
        });

        // Apply the schema to the RDD
        Dataset<Row> peopleDataFrame = spark.createDataFrame(rowRDD, schema);

        // Creates a temporary view using the DataFrame
        peopleDataFrame.createOrReplaceTempView("people");

        // SQL can be run over a temporary view created using DataFrames
        Dataset<Row> results = spark.sql("SELECT * FROM people");
        results.show();

        // The results of SQL queries are DataFrames and support all the normal RDD operations
        // The columns of a row in the result can be accessed by field index or by field name
        Dataset<String> namesDS = results.map(
                (MapFunction<Row, String>) row -> "Name: " + row.getString(0),
                Encoders.STRING());
        namesDS.show();

        Dataset<Integer> agesDS = results.map(
                (MapFunction<Row, Integer>) row -> row.getInt(1),
                Encoders.INT());
        agesDS.show();
        spark.close();
    }
}
