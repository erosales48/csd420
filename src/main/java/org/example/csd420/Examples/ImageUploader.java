package org.example.csd420.Examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageUploader {

    public void insertImage(String dbName, String tableName, String columnName, String filePath, String user, String password) {
        String url = "jdbc:mysql://localhost:3306/" + dbName;

        File file = new File(filePath);
        try (Connection connection = DriverManager.getConnection(url, user, password);
             FileInputStream fis = new FileInputStream(file)) {

            byte[] fileContent = new byte[(int) file.length()];
            fis.read(fileContent);

            String sql = "INSERT INTO " + tableName + " (" + columnName + ") VALUES (?)";
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