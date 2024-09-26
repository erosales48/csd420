package org.example.csd420.Examples;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageToDatabase {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/movies";
        String user = "root";
        String password = "G0dzilla#007";

        String filepath = "F:\\Pictures\\ppkhei0tyh6d1.jpeg";
        File file = new File(filepath);
        try (Connection connection = DriverManager.getConnection(url, user, password);
             FileInputStream fis = new FileInputStream(file)){

            byte[] fileContent = new byte[(int) file.length()];
            fis.read(fileContent);

            String sql = "INSERT INTO poster (image) VALUES (?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setBinaryStream(1, new ByteArrayInputStream(fileContent), fileContent.length);

            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("A new image was inserted successfully!");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
