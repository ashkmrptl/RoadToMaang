package scaler.twoPointers;

/**
 * You are given 3 sorted arrays A, B and C.
 * <p>
 * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * <p>
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 */
public class Array3Pointers {
    public static void main(String[] args) {
        int[] A = new int[]{1, 4, 10};
        int[] B = new int[]{2, 15, 20};
        int[] C = new int[]{10, 12};

        System.out.println(solve(A, B, C));

        A = new int[]{3, 5, 6};
        B = new int[]{2};
        C = new int[]{3, 4};

        System.out.println(solve(A, B, C));
    }

    /**
     * Approach:
     * We have to find max(abs(A[i] - B[j]), abs(B[j], C[k]), abs(C[k], A[i])) when minimized
     * This can be simplified as Math.min(max(A[i], B[j], C[k]) - min(A[i], B[j], C[k]))
     */
    private static int solve(int[] A, int[] B, int[] C) {
        int n = A.length;
        int m = B.length;
        int o = C.length;

        int ans = Integer.MAX_VALUE;

        int i = 0, j = 0, k = 0;
        while (i < n && j < m && k < o) {
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            int min = Math.min(A[i], Math.min(B[j], C[k]));

            int diff = Math.abs(max - min);
            ans = Math.min(ans, diff);

            if (min == A[i]) {
                i++;
            } else if (min == B[j]) {
                j++;
            } else {
                k++;
            }
        }

        return ans;
    }
}
