package org.example.csd420.Examples;

import java.util.*;

public class SortDescending {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 6);

        // Sort in descending order
        Collections.sort(numbers);
        System.out.println(numbers); //Output will be [1, 3, 5, 6, 8]

        Collections.reverse(numbers);

        System.out.println(numbers); // Output will be [8, 5, 3, 1]
    }
}