package companies.walmart;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(longestPalindrome(s));

        s = "babxd";
        System.out.println(longestPalindrome(s));

        s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    //Following is the DP solution
    private static String longestPalindrome(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        //Set diagonal cells
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        int leftMax = 0;
        int rightMax = 0;

        int length = 1;

        //For length two substring
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                length = 2;
                if (leftMax == rightMax) {
                    leftMax = i;
                    rightMax = i + 1;
                }
            }
        }

        //For remaining cells
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    if (j - i + 1 > length) {
                        leftMax = i;
                        rightMax = j;
                        length = j - i + 1;
                    }
                }
            }
        }

        return s.substring(leftMax, rightMax + 1);
    }
}
