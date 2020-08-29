package com.borysova;

import com.borysova.student.StudentService;
import com.borysova.student.StudentServiсeImpl;

import java.sql.SQLException;

public class Executor {

    public static void execute() {
        StudentService studentService = StudentServiсeImpl.getInstance();
        try {
            studentService.createH2jdbc();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

