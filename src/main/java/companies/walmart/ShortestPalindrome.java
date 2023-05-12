package companies.walmart;

public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(shortestPalindrome(s));

        s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }

    private static String shortestPalindrome(String s) {
        int lps = lps(s);

        final String ans = new StringBuilder(s.substring(lps)).reverse() + s;

        return ans;
    }

    private static int lps(String s) {
        final String str = s + "#" + new StringBuilder(s).reverse();

        int[] lps = new int[str.length()];

        int length = 0;
        int i = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length > 0) {
                    length = lps[length - 1];
                } else {
                    i++;
                }
            }
        }

        return lps[lps.length - 1];
    }
}
