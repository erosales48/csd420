package org.example.csd420.Examples;

import java.util.regex.*;

public class RegexExample {
    public static void main(String[] args) {
        String text = "This is a sample text with numbers 123 and 456.";
        String patternString = "\\d+";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found number: " + matcher.group());
        }
    }
}