package companies.agoda;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=company&envId=agoda&favoriteSlug=agoda-all
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.length();
        }

        int i = 0;
        int j = 0;

        final Set<Character> set = new HashSet<>();

        int length = 0;

        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
            } else {
                length = Math.max(length, i - j);

                while (!set.isEmpty() && set.contains(s.charAt(i))) {
                    set.remove(s.charAt(j));
                    j++;
                }
            }
        }

        length = Math.max(length, i - j);

        return length == 0 ? set.size() : length;
    }
}
