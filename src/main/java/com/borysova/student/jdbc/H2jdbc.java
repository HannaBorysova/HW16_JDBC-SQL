package com.borysova.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.borysova.student.service.StudentServise.*;

public class H2jdbc {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc.h2:mem:default";

    static final String STUDENT = "sa";
    static final String PASS = "";

    public static void createDatabase() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database....");
            conn = DriverManager.getConnection("jdbc:h2:~/test", STUDENT, PASS);

            System.out.println("Creating table  in given database....");
            stmt = conn.createStatement();
            String sqlDrop = "Drop Table if exists Student";
            String sql = "CREATE TABLE IF NOT EXISTS Student " +
                    "( id INTEGER not NULL, " +
                    " first_name VARCHAR(255), " +
                    " last_name VARCHAR(255), " +
                    " age INTEGER, " +
                    " city VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.execute(sqlDrop);
            stmt.execute(sql);
            System.out.println("Created table in given database....");
            inserts(stmt);
            selects(stmt);
            orderByAge(stmt);
            countStudents(stmt);
            groupByName(stmt);
            deleteByAge(stmt);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
