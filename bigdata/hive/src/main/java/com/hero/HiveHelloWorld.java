package com.hero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class HiveHelloWorld
{
    public static void main( String[] args ) throws Exception {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection con = DriverManager.getConnection(
                "jdbc:hive2://hadoop1:10000/default", "root", "daxiong@2020");
        Statement stmt = con.createStatement();
        String querySQL = "show tables";

        ResultSet res = stmt.executeQuery(querySQL);
        while (res.next()) {
            System.out.println(res.getString(1));
        }

        res.close();
        stmt.close();
        con.close();
    }
}
