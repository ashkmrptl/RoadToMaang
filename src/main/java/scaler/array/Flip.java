package scaler.array;

import java.util.Arrays;

/**
 * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
 * In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR.
 * By flipping, we mean changing character 0 to 1 and vice-versa.
 * Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
 * If there are multiple solutions, return the lexicographically smallest pair of L and R.
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 */
public class Flip {
    public static void main(String[] args) {
        String A = "1101010001";
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(String A) {
        int n = A.length();

        int curSum = 0;
        int maxSum = 0;

        int index = 0;
        int leftIndex = 0;
        int rightIndex = -1;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                curSum++;
            } else {
                curSum--;
            }
            if (curSum < 0) {
                index = i + 1;
                curSum = 0;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                rightIndex = i;
                leftIndex = index;
            }

        }
        if (rightIndex == -1) {
            return new int[0];
        } else {
            return new int[]{leftIndex + 1, rightIndex + 1};
        }
    }
}
