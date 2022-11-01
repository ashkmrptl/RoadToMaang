package scaler.bitManipulation;

/**
 * We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
 * For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
 * <p>
 * You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
 */
public class DifferentBitsSum {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i];
                int b = A[j];

                int diff = countSetBits(a ^ b) * 2;

                sum += diff;
            }
        }

        return sum;
    }

    private static int countSetBits(int number) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((number & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }
}
