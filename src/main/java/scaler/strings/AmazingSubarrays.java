package scaler.strings;

import java.util.Set;

/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 * <p>
 * Input
 * Only argument given is string S.
 * Output
 * Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
 * Constraints
 * <p>
 * 1 <= length(S) <= 1e6
 * S can have special characters
 * Example
 * <p>
 * Input
 * ABEC
 * Output
 * 6
 * <p>
 * Explanation
 * Amazing substrings of given string are :
 * 1. A
 * 2. AB
 * 3. ABE
 * 4. ABEC
 * 5. E
 * 6. EC
 * here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubarrays {
    public static void main(String[] args) {
        String A = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn";
        System.out.println(solve(A));

        A = "ABEC";
        System.out.println(solve(A));
    }

    private static int solve(final String A) {
        final Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        long total = 0;

        for (int i = 0; i < A.length(); i++) {
            if (set.contains(A.charAt(i))) {
                total += A.length() - i;
            }
        }

        return (int) (total % 10003);
    }
}
