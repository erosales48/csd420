package org.example.csd420.Examples;

public class TestBinarySeatch {
    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int i = RecursiveBinarySearch.recursiveBinarySearch(list, 2); // Returns 0
        int j = RecursiveBinarySearch.recursiveBinarySearch(list, 11); // Returns 4
        int k = RecursiveBinarySearch.recursiveBinarySearch(list, 12); // Returns -6
        int l = RecursiveBinarySearch.recursiveBinarySearch(list, 1); // Returns -1
        int m = RecursiveBinarySearch.recursiveBinarySearch(list, 3); // Returns -2

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);

    }
}
