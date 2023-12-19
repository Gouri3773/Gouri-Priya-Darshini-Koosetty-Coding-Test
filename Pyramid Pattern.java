1)import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the pyramid: ");
        int numberOfRows = scanner.nextInt();

        int number = 1;

        for (int i = 1; i <= numberOfRows; i++) {
            // Print spaces
            for (int space = 1; space <= (numberOfRows - i) * 5; space++) {
                System.out.print(" ");
            }

            // Print numbers
            for (int k = 1; k <= i; k++) {
                System.out.print(number + " ");
                number++;
            }

            System.out.println(); // Move to the next line for the next row
        }

        scanner.close();
    }
}





2. Given an array of integers, write a Java program to find and print all the duplicate elements.


import java.util.HashSet;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 2, 6, 7, 8, 4, 9, 10, 11, 10};

        // Using HashSet to track unique elements
        HashSet<Integer> uniqueSet = new HashSet<>();
        HashSet<Integer> duplicateSet = new HashSet<>();

        System.out.println("Duplicate elements in the array:");

        for (int num : array) {
            // If the element is already in the unique set, it's a duplicate
            if (!uniqueSet.add(num)) {
                duplicateSet.add(num);
            }
        }

        // Print the duplicate elements
        for (int duplicate : duplicateSet) {
            System.out.print(duplicate + " ");
        }
    }
}




3. Write a Java function to check if two strings are anagrams of each other. 
Note - An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other.


import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    public static void main(String[] args) {
        String str1 = "act";
        String str2 = "tac";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }

    static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths are the same
        if (str1.length() != str2.length()) {
            return false;
        }

        // Use a map to track character frequencies
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Increment frequencies for characters in str1
        for (char c : str1.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Decrement frequencies for characters in str2
        for (char c : str2.toCharArray()) {
            if (!charFrequency.containsKey(c) || charFrequency.get(c) == 0) {
                // Character not present in str1 or frequency exhausted
                return false;
            }
            charFrequency.put(c, charFrequency.get(c) - 1);
        }

        return true;
    }
}
