package companies.cisco;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString(s));

        s = "bbbbb";
        System.out.println(lengthOfLongestSubString(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubString(s));

        s = "au";
        System.out.println(lengthOfLongestSubString(s));
    }

    private static int lengthOfLongestSubString(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        final Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;

        int ans = 0;

        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                ans = Math.max(ans, set.size());

                while (s.charAt(j) != s.charAt(i)) {
                    set.remove(s.charAt(j));
                    j++;
                }
                j++;
            }
            i++;
        }

        ans = Math.max(ans, set.size());

        return ans;
    }
}
