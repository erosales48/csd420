package org.example.csd420.Module10;

/* Edgar D Rosales
   28 September 2024
   CSD420-J318 Advanced Java Programming (2247-DD)

   Controller for FanInfoApplication and FanInfo FXML
 */
// JavaFX imports
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// SQL imports
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
  The FanInfoController class handles the interaction between the user interface and the database
  for managing fan information such as ID, first name, last name, and favorite team.
  It provides functionalities to display and update records of fans in the database.
 */
public class FanInfoController {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    @FXML private TextField idField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField favoriteTeamField;
    @FXML private Label messageLabel;
    @FXML private ImageView imageView;
    // Method to fetch record
    @FXML
    private void displayRecord() {
        String id = idField.getText().trim();
        // Connect to Database and get record, if ID is empty fetch a list of records
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            if (id.isEmpty()) {
                String sql = "SELECT ID, LastName FROM fans";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                StringBuilder message = new StringBuilder("All Users:\n");
                while (rs.next()) {
                    message.append("ID: ").append(rs.getInt("ID"))
                            .append(": ").append(rs.getString("LastName")).append("\n");
                }
                messageLabel.setText(message.toString());
            } else {
                String sql = "SELECT * FROM fans WHERE ID = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(id));
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    firstNameField.setText(rs.getString("FirstName"));
                    lastNameField.setText(rs.getString("LastName"));
                    favoriteTeamField.setText(rs.getString("FavoriteTeam"));
                    // Added a picture for fun, if there is no picture in record skip, and erase last pic from display
                    Blob imageBlob = rs.getBlob("Foto");
                    if (imageBlob != null) {
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
                        Image image = new Image(bis);
                        imageView.setImage(image);
                    } else {
                        imageView.setImage(null);
                    }
                    messageLabel.setText("Record found");
                } else {
                    clearFields();
                    imageView.setImage(null);
                    messageLabel.setText("Record not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Error accessing database");
        }
    }
    // Method to update record
    @FXML
    private void updateRecord() {
        String id = idField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String favoriteTeam = favoriteTeamField.getText().trim();

        if (id.isEmpty()) {
            messageLabel.setText("ID cannot be empty");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String sql = "UPDATE fans SET FirstName = ?, LastName = ?, FavoriteTeam = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, favoriteTeam);
            pstmt.setInt(4, Integer.parseInt(id));
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                messageLabel.setText("Record updated");
            } else {
                messageLabel.setText("Record not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Error accessing database");
        }
    }
    // Method to clear field information
    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        favoriteTeamField.setText("");
    }
}
