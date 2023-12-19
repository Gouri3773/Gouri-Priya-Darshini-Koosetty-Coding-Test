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
