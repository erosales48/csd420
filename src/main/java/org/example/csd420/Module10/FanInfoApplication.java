package org.example.csd420.Module10;

/* Edgar D Rosales
   28 September 2024
   CSD420-J318 Advanced Java Programming (2247-DD)

   Module 10 Assignment:
   1. Write a program that views and updates fan information stored in database titled "databasedb",
      user ID titled “student1” with a password “pass”.
   2. The table name is to be “fans” with the fields of ID (integer, PRIMARY KEY), firstname (varchar(25)),
      lastname (varchar(25)), and favoriteteam (varchar(25)).
   3. Your interface is to have 2 buttons to display and update records.
         - The display button will display the record with the provided ID in the display (ID user provides).
         - The update button will update the record in the database with the changes made in the display.
   4. Your Application is not to create or delete the table.
   5. To work on this using your home database, you can make the table and populate it.
   6. When the application is tested, the table will already be created and populated.
   7. Write test code that ensures all methods and the interface functions correctly.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class FanInfoApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FanInfo.fxml")));
            primaryStage.setTitle("Fan Info");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Run run run
    public static void main(String[] args) {launch(args);}
}