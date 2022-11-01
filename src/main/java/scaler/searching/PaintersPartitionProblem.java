package scaler.searching;

/**
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3.... CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
 *
 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 *
 * Return the ans % 10000003.
 */
public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int A = 2;
        int B = 5;
        int[] C = new int[]{1, 10};

        System.out.println(paint(A, B, C));

        C = new int[]{1, 8, 11, 3};
        System.out.println(paint(10, 1, C));

        C = new int[]{1000000, 1000000};
        System.out.println(paint(1, 100000, C));
    }

    private static int paint(int A, int B, int[] C) {
        int l = Integer.MIN_VALUE;
        int r = 0;

        for (int i = 0; i < C.length; i++) {
            l = Math.max(l, C[i]);
            r += C[i];
        }

        long ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (check(A, B, mid, C)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int mod = 10000003;
        return (int) ((ans % mod * B % mod) % mod);
    }

    private static boolean check(int a, int b, int mid, int[] c) {
        int worker = 1;
        int currentWork = 0;

        for (int i = 0; i < c.length; i++) {
            if (currentWork + (c[i]) <= mid) {
                currentWork += c[i];
            } else {
                worker++;
                currentWork = c[i];
            }
        }

        if (worker > a) {
            return false;
        } else {
            return true;
        }
    }
}
