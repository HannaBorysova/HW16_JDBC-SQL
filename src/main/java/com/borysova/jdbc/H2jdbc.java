package com.borysova.jdbc;

import com.borysova.student.StudentService;
import com.borysova.student.StudentServiсeImpl;
import com.borysova.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2jdbc {

    StudentService studentService = StudentServiсeImpl.getInstance();

    public void createDatabase() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(Constants.JDBC_DRIVER);
            System.out.println("Connecting to database....");
            conn = DriverManager.getConnection("jdbc:h2:~/test", Constants.STUDENT, Constants.PASS);

            System.out.println("Creating table  in given database....");
            stmt = conn.createStatement();
            String sqlDrop = "Drop Table if exists Student";
            String sql = Constants.STUDENT_COLUMN;
            stmt.execute(sqlDrop);
            stmt.execute(sql);
            System.out.println("Created table in given database....");

            studentService.inserts(stmt);
            studentService.selects(stmt);
            studentService.orderByAge(stmt);
            studentService.countStudents(stmt);
            studentService.groupByName(stmt);
            studentService.deleteByAge(stmt, 20, 45);
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
