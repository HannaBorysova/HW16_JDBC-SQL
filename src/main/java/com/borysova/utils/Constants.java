package com.borysova.utils;

public class Constants {
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc.h2:mem:default";
    public static final String STUDENT = "sa";
    public static final String PASS = "";
    public static final String STUDENT_COLUMN = "CREATE TABLE IF NOT EXISTS Student "
            + "( id INTEGER not NULL, " + " first_name VARCHAR(255), " + " last_name VARCHAR(255), " +
            " age INTEGER, " + " city VARCHAR(255), " + " PRIMARY KEY ( id ))";
    public static final String INSERT_INTO_STUDENT = "INSERT INTO Student ";

}
