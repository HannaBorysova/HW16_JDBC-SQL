package com.borysova.student;

import java.sql.SQLException;
import java.sql.Statement;

public interface StudentService {
    void createH2jdbc() throws SQLException;

    void inserts(Statement stmt) throws SQLException;

    void selects(Statement stmt) throws SQLException;

    void orderByAge(Statement stmt) throws SQLException;

    void countStudents(Statement stmt) throws SQLException;

    void groupByName(Statement stmt) throws SQLException;

    void deleteByAge(Statement stmt, int minAge, int maxAge) throws SQLException;
}

