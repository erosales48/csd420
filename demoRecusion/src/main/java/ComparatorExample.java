package main.java;

import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Dave", 20),
                new Person("Eve", 27)
        );
        Comparator<Person> ageComparator = Comparator.comparingInt(person -> person.age);
        people.sort(ageComparator);
        System.out.println("Sorted by age: " + people);
    }
}
