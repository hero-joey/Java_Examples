import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import java.io.Serializable;

/**
 * @description: SqlRddApp
 * @date: 2021/2/5 16:46
 * @author: maccura
 * @version: 1.0
 */
public class SqlRddApp {

    public static class Person implements Serializable {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SqlRddApp")
                .getOrCreate();
        String filePath = "file://" + "/home/hero/spark/data/people.txt";
        JavaRDD<Person> personJavaRDD = spark.read().textFile(filePath).javaRDD().map(new Function<String, Person>() {
            @Override
            public Person call(String s) throws Exception {
                String[] splits = s.split(",");
                Person person = new Person();
                person.setName(splits[0]);
                person.setAge(Integer.parseInt(splits[1].trim()));
                return person;
            }
        });

        Dataset<Row> peopleDF = spark.createDataFrame(personJavaRDD, Person.class);
        peopleDF.createOrReplaceTempView("people");

        // SQL statements can be run by using the sql methods provided by spark
        Dataset<Row> teenagersDF = spark.sql("SELECT name FROM people WHERE age BETWEEN 13 AND 19");

        // The columns of a row in the result can be accessed by field index
        Encoder<String> stringEncoder = Encoders.STRING();
        Dataset<String> teenagerNamesByIndexDF = teenagersDF.map(new MapFunction<Row, String>() {
            @Override
            public String call(Row row) throws Exception {
                return "Name" + row.getString(0);
            }
        }, stringEncoder);
        teenagerNamesByIndexDF.show();

        Dataset<String> teenagerNamesByFieldDF = teenagersDF.map(
                (MapFunction<Row, String>) row -> "Name: " + row.<String>getAs("name"),
                stringEncoder);
        teenagerNamesByFieldDF.show();
        spark.close();
    }
}
