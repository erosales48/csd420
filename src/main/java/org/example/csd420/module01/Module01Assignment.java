

package org.example.csd420.module01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Module01Assignment extends Application {
    // Constants to be used
    private static final int ARRAY_SIZE = 5;
    private static final int MAX_INT = 9999;
    private static final int MAX_DOUBLE = 999;
    private static final String DATA_FILE = "ERosales_datafile.dat";

    // Arrays for storing random integers and doubles
    int[] intArray = new int[ARRAY_SIZE];
    double[] doubleArray = new double[ARRAY_SIZE];

    // Current date instance
    Date savedDate = new Date();

    // TextField variables
    private TextField intField;
    private TextField doubleField;
    private TextField dateField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Initialize TextFields
        intField = new TextField();
        intField.setPromptText("Generated Integers");
        intField.setEditable(false);

        doubleField = new TextField();
        doubleField.setPromptText("Generated Doubles");
        doubleField.setEditable(false);

        dateField = new TextField();
        dateField.setPromptText("Date");
        dateField.setEditable(false);

        // Buttons
        HBox buttonBox = getButtonBox();

        // Layout
        VBox vbox = new VBox(10, intField, doubleField, dateField, buttonBox);
        vbox.setPadding(new javafx.geometry.Insets(20));

        // Scene
        Scene scene = new Scene(vbox, 640, 190);
        stage.setTitle("Module 01 Assignment");
        stage.setScene(scene);
        stage.show();
    }

    private HBox getButtonBox() {
        Button generateButton = new Button("Generate");
        generateButton.setOnAction(event -> onGenerateButtonClick());

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> onSaveButtonClick());

        Button retrieveButton = new Button("Retrieve");
        retrieveButton.setOnAction(event -> onRetrieveButtonClick());

        // HBox for buttons
        HBox buttonBox = new HBox(10, generateButton, saveButton, retrieveButton);
        buttonBox.setPadding(new javafx.geometry.Insets(20));
        return buttonBox;
    }

    private void onGenerateButtonClick() {
        intArray = getRandomInt();
        doubleArray = getRandomDouble();
        savedDate = new Date();
        intField.setText(Arrays.toString(intArray));
        doubleField.setText(Arrays.toString(doubleArray));
        dateField.setText(new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(savedDate));
    }

    private void onSaveButtonClick() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(DATA_FILE))) {
            // Write integers
            for (int i : intArray) {
                dos.writeInt(i);
            }

            // Write date
            dos.writeLong(savedDate.getTime());

            // Write doubles
            for (double d : doubleArray) {
                dos.writeDouble(d);
            }

            System.out.println("Data written successfully.");
            intField.setText("Saved");
            doubleField.setText("Saved");
            dateField.setText("Saved");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onRetrieveButtonClick() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(DATA_FILE))) {
            // Read integers
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = dis.readInt();
            }

            // Read date and convert to object
            long dateRead = dis.readLong();
            savedDate = new Date(dateRead);

            // Read double values
            for (int i = 0; i < doubleArray.length; i++) {
                doubleArray[i] = dis.readDouble();
            }
            System.out.println("Data read successfully.");
            intField.setText(Arrays.toString(intArray));
            doubleField.setText(Arrays.toString(doubleArray));
            dateField.setText(new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(savedDate));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] getRandomInt() {
        Random rand = new Random();
        int[] randomInt = new int[ARRAY_SIZE];
        for (int i = 0; i < randomInt.length; i++) {
            randomInt[i] = rand.nextInt(MAX_INT);
        }
        return randomInt;
    }

    public static double[] getRandomDouble() {
        Random rand = new Random();
        double[] randomDouble = new double[ARRAY_SIZE];
        for (int i = 0; i < randomDouble.length; i++) {
            randomDouble[i] = Math.round(rand.nextDouble(MAX_DOUBLE) * 100.0) / 100.0;
        }
        return randomDouble;
    }
}