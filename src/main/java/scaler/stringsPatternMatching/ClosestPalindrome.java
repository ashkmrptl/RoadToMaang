package scaler.stringsPatternMatching;

/**
 * Groot has a profound love for palindrome which is why he keeps fooling around with strings.
 * A palindrome string is one that reads the same backward as well as forward.
 * <p>
 * Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.
 */
public class ClosestPalindrome {
    public static void main(String[] args) {
        String A = "abbba";
        System.out.println(solve(A));

        A = "adaddb";
        System.out.println(solve(A));
    }

    private static String solve(String A) {
        int n = A.length();
        int mid = n / 2;

        int start;
        int end = mid - 1;

        if (n % 2 == 0) {
            start = mid;
        } else {
            start = mid + 1;
        }

        int mismatchCount = 0;
        int i = 0;
        int j = n - 1;
        while (i <= end && j >= start) {
            char charFromFirstHalf = A.charAt(i);
            char charFromSecondHalf = A.charAt(j);
            if (charFromFirstHalf != charFromSecondHalf) {
                mismatchCount++;
            }
            i++;
            j--;
        }
        if (mismatchCount > 1) {
            return "NO";
        }
        if (n % 2 == 0 && mismatchCount == 0) {
            return "NO";
        }

        return "YES";
    }
}
