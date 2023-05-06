package scaler.dynamicProgramming;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{4, 2, -5, 1};
        System.out.println(maxProduct(A));

        A = new int[]{-3, 0, -5, 0};
        System.out.println(maxProduct(A));

        A = new int[]{0, 0, 0, -3, -2, 0, 1, 0, 0, 0, 0, 0, -2, 0, 0, 0, 3, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(maxProduct(A));

        A = new int[]{0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(maxProduct(A));
    }

    private static int maxProduct(final int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int min = A[0];
        int max = A[0];
        int result = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }

            min = Math.min(A[i], A[i] * min);

            max = Math.max(A[i], A[i] * max);

            result = Math.max(result, Math.max(min, max));
        }
        return result;
    }
}
