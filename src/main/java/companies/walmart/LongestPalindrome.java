package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bananas"));
        System.out.println(longestPalindrome("a"));
    }

    private static int longestPalindrome(String s) {
        final Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (frequency.containsKey(s.charAt(i))) {
                frequency.put(s.charAt(i), frequency.get(s.charAt(i)) + 1);
            } else {
                frequency.put(s.charAt(i), 1);
            }
        }

        int oddCount = 0;

        int length = 0;

        for (final Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                length += entry.getValue();
            } else {
                oddCount++;
                length += entry.getValue() - 1;
            }
        }

        if (oddCount > 0) {
            length += 1;
        }

        return length;
    }
}
