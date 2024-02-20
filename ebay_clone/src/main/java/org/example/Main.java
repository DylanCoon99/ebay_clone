package org.example;

import java.sql.DriverManager;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");
        String url = "jdbc:mysql://localhost:3306/ebay";
        String db_username = "root";
        String db_password = "DMC25201430?!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // temporary logging
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, db_username, db_password);
            Statement statement = connection.createStatement();

            User user1 = new User();

            user1.setUsername("dylan");
            user1.setPassword("12345");
            user1.setEmail("abc123@gmail.com");

            Integer rowsAffected = statement.executeUpdate(String.format("INSERT INTO users (username, email, password) VALUES ('%s', '%s', '%s')", user1.getUsername(), user1.getEmail(), user1.getPassword()));
            System.out.println(rowsAffected);

        } catch (java.sql.SQLException e) {
            // temporary logging
            e.printStackTrace();
        }

    }
}