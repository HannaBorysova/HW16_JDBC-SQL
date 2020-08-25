package com.borysova;

import com.borysova.jdbc.H2jdbc;

public class Main {

    public static void main(String[] args) {
        H2jdbc h2jdbc = new H2jdbc();
        h2jdbc.createDatabase();
    }
}
