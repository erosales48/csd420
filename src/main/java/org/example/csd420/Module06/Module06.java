/* Edgar D Rosales
   14 Sep 2024
   CSD420-J318 Advanced Java Programming
   Module 6.2 Assignment

   1. Write a program with the two following generic methods using a bubble sort.
      The first method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
      - public static (E extends Comparable<E>> void bubbleSort(E[] list))
      - public static <E> void bubbleSort(E[] list, Comparator<?super E> comparator)
      - Attached above is a solution zip file for your review. Ensure you actually write your own code, only using
        the attached solution as example, and document your code. (I took a different path)

   2. Write test code that ensures the code functions correctly.
 */

package org.example.csd420.Module06;

import java.util.Comparator;

public class Module06 {

    // Bubble sort method using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    // Swap list[i] and list[i + 1]
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Bubble sort method using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    // Swap list[i] and list[i + 1]
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void main(String[] args) {
        Integer[] numbers = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12}; // Using list from example to see equal results

        // Using Comparable
        bubbleSort(numbers);
        System.out.println("Sorted using Comparable:");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        String[] words = {"banana", "apple", "grape", "mango", "Cherry", "KIWI"};

        // Using Comparator
        bubbleSort(words, String.CASE_INSENSITIVE_ORDER); // Took me a bit to find how to ignore case
        System.out.println("Sorted using Comparator:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
