/* Edgar D Rosales
   07 Sep 2024
   CSD420-J318 Advanced Java Programming
   Module 5.2 Assignment

   1. Write a test program that reads words from a text file and displays all non-duplicate words
      in ascending order and then in descending order.
       - The file is to be referenced in the program, not needing to be used as a command line reference.
       - The word file is to be titled collection_of_words.txt and included in your submission.

   2. Write test code that ensures the code functions correctly.
 */

package org.example.csd420.Module05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Module05 {
    public static void main(String[] args) {
        // Static Values
        final String staticFile = "src/main/resources/collection_of_words.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(staticFile));

            // Using LinkedHashMap to preserve insertion order
            Map<String, Integer> wordCount = countWords(lines);

            // Extract unique words and sort them
            Set<String> words = new TreeSet<>(wordCount.keySet());

            int originalCount = 0;
            System.out.println("Word Counts: ");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                String key = entry.getKey();
                Integer count = entry.getValue();
                System.out.println(key + ": " + count);
                originalCount += count;
            }
            System.out.println("Original word Count: " + originalCount + "\n\n");
            System.out.println("Total unique words: " + words.size());

            System.out.println("Words in ascending order:");
            for (String word : words) {
                System.out.print(word + " ");
            }

            System.out.println("\nWords in descending order:");
            List<String> toSort = new ArrayList<>();
            for (String word : words) {
                toSort.add(word);
            }
            toSort.sort(Collections.reverseOrder());
            for (String word : toSort) {
                System.out.print(word + " ");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static Map<String, Integer> countWords(List<String> lines) {
        Map<String, Integer> wordCounts = new LinkedHashMap<>();
        for (String line : lines) {
            String[] lineWords = line.split("\\W+");
            for (String word : lineWords) {
                if (!word.isBlank()) {
                    word = word.toLowerCase();
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        }
        return wordCounts;
    }
}