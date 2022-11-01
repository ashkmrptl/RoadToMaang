package scaler.twoPointers;

/**
 * Given three sorted arrays A, B and C of not necessarily same sizes.
 * <p>
 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c
 * such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.
 */
public class MinimizeTheAbsoluteDifference {
    public static void main(String[] args) {
        int[] A = new int[]{1, 4, 5, 8, 10};
        int[] B = new int[]{6, 9, 15};
        int[] C = new int[]{2, 3, 6, 6, 7};

        System.out.println(solve(A, B, C));
    }

    private static int solve(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;

        int ans = Integer.MAX_VALUE;

        while (i < A.length && j < B.length && k < C.length) {
            int a = A[i];
            int b = B[j];
            int c = C[k];

            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));

            int diff = Math.abs(min - max);
            ans = Math.min(ans, diff);

            if (A[i] == min) {
                i++;
            }
            if (B[j] == min) {
                j++;
            }
            if (C[k] == min) {
                k++;
            }
        }

        return ans;
    }
}
