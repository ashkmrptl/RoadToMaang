package scaler.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 * Given a number A, find if it is COLORFUL number or not.
 * If number A is a COLORFUL number return 1 else, return 0.
 * <p>
 * What is a COLORFUL Number:
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
 * <p>
 * Problem Constraints
 * 1 <= A <= 2 * 109
 * <p>
 * Input Format
 * The first and only argument is an integer A.
 * <p>
 * Output Format
 * Return 1 if integer A is COLORFUL else return 0.
 * <p>
 * Example Input
 * Input 1:
 * A = 23
 * Input 2:
 * A = 236
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Possible Sub-sequences: [2, 3, 23] where
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6  (product of digits)
 * This number is a COLORFUL number since product of every digit of a sub-sequence are different.
 * Explanation 2:
 * <p>
 * Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 * 2 -> 2
 * 3 -> 3
 * 6 -> 6
 * 23 -> 6  (product of digits)
 * 36 -> 18  (product of digits)
 * 236 -> 36  (product of digits)
 * This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 */
public class ColorfulNumber {
    public static void main(String[] args) {
        int A = 23;
        System.out.println(solve(A));
    }

    //TC O(n^3) SC O(n)
    private static int solve(int A) {
        String num = String.valueOf(A);

        Set<Long> set = new HashSet<>();

        for (int i = 0; i < num.length(); i++) {
            long digit = Long.parseLong(num.charAt(i) + "");
            if (set.contains(digit)) {
                return 0;
            } else {
                set.add(digit);
            }
            for (int j = i + 1; j < num.length(); j++) {
                long mul = 1;
                for (int k = i; k <= j; k++) {
                    mul *= Integer.parseInt(num.charAt(k) + "");
                }
                if (set.contains(mul)) {
                    return 0;
                } else {
                    set.add(mul);
                }
            }
        }
        return 1;
    }

    //TC O(n^2) SC O(n)
    private static int slightlyBetterApproach(int num) {
        int noOfDigits = 0;
        int temp = num;

        while (temp > 0) {
            temp = temp / 10;
            noOfDigits++;
        }

        int[] A = new int[noOfDigits];
        temp = num;

        int a = 0;
        while (temp > 0) {
            A[a] = temp % 10;
            temp = temp / 10;
            a++;
        }

        long[] pf = new long[A.length];
        pf[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            pf[i] = A[i] * pf[i - 1];
        }

        final Set<Long> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                long product;
                if (i == 0) {
                    product = pf[j];
                } else {
                    product = pf[j] / pf[i - 1];
                }
                if (set.contains(product)) {
                    return 0;
                } else {
                    set.add(product);
                }
            }
        }
        return 1;
    }
}
