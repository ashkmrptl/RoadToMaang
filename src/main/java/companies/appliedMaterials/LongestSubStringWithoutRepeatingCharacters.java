package companies.appliedMaterials;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("au"));

        System.out.println(lengthOfLongestSubString("bbbbb"));

        System.out.println(lengthOfLongestSubString("pwwkew"));

        System.out.println(lengthOfLongestSubString("abcaabcdba"));
    }

    //Sliding window approach
    private static int lengthOfLongestSubString(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() <= 1) {
            return s.length();
        }

        int length = 0;

        final Map<Character, Integer> frequencyMap = new HashMap<>();

        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (frequencyMap.getOrDefault(s.charAt(j), 0) < 1) {
                frequencyMap.put(s.charAt(j), 1);
                j++;
            } else {
                length = Math.max(length, j - i);
                while (i <= j && frequencyMap.get(s.charAt(j)) != 0) {
                    frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i)) - 1);
                    i++;
                }
            }
        }

        length = Math.max(length, j - i);

        return length;
    }
}
