package scaler.array;

/**
 * Problem Description
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 103
 * 1 <= A[i] <= 103
 * 1 <= B <= 107
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is an integer B.
 * <p>
 * Output Format
 * Return the count of good subarrays in A.
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 4
 * Input 2:
 * A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
 * B = 65
 * <p>
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * 36
 * <p>
 * Example Explanation
 * Explanation 1:
 * Even length good subarrays = {1, 2}
 * Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
 */
public class GoodSubArraysEasy {
    public static void main(String[] args) {
        int B = 4;
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A, B));

        B = 65;
        A = new int[]{13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int B) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum < B && ((j - i + 1) % 2 == 0)) {
                    ans++;
                } else if (sum > B && ((j - i + 1) % 2 != 0)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
