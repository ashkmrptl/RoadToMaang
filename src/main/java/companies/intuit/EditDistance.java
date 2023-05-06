package companies.intuit;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));

        word1 = "intention";
        word2 = "execution";
        System.out.println(minDistance(word1, word2));

        word1 = "aac";
        word2 = "abac";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];

        return findCost(A, m - 1, B, n - 1, dp);
    }

    public static int findCost(String A, int i, String B, int j, int[][] dp) {
        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = -1;

        if (A.charAt(i) == B.charAt(j)) {
            ans = findCost(A, i - 1, B, j - 1, dp);
        } else {
            int x = findCost(A, i, B, j - 1, dp) + 1;
            int y = findCost(A, i - 1, B, j - 1, dp) + 1;
            int z = findCost(A, i - 1, B, j, dp) + 1;

            ans = Math.min(x, Math.min(y, z));
        }

        dp[i][j] = ans;
        return ans;
    }
}
