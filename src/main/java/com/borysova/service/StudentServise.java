package com.borysova.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentServise {
    public static void inserts(Statement stmt) throws SQLException {
        String sql = "INSERT INTO Student " + "VALUES (1, 'Hanna', 'Borysova', 26, 'Kyiv')";
        stmt.execute(sql);
        sql = "INSERT INTO Student " + "VALUES (2, 'Petro', 'Lahuta', 27, 'Kyiv')";

        stmt.execute(sql);
        sql = "INSERT INTO Student " + "VALUES (3, 'Jane', 'Ostin', 51, 'Limassol')";

        stmt.execute(sql);
        sql = "INSERT INTO Student " + "VALUES(4, 'Jule', 'Mittal', 18, 'Kyiv')";

        stmt.execute(sql);
        System.out.println("Inserted records into the table...");
    }

    public static void selects(Statement stmt) throws SQLException {
        String sql = "SELECT id, first_name, last_name, age, city FROM Student";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int age = rs.getInt("age");
            String city = rs.getString("city");
            System.out.print("ID: " + id);
            System.out.print(", First name: " + first_name);
            System.out.println(", Last name: " + last_name);
            System.out.print(", Age: " + age);
            System.out.println(", City: " + city);
        }
    }

    public static void orderByAge(Statement stmt) throws SQLException {
        String sql = "SELECT * " +
                "FROM Student " +
                "ORDER BY age ";
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("Ordered by AGE");

        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int age = rs.getInt("age");
            String city = rs.getString("City");

            System.out.print("ID: " + id);
            System.out.print(", First name: " + first_name);
            System.out.print(", Last name: " + last_name);
            System.out.print(", Age: " + age);
            System.out.println(", City: " + city);
        }
    }

    public static void countStudents(Statement stmt) throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM Student";
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("Number of students ");

        while (rs.next()) {
            int count = rs.getInt("total");
            System.out.println(count);
        }
    }

    public static void groupByName(Statement stmt) throws SQLException {
        String sql = "SELECT * " +
                "FROM Student " +
                "WHERE first_name LIKE 'J%'";
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("Name starts with 'J' ");

        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int age = rs.getInt("age");
            String city = rs.getString("City");

            System.out.print("ID: " + id);
            System.out.print(", First name: " + first_name);
            System.out.print(", Last name: " + last_name);
            System.out.print(", Age: " + age);
            System.out.println(", City: " + city);
        }
    }

    public static void deleteByAge(Statement stmt) throws SQLException {
        String sql = "DELETE " +
                "FROM Student " +
                "WHERE age BETWEEN 20 AND 45";
        stmt.executeUpdate(sql);
        System.out.println(sql + ":");
        countStudents(stmt);
    }
}
