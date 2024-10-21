package companies.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 * <p>
 * 2472. Maximum Number of Non-overlapping Palindrome Substrings
 */

public class MaximumNumberOfNonoverlappingPalindromeSubstrings {
    public static void main(String[] args) {
        System.out.println(maxPalindromes("abacabadabacaba", 3));
    }

    public static int maxPalindromes(String s, int k) {
        int n = s.length();
        // List to store end indices of palindromic substrings starting at each index
        List<List<Integer>> palindromes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            palindromes.add(new ArrayList<>());
        }

        // Function to expand around center and populate palindromes list
        // For odd length palindromes
        for (int center = 0; center < n; center++) {
            int left = center, right = center;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= k) {
                    palindromes.get(left).add(right);
                }
                left--;
                right++;
            }
        }

        // For even length palindromes
        for (int center = 0; center < n - 1; center++) {
            int left = center, right = center + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= k) {
                    palindromes.get(left).add(right);
                }
                left--;
                right++;
            }
        }

        // DP array where dp[i] is the max number of palindromic substrings from i to end
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // Initialize dp[i] as dp[i+1], meaning skip current character
            dp[i] = dp[i + 1];
            // Iterate over all palindromic substrings starting at i
            for (int end : palindromes.get(i)) {
                if (end + 1 <= n) {
                    dp[i] = Math.max(dp[i], 1 + dp[end + 1]);
                }
            }
        }

        return dp[0];
    }

    private static int maxPalindromes_my_soln(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int ans = 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        for (int i = 0; i < s.length(); i++) {
            int count = countMaxPalindrome(s, k, dp, i);
            ans = Math.max(ans, count);
        }

        return ans;
    }

    private static int countMaxPalindrome(String s, int k, int[] dp, int start) {
        if (start >= s.length()) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }

        int maxCount = 0;
        for (int left = start; left + k - 1 < s.length(); left++) {
            int right = left + k - 1;

            while (right < s.length()) {
                if (isPalindrome(s, left, right)) {
                    int count = countMaxPalindrome(s, k, dp, right + 1) + 1;
                    maxCount = Math.max(maxCount, count);
                    break;
                } else {
                    right++;
                }
            }
        }

        dp[start] = maxCount;
        return maxCount;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
