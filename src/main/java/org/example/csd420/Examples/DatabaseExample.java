package org.example.csd420.Examples;

import java.sql.*;
import java.util.Comparator;
import java.util.Scanner;

public class DatabaseExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "G0dzilla#007";

        try (Connection connection = DriverManager.getConnection(url, username, password )) {
            System.out.println("Connection successful!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Customers");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("last_name"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
