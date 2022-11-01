package scaler.strings;

/**
 * Problem Description
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * <p>
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 * <p>
 * Problem Constraints
 * 1 <= N <= 6000
 * <p>
 * Input Format
 * First and only argument is a string A.
 * <p>
 * Output Format
 * Return a string denoting the longest palindromic substring of string A.
 * <p>
 * Example Input
 * A = "aaaabaaa"
 * <p>
 * Example Output
 * "aaabaaa"
 * <p>
 * Example Explanation
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String A = "aaaabaaa";
        System.out.println(solve(A));

        A = "sdfykfyasdkiaabbccdaabbtybbasdfgerwregfdsabb";
        System.out.println(solve(A));

        A = "a";
        System.out.println(solve(A));
    }

    /**
     * Approach: This approach takes O(n^2) TC and is not optimized, but it is better than the bruteforce approach which takes O(nn^3).
     * In this we find the longest palindrome separately with even length and with odd length.
     */
    private static String solve(final String A) {
        int maxStart = -1;
        int maxEnd = -1;
        int maxLength = Integer.MIN_VALUE;

        //For odd length palindrome
        for (int i = 0; i < A.length(); i++) {
            int right = i;
            int left = i;
            while (left >= 0 && right <= A.length() - 1 && A.charAt(left) == A.charAt(right)) {
                left--;
                right++;
            }
            int length = right - left - 1;
            if (length > maxLength) {
                maxStart = left + 1;
                maxEnd = right - 1;
                maxLength = length;
            }
        }

        //For even length palindrome
        for (int i = 0; i < A.length() - 1; i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right <= A.length() - 1 && A.charAt(left) == A.charAt(right)) {
                left--;
                right++;
            }
            int length = right - left - 1;
            if (length > maxLength) {
                maxStart = left + 1;
                maxEnd = right - 1;
                maxLength = length;
            }
        }

        return A.substring(maxStart, maxEnd + 1);
    }
}
