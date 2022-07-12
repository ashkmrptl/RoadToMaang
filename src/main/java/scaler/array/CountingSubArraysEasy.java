package scaler.array;

/**
 * Problem Description
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum less than B.
 * We may assume that there is no overflow.
 * <p>
 * Problem Constraints
 * 1 <= N <= 103
 * 1 <= A[i] <= 1000
 * 1 <= B <= 107
 * <p>
 * Input Format
 * First argument is an integer array A.
 * Second argument is an integer B.
 * <p>
 * Output Format
 * Return an integer denoting the number of subarrays in A having sum less than B.
 * <p>
 * Example Input
 * Input 1:
 * A = [2, 5, 6]
 * B = 10
 * Input 2:
 * A = [1, 11, 2, 3, 15]
 * B = 10
 * <p>
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * 4
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
 * Explanation 2:
 * <p>
 * The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */
public class CountingSubArraysEasy {
    public static void main(String[] args) {
        int B = 10;
        int[] A = new int[]{1, 11, 2, 3, 15};

        System.out.println(maxSubArrayOptimized(A, B));
    }

    private static int maxSubArrayOptimized(int[] A, int B) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum < B) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
