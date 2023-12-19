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
