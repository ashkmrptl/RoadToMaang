package companies.cisco;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

        s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int maxLeft = -1;
        int maxRight = -1;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if ((right - left - 1) > maxLength) {
                maxLength = right - left - 1;
                maxLeft = left + 1;
                maxRight = right - 1;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if ((right - left - 1) > maxLength) {
                maxLength = right - left - 1;
                maxLeft = left + 1;
                maxRight = right - 1;
            }
        }

        return s.substring(maxLeft, maxRight + 1);

    }
}
