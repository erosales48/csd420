package org.example.csd420.Examples;

import java.util.TreeMap;

public class BattleTechMechs {
    public static void main(String[] args) {
        // Create a TreeMap to store mech names and their tonnage
        TreeMap<String, Integer> mechs = new TreeMap<>();

        // Add some mechs to the TreeMap
        mechs.put("Atlas", 100);    // Key: Mech name, Value: Tonnage
        mechs.put("Hunchback", 50);
        mechs.put("Locust", 20);
        mechs.put("Catapult", 65);
        mechs.put("Mad Cat", 75);

        // Display the sorted mech list
        System.out.println("Sorted Mech List:");
        for (String mech : mechs.keySet()) {
            System.out.println(mech + " - Tonnage: " + mechs.get(mech));
        }

        // Retrieve specific mech data
        String mechName = "Atlas";
        if (mechs.containsKey(mechName)) {
            System.out.println("\n" + mechName + " has a tonnage of " + mechs.get(mechName) + " tons.");
        } else {
            System.out.println("\n" + mechName + " is not found in the mech list.");
        }
    }
}