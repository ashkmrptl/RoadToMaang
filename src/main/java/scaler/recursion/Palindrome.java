package scaler.recursion;

public class Palindrome {
    public static void main(String[] args) {
        String A = "naman";
        System.out.println(solve(A));
    }

    private static int solve(final String A) {
        return isPalindrome(A, 0, A.length() - 1);
    }

    private static int isPalindrome(String A, int left, int right) {
        if (left >= right) {
            return 1;
        }

        if (A.charAt(left) != A.charAt(right)) {
            return 0;
        }

        return isPalindrome(A, left + 1, right - 1);
    }
}
