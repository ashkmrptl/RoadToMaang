package companies.microsoft;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "ace";
        String text2 = "abcde";

        System.out.println(longestCommonSubsequence(text1, text2));
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int diag = 0;
            for (int j = 1; j <= n; j++) {
                int nextDiag = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = diag + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                diag = nextDiag;
            }
        }

        return dp[n];
    }

    private static int longestCommonSubsequence_2D_Array(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
