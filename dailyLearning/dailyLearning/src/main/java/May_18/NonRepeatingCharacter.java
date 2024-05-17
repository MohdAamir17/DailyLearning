package May_18;

import java.util.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String S = "hello";
        char c = nonrepeatingCharacter(S);
        System.out.printf("Non repeating character : " + c);
    }

    //1st solution
   public static char nonrepeatingCharacter(String S)
    {
        if (S.isEmpty())
            return '$';
        Map<Character, Integer> characterCountMap = S.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> 1,
                        Integer::sum
                ));
        for (int i = 0; i < S.length(); i++) {
            Integer val = characterCountMap.get(S.charAt(i));
            if (val == 1){
                return S.charAt(i);
            }
        }
        return '$';
    }

   // 2nd Solution
    public static char firstNonRepeatingCharacter(String S) {
        int[] count = new int[26]; // Array to store the count of each character
        int n = S.length();
        int[] indices = new int[26]; // Array to store the index of the first occurrence of each character

        // Step 1: Count the occurrences of each character and store the first occurrence index
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            count[c - 'a']++;
            if (indices[c - 'a'] == 0) {
                indices[c - 'a'] = i + 1; // Adding 1 to differentiate from uninitialized indices
            }
        }

        int minIndex = Integer.MAX_VALUE;

        // Step 2: Find the minimum index among characters with a count of 1
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                minIndex = Math.min(minIndex, indices[i]);
            }
        }

        // If no non-repeating character is found, return '$'
        if (minIndex == Integer.MAX_VALUE) {
            return '$';
        }

        // Return the character corresponding to the minimum index
        return S.charAt(minIndex - 1);
    }
}
