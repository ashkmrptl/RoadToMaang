package scaler.hashing;

/**
 * You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
 * <p>
 * A boring substring has the following properties:
 * <p>
 * Its length is 2.
 * Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
 * Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
 */
public class BoringSubString {
    public static void main(String[] args) {
        String A = "abcd";

        System.out.println(solve(A));
    }

    private static int solve(String A) {
        int oddMax = Integer.MIN_VALUE;
        int oddMin = Integer.MAX_VALUE;
        int evenMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;

        for (int i = 0; i < A.length(); i++) {
            int value = A.charAt(i) - 'a' + 1;
            if (value % 2 != 0) {
                oddMax = Math.max(oddMax, value);
                oddMin = Math.min(oddMin, value);
            } else {
                evenMax = Math.max(evenMax, value);
                evenMin = Math.min(evenMin, value);
            }
        }

        if (Math.abs(evenMin - oddMax) > 1) {
            return 1;
        }
        if (Math.abs(oddMin - evenMax) > 1) {
            return 1;
        }
        return 0;
    }
}
