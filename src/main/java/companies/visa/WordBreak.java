package companies.visa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordbreak(s, wordDict));

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println(wordbreak(s, wordDict));

        s = "catsanddog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println(wordbreak(s, wordDict));

        s = "catsanddog";
        wordDict = List.of("cats", "dog", "and", "cat");
        System.out.println(wordbreak(s, wordDict));
    }

    private static boolean wordbreak(String s, List<String> wordDict) {
        //return solveRecursively(s, new HashSet<>(wordDict), 0);

        /*boolean[] dp = new boolean[s.length() + 1];
        solveRecursivelyWithMemoization(s, new HashSet<>(wordDict), 0, dp);

        return dp[s.length()];*/

        return solveUsingDP(s, new HashSet<>(wordDict));
    }

    private static boolean solveUsingDP(String s, Set<String> dictionary) {
        boolean[] dp = new boolean[s.length() + 1];

        //dp[0] is true because an empty string can always be segmented
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    private static boolean solveRecursively(String s, Set<String> dictionary, int position) {
        if (position == s.length()) {
            return true;
        }

        for (int i = position; i < s.length() + 1; ++i) {
            if (dictionary.contains(s.substring(position, i)) && solveRecursively(s, dictionary, i)) {
                return true;
            }
        }

        return false;
    }

    private static boolean solveRecursivelyWithMemoization(String s, Set<String> dictionary, int position, boolean[] dp) {
        if (position == s.length()) {
            dp[position] = true;
            return true;
        }

        if (dp[position]) {
            return true;
        }

        for (int i = position; i < s.length() + 1; ++i) {
            if (dictionary.contains(s.substring(position, i)) && solveRecursivelyWithMemoization(s, dictionary, i, dp)) {
                dp[position] = true;
                return true;
            }
        }

        dp[position] = false;
        return false;
    }
}
