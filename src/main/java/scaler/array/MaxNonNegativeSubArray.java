package scaler.array;

import java.util.Arrays;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 5, -7, 2, 5};
        System.out.println(Arrays.toString(solve(A)));

        A = new int[]{-1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(solve(A)));

        A = new int[]{756898537, -1973594324, -2038664370, -184803526, 1424268980};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(int[] A) {
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;

        int start = 0;

        for (int i = 0; i <= A.length; i++) {
            if (i == A.length || A[i] < 0) {
                if (sum > maxSum) {
                    maxSum = sum;
                    maxStart = start;
                    maxEnd = i - 1;
                } else if (sum == maxSum) {
                    int length1 = (((i - 1) - start) + 1);
                    int length2 = (maxEnd - maxStart + 1);
                    if (length1 == length2) {
                        maxStart = Math.min(maxStart, start);
                        maxEnd = Math.min(maxEnd, i - 1);
                    } else if (length1 > length2) {
                        maxStart = start;
                        maxEnd = i - 1;
                    }
                }
                start = i + 1;
                sum = 0;
            } else {
                sum += A[i];
            }
        }

        int n = maxEnd - maxStart + 1;
        int[] ans = new int[n];

        if (n == 1 && A[maxStart] < 0) {
            return new int[0];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = A[i + maxStart];
        }

        return ans;
    }
}
