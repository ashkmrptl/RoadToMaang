package scaler.modularArithmatic;

import java.util.Arrays;

/**
 * Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
 * Return the minimum result obtained.
 * <p>
 * Problem Constraints
 * 10 <= A, B, C <= 99
 * <p>
 * Input Format
 * The first argument of input contains an integer, A.
 * The second argument of input contains an integer, B.
 * The third argument of input contains an integer, C.
 * <p>
 * Output Format
 * Return an integer representing the answer.
 * <p>
 * Example Input
 * Input 1:
 * A = 10
 * B = 20
 * C = 30
 * Input 2:
 * A = 55
 * B = 43
 * C = 47
 * <p>
 * Example Output
 * Output 1:
 * 102030
 * Output 2:
 * 434755
 * <p>
 * Example Explanation
 * Explanation 1:
 * 10 + 20 + 30 = 102030
 * Explanation 2:
 * 43 + 47 + 55 = 434755
 */
public class ConcatenateThreeNumbers {
    public static void main(String[] args) {
        int A = 5, B = 3, C = 7;
        System.out.println(solve(A, B, C));
    }

    private static int solve(final int A, final int B, final int C) {

        int[] array = {A, B, C};
        Arrays.sort(array);

        return 10000 * array[0] + 100 * array[1] + array[2];
    }
}
