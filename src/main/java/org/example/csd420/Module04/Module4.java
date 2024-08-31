/* Edgar D Rosales
   31 Aug 2024
   CSD420-J318 Advanced Java Programming
   Module 4.2 Assignment

   1. Write a test program that stores 50,000 integers in LinkedList and
      test the time to traverse the list using an iterator vs. using the get(index) method.
   2. Then, test your program storing 500,000 integers.
   3. After completing this program and having tested both values, in your comments,
      explain the results and discuss the time taken using both values and their difference
      with the get(index) approach.
   4. Write test code that ensures the code functions correctly.
 */

package org.example.csd420.Module04;

import java.util.LinkedList;
import java.util.Iterator;

public class Module4 {

    public static void main(String[] args) {
        // Test with 50,000 integers
        int testSize1 = 50000;
        LinkedList<Integer> list1 = new LinkedList<>();
        populateList(list1, testSize1);

        System.out.println("Testing traversal with 50,000 integers:");
        testTraversalTime(list1);

        // Test with 500,000 integers
        int testSize2 = 500000;
        LinkedList<Integer> list2 = new LinkedList<>();
        populateList(list2, testSize2);

        System.out.println("Testing traversal with 500,000 integers:");
        testTraversalTime(list2);
    }

    private static void populateList(LinkedList<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    private static void testTraversalTime(LinkedList<Integer> list) {
        // Test time for traversal with iterator
        long startTime = System.nanoTime();
        iteratorTraversal(list);
        long endTime = System.nanoTime();
        long timeElapsedWithIterator = endTime - startTime;
        System.out.println("\tTime taken using iterator: " + timeElapsedWithIterator + " nanoseconds");

        // Test time for traversal with get(index) method
        startTime = System.nanoTime();
        getIndexTraversal(list);
        endTime = System.nanoTime();
        long timeElapsedWithGetIndex = endTime - startTime;
        System.out.println("\tTime taken using get(index): " + timeElapsedWithGetIndex + " nanoseconds");
    }

    private static void iteratorTraversal(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    private static void getIndexTraversal(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
    }

    /* Using Iterator for traversal is faster than using the get(index) method
       This is because the get(index) method in LinkedList has O(n) complexity for each call, making overall
       traversal O(n^2), While Iterator has O(n) complexity overall. As the list size increases the difference
       in time taken between the two methods becomes more significant.
     */
}
