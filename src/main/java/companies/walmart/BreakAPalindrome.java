package companies.walmart;

/**
 * 1328. Break a Palindrome
 * https://leetcode.com/problems/break-a-palindrome/description/
 */
public class BreakAPalindrome {
    public static void main(String[] args) {
        String palindrome = "abccba";
        System.out.println(breakPalindrome(palindrome));

        palindrome = "a";
        System.out.println(breakPalindrome(palindrome));
    }

    private static String breakPalindrome(String palindrome) {
        if (palindrome.isEmpty() || palindrome.length() == 1) {
            return "";
        }

        final StringBuilder sb = new StringBuilder(palindrome);

        int i = 0;
        while (sb.charAt(i) == 'a') {
            i++;
            if (i == sb.length()) {
                if (sb.charAt(i - 1) == 'a') {
                    sb.setCharAt(i - 1, 'b');
                    return sb.toString();
                }
            }
        }

        sb.setCharAt(i, 'a');

        return sb.toString();
    }
}
