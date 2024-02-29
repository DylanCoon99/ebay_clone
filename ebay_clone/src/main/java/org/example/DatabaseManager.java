package org.example;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/ebay";
    private static final String USER = "root";

    @Value("${MYSQL_ROOT_PASSWORD}")
    private static String PASSWORD; // change this to an environment variable later


    private static Connection connection;

    private DatabaseManager() {
    System.out.println(PASSWORD);
    }

    // Method to get the database connection
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful!");
        }
        return connection;
    }

    // Method to close the database connection
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
