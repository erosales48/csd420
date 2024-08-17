/* Edgar D Rosales
   15 Aug 2024
   CSD420-J318 Advanced Java Programming
   Module 1.2 Assignment

   1. Write a program that stores:
        - An array of five random integers
        - A Date object instance using the current date
        - An array of five random double values
   2. Write the data in a file titled ERosales_datafile.dat.
   3. Write a second program that will read the file and display the data.
   4. Test the code to ensure the code functions correctly

   Second Program - Reads the data
 */

package org.example.csd420.module01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class ReadDataFile {
    public static void main(String[] args) {
        // Constants
        final int ARRAY_SIZE = 5;
        final String DATA_FILE = "ERosales_datafile.dat";

        // Arrays to store the read data
        int[] randomIntegers = new int[ARRAY_SIZE];
        double[] randomDoubles = new double[ARRAY_SIZE];
        Date currentDate;

        // Read data from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(DATA_FILE))) {
            // Read integers
            for (int i = 0; i < randomIntegers.length; i++) {
                randomIntegers[i] = dis.readInt();
            }

            // Read date in long format and convert to Date object
            long dateLong = dis.readLong();
            currentDate = new Date(dateLong);

            // Read double values
            for (int i = 0; i < randomDoubles.length; i++) {
                randomDoubles[i] = dis.readDouble();
            }

            // Display the data
            System.out.print("\nRandom Integers: ");
            for (int i : randomIntegers) {
                System.out.print(i + " ");
            }
            System.out.print("\nRandom Doubles: ");
            for (double d : randomDoubles) {
                System.out.print(d + " ");
            }
            System.out.println("\n\nCurrent Date: " + currentDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
