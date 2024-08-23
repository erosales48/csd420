/* Edgar D Rosales
   23 Aug 2024
   CSD420-J318 Advanced Java Programming
   Module 3.2 Assignment

  Write a test program that contains a static method that returns a new ArrayList.
   - The new ArrayList returned will contain all original values with no duplicates from the original ArrayList.
   - Fill the Original ArrayList with 50 random values from 1 to 20.
   - public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
 */

package org.example.csd420.Module03;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class Module03 {
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        fillListWithRandos(originalList, 50, 20);
        System.out.println("Original List of integers: " + originalList);
        // Call generic method to remove duplicates and print results
        ArrayList<Integer> dedupedList = dedup(originalList);
        System.out.println("Integer list without duplicates: " + dedupedList);

        System.out.println();
        /* As a bonus to demonstrate the power of generics adding another type of list
           to throw at the generic method.
           It is very hard to have duplicate value for a double so just demonstrating
           the use of a generic method.
         */
        ArrayList<Double> originalDoubleList = new ArrayList<>();
        fillListWithDoubleRandos(originalDoubleList, 50, 1);
        System.out.print("Original List of doubles: ");
        printFormattedList(originalDoubleList);
        System.out.println("number of values originally: " + originalDoubleList.size());
        // Call generic method to remove duplicates
        ArrayList<Double> dedupedDoubleList = dedup(originalDoubleList);
        System.out.print("Double list without duplicates: ");
        printFormattedList(dedupedDoubleList);

        System.out.println("number of values after dedup: " + dedupedDoubleList.size());

    }
    // Method for creating a list of random values (Integer)
    public static void fillListWithRandos(ArrayList<Integer> list, int size, int max) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(max) + 1);
        }
    }
    // Method for generating a list of random double values
    public static void fillListWithDoubleRandos(ArrayList<Double> list, int size, int max) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            double value = (double) Math.round((rand.nextDouble() * max) * 100) / 100;
            list.add(value);
        }
    }
    // Generic method for removing duplicates
    public static <E> ArrayList<E> dedup(ArrayList<E> list) {
        HashSet<E> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }
    // Method to format doubles to 2 decimal places
    public static void printFormattedList(ArrayList<Double> list) {
        for (Double d : list) {
            System.out.printf("%.2f ", d);
        }
        System.out.println();
    }
}
