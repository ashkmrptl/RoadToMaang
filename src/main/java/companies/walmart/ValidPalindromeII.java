package companies.walmart;

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));

        System.out.println(validPalindrome("abca"));

        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(l + 1, r, s) || isPalindrome(l, r - 1, s);
            }
            l++;
            r--;
        }

        return true;
    }

    private static boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
