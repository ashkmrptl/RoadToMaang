package companies.walmart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        System.out.println(wordBreak(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        return solveUsingDP(s, new HashSet<>(wordDict));
    }

    private static boolean solveUsingDP(String s, Set<String> dict) {
        final boolean[] dp = new boolean[s.length() + 1];

        //Setting dp[0] as TRUE as an empty String can be broken into segments
        dp[0] = true;

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (dp[j] && dict.contains(subStr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
