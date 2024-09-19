package org.example.csd420.Examples;

public class RecursiveBinarySearch {
    public static int recursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return recursiveBinarySearch(list, key, low, high);
    }

    public static int recursiveBinarySearch(int[] list, int key, int low, int high) {
        if (low > high) {
            return -low -1;
        }
        int mid = (low + high) / 2;
        if (list[mid] == key) {
            return mid;
        } else if (list[mid] > key) {
            return recursiveBinarySearch(list, key, low, mid - 1);
        } else {
            return recursiveBinarySearch(list, key, mid + 1, high);
        }
    }
}
