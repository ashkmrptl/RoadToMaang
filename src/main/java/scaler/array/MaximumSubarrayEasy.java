package scaler.array;

/**
 * Problem Description
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 103
 * 1 <= B <= 109
 * 1 <= C[i] <= 106
 * <p>
 * <p>
 * Input Format
 * The first argument is the integer A.
 * The second argument is the integer B.
 * The third argument is the integer array C.
 * <p>
 * <p>
 * Output Format
 * Return a single integer which denotes the maximum sum.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = 5
 * B = 12
 * C = [2, 1, 3, 4, 5]
 * Input 2:
 * <p>
 * A = 3
 * B = 1
 * C = [2, 2, 2]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 12
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
 * Explanation 2:
 * <p>
 * All elements are greater than B, which means we cannot select any subarray.
 * Hence, the answer is 0.
 */
public class MaximumSubarrayEasy {
    public static void main(String[] args) {
        int A = 5;
        int B = 7;
        int[] C = new int[]{3, 8, 8, 9, 7};
        System.out.println(maxSubArray(A, B, C));
        System.out.println(maxSubArrayOptimized(A, B, C));
    }

    private static int maxSubArrayOptimized(int A, int B, int[] C) {
        int ans = 0;
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += C[j];
                if (sum <= B)
                    ans = Math.max(ans, sum);
                else break;
            }
        }
        return ans;
    }

    private static int maxSubArray(int A, int B, int[] C) {
        int maxSum = Integer.MIN_VALUE;

        final int[] pf = new int[A];
        pf[0] = C[0];
        for (int i = 1; i < A; i++) {
            pf[i] = pf[i - 1] + C[i];
        }

        for (int i = 0; i < pf.length; i++) {
            for (int j = i; j < pf.length; j++) {
                int sumOfElements;
                if (i == 0) {
                    sumOfElements = pf[j];
                } else {
                    sumOfElements = pf[j] - pf[i - 1];
                }

                if (sumOfElements <= B && sumOfElements > maxSum) {
                    maxSum = sumOfElements;
                }
            }
        }

        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}
