package org.example.app.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn {
    static Properties properties = new Properties();

    public static Connection connect() {
        Connection connection = null;

        try {
            properties.load(DBConn.class.getResourceAsStream("/db/jdbc.properties"));
            connection = DriverManager.getConnection(properties.getProperty("dbDriver") + properties.getProperty("dbName"),
                    properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
