package companies.intuit;

import java.util.Arrays;

/**
 * ven two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * <p>
 * Examples :
 * <p>
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 * Output : 5
 * Explanation:
 * The longest common substring is “Geeks” and is of length 5.
 * <p>
 * Input : X = “abcdxyz”, y = “xyzabcd”
 * Output : 4
 * Explanation:
 * The longest common substring is “abcd” and is of length 4.
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";

        System.out.println(solve(s1, s2));
        System.out.println(longestCommonSubsequence(s1, s2));
    }

    /**
     * Copied from leetcode submission
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m < n) return longestCommonSubsequence(text2, text1); // swap so that text2 is the shorter string

        int[] dp = new int[n + 1];
        for (int i = 1; i < m + 1; i++) {
            int diag = 0;
            for (int j = 1; j < n + 1; j++) {
                int nextDiag = dp[j];
                if (text2.charAt(j - 1) == text1.charAt(i - 1)) dp[j] = diag + 1;
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                diag = nextDiag;
            }
        }
        return dp[n];
    }

    private static int solve(String s1, String s2) {
        //Create the DP array
        final int[][] dp = new int[s1.length()][s2.length()];

        //Populate the array with -1
        for (int[] elements : dp) {
            Arrays.fill(elements, -1);
        }

        return lcs(dp, s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private static int lcs(int[][] dp, String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(dp, s1, s2, i - 1, j - 1);
        } else {
            dp[i][j] = Math.max(lcs(dp, s1, s2, i - 1, j), lcs(dp, s1, s2, i, j - 1));
        }

        return dp[i][j];
    }
}
