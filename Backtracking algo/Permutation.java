import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null || str.length() == 0) {//Base case 
            permutations.add("");
            return permutations;
        }

        char firstChar = str.charAt(0);         // Get the first character
        String remaining = str.substring(1);    // Get the remaining substring
        List<String> words = getPermutations(remaining); // Recursively call for the remaining

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                // Insert the first character at different positions
                String newPerm = word.substring(0, i) + firstChar + word.substring(i);
                permutations.add(newPerm);
            }
        
        }

        return permutations;
    }

    public static void main(String[] args) {
        String str = "ABC";
        List<String> permutations = getPermutations(str);
        System.out.println(permutations);  // Outputs all permutations
    }
}


/*
 str = "ABC":

First Call: firstChar = 'A', remaining = "BC"
Recursive Call on "BC": Fixes 'B' first, then works with the substring "C", 
then combines results back with A to get permutations like "ABC", "ACB".
Second Iteration: Fixes 'B' as firstChar and "AC" as remaining to get permutations "BAC", "BCA".
Third Iteration: Fixes 'C' as firstChar and "AB" as remaining to get "CAB", "CBA".
 */