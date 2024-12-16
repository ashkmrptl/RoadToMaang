package companies.walmart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2068. Check Whether Two Strings are Almost Equivalent
 * https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/description/
 */
public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public static void main(String[] args) {
        String word1 = "aaaa";
        String word2 = "bccb";
        System.out.println(checkAlmostEquivalent(word1, word2));

        word1 = "abcdeef";
        word2 = "abaaacc";
        System.out.println(checkAlmostEquivalent(word1, word2));

        word1 = "cccddabba";
        word2 = "babababab";
        System.out.println(checkAlmostEquivalent(word1, word2));
    }

    private static boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> charDiff = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            charDiff.put(word1.charAt(i), charDiff.getOrDefault(word1.charAt(i), 0) + 1);
            charDiff.put(word2.charAt(i), charDiff.getOrDefault(word2.charAt(i), 0) - 1);
        }

        for (int diff : charDiff.values()) {
            if (Math.abs(diff) > 3) {
                return false;
            }
        }

        return true;
    }
}
