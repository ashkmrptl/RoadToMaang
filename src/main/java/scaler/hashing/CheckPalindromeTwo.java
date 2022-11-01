package scaler.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string A consisting of lowercase characters.
 * <p>
 * Check if characters of the given string can be rearranged to form a palindrome.
 * <p>
 * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 */
public class CheckPalindromeTwo {
    public static void main(String[] args) {
        String A = "abcde";
        System.out.println(solve(A));

        A = "abbaee";
        System.out.println(solve(A));
    }

    private static int solve(String A) {
        final Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int oddCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount > 1) {
            return 0;
        }
        return 1;
    }
}
