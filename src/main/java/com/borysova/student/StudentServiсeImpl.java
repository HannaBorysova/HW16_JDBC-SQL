package com.borysova.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.borysova.utils.Constants.INSERT_INTO_STUDENT;

public class StudentServiсeImpl implements StudentService {

    private static final StudentService studentServiсe = new StudentServiсeImpl();

    private StudentServiсeImpl() {
    }

    public static StudentService getInstance() {
        return studentServiсe;
    }

    @Override
    public void inserts(Statement stmt) throws SQLException {
        String sql = "INSERT INTO Student " + "VALUES (1, 'Hanna', 'Borysova', 26, 'Kyiv')";
        stmt.execute(sql);
        sql = INSERT_INTO_STUDENT + "VALUES (2, 'Petro', 'Lahuta', 27, 'Kyiv')";

        stmt.execute(sql);
        sql = INSERT_INTO_STUDENT + "VALUES (3, 'Jane', 'Ostin', 51, 'Limassol')";

        stmt.execute(sql);
        sql = INSERT_INTO_STUDENT + "VALUES(4, 'Jule', 'Mittal', 18, 'Kyiv')";

        stmt.execute(sql);
        System.out.println("Inserted records into the table: ");
    }

    @Override
    public void selects(Statement stmt) throws SQLException {
        String sql = "SELECT id, first_name, last_name, age, city FROM Student";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int age = rs.getInt("age");
            String city = rs.getString("city");
            System.out.print("ID: " + id + ", First name: " + first_name + ", Last name: "
                    + last_name + ", Age: " + age + ", City: " + city + "\n");
        }
    }

    @Override
    public void orderByAge(Statement stmt) throws SQLException {
        String sql = "SELECT * " + "FROM Student " + "ORDER BY age ";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Ordered by AGE");
        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int age = rs.getInt("age");
            String city = rs.getString("City");
            System.out.print("ID: " + id + ", First name: " + first_name + ", Last name: "
                    + last_name + ", Age: " + age + ", City: " + city + "\n");
        }
    }

    @Override
    public void countStudents(Statement stmt) throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM Student";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int count = rs.getInt("total");
            System.out.println("Number of students: " + count);
        }
    }

    @Override
    public void groupByName(Statement stmt) throws SQLException {
        String sql = "SELECT * " + "FROM Student " + "WHERE first_name LIKE 'J%'";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Name starts with 'J' ");
        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int age = rs.getInt("age");
            String city = rs.getString("City");
            System.out.print("ID: " + id + ", First name: " + first_name + ", Last name: "
                    + last_name + ", Age: " + age + ", City: " + city + "\n");
        }
    }

    @Override
    public void deleteByAge(Statement stmt, int minAge, int maxAge) throws SQLException {
        Statement statement = stmt;
        statement.executeUpdate("DELETE " + "FROM Student " +
                "WHERE age > " + minAge + " AND age < " + maxAge);
        String sql = "SELECT * " + "FROM Student ";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Update student's table after delete some students: ");
        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int age = rs.getInt("age");
            String city = rs.getString("City");
            System.out.print("ID: " + id + ", First name: " + first_name + ", Last name: "
                    + last_name + ", Age: " + age + ", City: " + city + "\n");
        }
    }
}