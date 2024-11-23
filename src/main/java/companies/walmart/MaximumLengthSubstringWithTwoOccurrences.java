package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * 3090. Maximum Length Substring With Two Occurrences
 * https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class MaximumLengthSubstringWithTwoOccurrences {
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba"));
        System.out.println(maximumLengthSubstring("aaaa"));
    }

    private static int maximumLengthSubstring(String s) {
        int maxLength = 0;

        int i = 0;
        int j = 0;

        final Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            final char ch = s.charAt(j);
            if (!map.containsKey(ch) || map.get(ch) < 2) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else {
                 while (map.get(ch) == 2) {
                     final char toRemove = s.charAt(i);
                     if (map.get(toRemove) == 1) {
                         map.remove(toRemove);
                     } else {
                         map.put(toRemove, map.get(toRemove) - 1);
                     }
                     i++;
                 }
            }
        }

        return maxLength;
    }
}
