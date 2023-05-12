package companies.walmart;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

        s = "a";
        t = "a";

        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        final Map<Character, Integer> patternFrequency = new HashMap<>();

        for (final Character c : t.toCharArray()) {
            patternFrequency.put(c, patternFrequency.getOrDefault(c, 0) + 1);
        }

        final Map<Character, Integer> currentFrequency = new HashMap<>();

        int i = 0;
        int j = 0;

        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = -1;
        int minEnd = -1;

        while (i < m) {
            //Count the current chars frequency
            currentFrequency.put(s.charAt(i), currentFrequency.getOrDefault(s.charAt(i), 0) + 1);

            if (patternFrequency.containsKey(s.charAt(i)) && currentFrequency.get(s.charAt(i)) <= patternFrequency.get(s.charAt(i))) {
                count++;
            }

            //Check if the count == pattern length. If yes, found one substring
            if (count == n) {
                int length = i - j + 1;
                if (length < minLength) {
                    minStart = j;
                    minEnd = i;
                    minLength = length;
                }

                //Squeeze the window
                while (count == n) {
                    currentFrequency.put(s.charAt(j), currentFrequency.get(s.charAt(j)) - 1);
                    if (patternFrequency.containsKey(s.charAt(j)) && currentFrequency.get(s.charAt(j)) < patternFrequency.get(s.charAt(j))) {
                        count--;

                        int ln = i - j + 1;
                        if (ln < minLength) {
                            minStart = j;
                            minEnd = i;
                            minLength = ln;
                        }
                    }
                    j++;
                }
            }

            i++;
        }

        return s.substring(minStart, minEnd + 1);
    }
}
