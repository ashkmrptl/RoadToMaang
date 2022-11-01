package scaler.twoPointers;

/**
 * Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct
 * configurations can be created using elements of this array as length and breadth whose area is lesser than B.
 * (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
 */
public class AnotherCountRectangles {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 2};
        int B = 5;
        System.out.println(solve(A, B));

        A = new int[]{1, 2};
        B = 1;
        System.out.println(solve(A, B));

        A = new int[]{1, 2, 3, 4, 5};
        B = 5;
        System.out.println(solve(A, B));

        A = new int[]{3, 29, 33, 40, 44, 49};
        B = 72;
        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int B) {
        int mod = (1000 * 1000 * 1000) + 7;
        int l = 0, r = A.length - 1;
        long ans = 0;
        while (l <= r) {
            long area = (long) A[l] * A[r];
            if (area < B) {
                int size = (r - l + 1);
                ans = ans % mod + (((long) 2 * size) - 1) % mod;
                l++;
            } else {
                r--;
            }
        }
        return (int) ans % mod;
    }

    private static int solve_mine(int[] A, int B) {
        int mod = 1000000007;
        long count = 0;

        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            int x = A[i];
            int y = A[j];

            long area = ((long) x * (long) y) % mod;

            if (area < B) {
                long total = ((j - i) * 2L) % mod;
                count = (count % mod + total % mod + 1 % mod) % mod;

                while (i < A.length && A[i] == x)
                    i++;
            } else {
                while (j >= i && A[j] == y)
                    j--;
            }
        }

        return (int) (count % 1000000007);
    }
}
