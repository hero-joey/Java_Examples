package main.java;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;
import java.util.List;

/**
 * @description: HelloWorld
 * @date: 2021/2/3 11:39
 * @author: maccura
 * @version: 1.0
 */
public class FemaleInfoCollection {

    public static class FemaleInfo implements Serializable {
        private String name;
        private String gender;
        private Integer stayTime;

        public FemaleInfo() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getStayTime() {
            return stayTime;
        }

        public void setStayTime(Integer stayTime) {
            this.stayTime = stayTime;
        }
    }

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("CollectFemaleInfo").master("local")
                .getOrCreate();

        JavaRDD<FemaleInfo> femaleInfoJavaRDD = spark.read().textFile("file:///home/hero/data/femaleinfo")
                .javaRDD().map(new Function<String, FemaleInfo>() {
                    @Override
                    public FemaleInfo call(String s) throws Exception {
                        String[] slices = s.split(",");
                        FemaleInfo femaleInfo = new FemaleInfo();
                        femaleInfo.setName(slices[0]);
                        femaleInfo.setGender(slices[1]);
                        femaleInfo.setStayTime(Integer.parseInt(slices[2]));
                        return femaleInfo;
                    }
                });

        // Register table.
        Dataset<Row> schemaFemaleInfo = spark.createDataFrame(femaleInfoJavaRDD, FemaleInfo.class);
        schemaFemaleInfo.registerTempTable("FemaleInfoTable");

        // Run SQL query
        Dataset<Row> femaleTimeInfo = spark.sql("select * from " +
                "(select name,sum(stayTime) as totalStayTime from FemaleInfoTable " +
                "where gender = 'female' group by name )" +
                " tmp where totalStayTime >120");

        // Collect the columns of a row in the result.
        List<String> result = femaleTimeInfo.javaRDD().map(new Function<Row, String>() {
            @Override
            public String call(Row row) {
                return row.getString(0) + "," + row.getLong(1);
            }
        }).collect();
        System.out.println(result);
        spark.stop();
    }
}
