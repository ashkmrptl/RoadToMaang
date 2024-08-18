package companies.microsoft;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        final List<Integer> ans = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return ans;
        }

        int[] counts = new int[26];

        for (char ch : p.toCharArray()) {
            counts[ch - 'a']++;
        }

        int left = 0;
        int right = 0;

        int count = p.length();

        while (right < s.length()) {
            if (counts[s.charAt(right++) - 'a']-- >= 1) {
                count--;
            }

            if (count == 0) {
                ans.add(left);
            }

            if (right - left == p.length() && counts[s.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }

        return ans;
    }
}
