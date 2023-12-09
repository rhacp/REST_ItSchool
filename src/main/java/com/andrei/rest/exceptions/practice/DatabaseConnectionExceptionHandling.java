package com.andrei.rest.exceptions.practice;

import java.sql.*;

public class DatabaseConnectionExceptionHandling {

    public static void main(String[] args) {
        String databaseUrl = "jdbc:postgresql://localhost:5432/demo_project_database";
        String user = "admin";
        String password = "admin";

        try(Connection connection = DriverManager.getConnection(databaseUrl, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        } catch (SQLException exception) {
            System.out.println("Something went wrong.");
        }
    }
}
