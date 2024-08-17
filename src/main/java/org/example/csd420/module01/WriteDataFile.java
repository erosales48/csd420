/* Edgar D Rosales
   15 Aug 2024
   CSD420-J318 Advanced Java Programming
   Module 1.2 Assignment

   1. Write a program that stores:
        - An array of five random integers
        - A Date object instance using the current date
        = An array of five random double values
   2. Write the data in a file titled ERosales_datafile.dat.
   3. Write a second program that will read the file and display the data.
   4. Test the code to ensure teh code functions correctly

   First Program - Writes the data
 */

package org.example.csd420.module01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class WriteDataFile {
    public static void main(String[] args) {

        // Set Constants
        final int MAX_INT = 1000;
        final double MAX_DOUBLE = 100;
        final String DATA_FILE = "ERosales_datafile.dat";

        // Initialize random object
        Random random = new Random();

        // Generate an array of five random integers
        int[] randomIntegers = new int[5];
        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = random.nextInt(MAX_INT);
        }

        // Create a Date object with the current date
        Date currentDate = new Date();

        // Generate an array of five random double values
        double[] randomDoubles = new double[5];
        for (int i = 0; i < randomDoubles.length; i++) {
            randomDoubles[i] = Math.round(random.nextDouble(MAX_DOUBLE) * 100.0) / 100.0;
        }

        // Write data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(DATA_FILE))) {
            // Write integers
            System.out.print("\nRandom Integers: ");
            for (int i : randomIntegers) {
                dos.writeInt(i);
                System.out.print(i + " ");
            }
            // Write date in long format
            dos.writeLong(currentDate.getTime());
            // Write double values
            System.out.print("\nRandom Doubles: ");
            for (double d : randomDoubles) {
                dos.writeDouble(d);
                System.out.print(d + " ");
            }
            // Print out Date and confirmation
            System.out.println("\n\n" + currentDate);
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
