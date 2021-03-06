package com.borysova.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2jdbc {
    private static InputStream inputStream;
    private static Connection connection;

    public static Connection createDatabase() {
        try {
            Properties properties = new Properties();
            String file = "H2jdbc.properties";
            inputStream = H2jdbc.class.getClassLoader().getResourceAsStream(file);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file " + file + " is not found");
            }
            String db_url = properties.getProperty("db_url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("pass");

            System.out.println("Connecting to database....");
            connection = DriverManager.getConnection(db_url, user, password);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException se2) {
            }
            return connection;
        }
    }
}
