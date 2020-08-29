package com.borysova.utils;

public class Constants {
    public static final String STUDENT_COLUMN = "CREATE TABLE IF NOT EXISTS Student "
            + "( id INTEGER not NULL, " + " first_name VARCHAR(255), " + " last_name VARCHAR(255), " +
            " age INTEGER, " + " city VARCHAR(255), " + " PRIMARY KEY ( id ))";
    public static final String INSERT_INTO_STUDENT = "INSERT INTO Student ";
}
