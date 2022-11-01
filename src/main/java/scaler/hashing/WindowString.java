package scaler.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
 * Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
 * <p>
 * Note:
 * <p>
 * If there is no such window in A that covers all characters in B, return the empty string.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
 */
public class WindowString {
    public static void main(String[] args) {
        System.out.println(solve("ADOBECODEBANC", "ABC"));
        System.out.println(solveUsingHashMap("ADOBECODEBANC", "ABC"));
    }

    private static String solveUsingHashMap(String A, String B) {
        int n = A.length();
        int m = B.length();

        //Edge case
        if (m > n) {
            return null;
        }

        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();

        //Build frequency map for pattern string
        for (char c : B.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int minStart = -1;

        int start = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            //count frequency of each character
            current.put(ch, current.getOrDefault(ch, 0) + 1);

            //If string's char matches with pattern's char then increment count
            if (required.containsKey(ch) && current.getOrDefault(ch, 0) <= required.getOrDefault(ch, 0)) {
                count++;
            }

            // if all the characters are matched
            if (count == m) {
                char startChar = A.charAt(start);
                int requiredCount = required.getOrDefault(startChar, 0);
                int currentCount = current.get(startChar);

                //Try to minimize the window i.e., check if any character is occurring more no. of times than its occurrence
                //in pattern, if yes then remove it from starting and also remove the useless characters.
                while (currentCount > requiredCount || !required.containsKey(startChar)) {
                    if (currentCount > requiredCount) {
                        if (current.containsKey(startChar)) {
                            if (current.get(startChar) == 1) {
                                current.remove(startChar);
                            } else {
                                current.put(startChar, current.get(startChar) - 1);
                            }
                            start++;
                            startChar = A.charAt(start);
                            requiredCount = required.getOrDefault(startChar, 0);
                            currentCount = current.get(startChar);
                        }
                    }

                    //Update window size
                    int length = i - start + 1;
                    if (length < minLength) {
                        minLength = length;
                        minStart = start;
                    }
                }
            }
        }

        if (minStart == -1) {
            return null;
        }

        return A.substring(minStart, minStart + minLength);
    }

    private static String solve(String A, String B) {
        int n = A.length();
        int m = B.length();

        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (n < m) {
            System.out.println("No such window exists");
            return "";
        }

        int[] hash_pat = new int[256];
        int[] hash_str = new int[256];

        // store occurrence ofs characters of pattern
        for (int i = 0; i < m; i++)
            hash_pat[B.charAt(i)]++;

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        // start traversing the string
        int count = 0; // count of characters
        for (int j = 0; j < n; j++) {
            // count occurrence of characters of string
            hash_str[A.charAt(j)]++;

            // If string's char matches with pattern's char
            // then increment count
            if (hash_pat[A.charAt(j)] != 0 &&
                    hash_str[A.charAt(j)] <= hash_pat[A.charAt(j)])
                count++;

            // if all the characters are matched
            if (count == m) {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (hash_str[A.charAt(start)] > hash_pat[A.charAt(start)]
                        || hash_pat[A.charAt(start)] == 0) {

                    if (hash_str[A.charAt(start)] > hash_pat[A.charAt(start)])
                        hash_str[A.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting from start_index
        // and length min_len
        return A.substring(start_index, start_index + min_len);
    }
}
