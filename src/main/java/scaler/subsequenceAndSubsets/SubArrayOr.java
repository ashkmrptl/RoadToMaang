package scaler.subsequenceAndSubsets;

/**
 * Problem Description
 * You are given an array of integers A of size N.
 * The value of a subarray is defined as BITWISE OR of all elements in it.
 * Return the sum of value of all subarrays of A % 109 + 7.
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 108
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * Output Format
 * Return the sum of Value of all subarrays of A % 109 + 7.
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * A = [7, 8, 9, 10]
 * <p>
 * Example Output
 * Output 1:
 * 71
 * Output 2:
 * 110
 * <p>
 * Example Explanation
 * Explanation 1:
 * Value([1]) = 1
 * Value([1, 2]) = 3
 * Value([1, 2, 3]) = 3
 * Value([1, 2, 3, 4]) = 7
 * Value([1, 2, 3, 4, 5]) = 7
 * Value([2]) = 2
 * Value([2, 3]) = 3
 * Value([2, 3, 4]) = 7
 * Value([2, 3, 4, 5]) = 7
 * Value([3]) = 3
 * Value([3, 4]) = 7
 * Value([3, 4, 5]) = 7
 * Value([4]) = 4
 * Value([4, 5]) = 5
 * Value([5]) = 5
 * Sum of all these values = 71
 * Explanation 2:
 * Sum of value of all subarray is 110.
 */
public class SubArrayOr {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));
        System.out.println(solveOptimized(A));

        A = new int[]{7, 8, 9, 10};
        System.out.println(solve(A));
        System.out.println(solveOptimized(A));
    }

    //As the array contains integers, we take a number can be of 32 bits. hence the outer loop will run for 32 times
    //And as there are n numbers in array, the inner loop will run for n times
    private static int solveOptimized(int[] A) {
        long ans = 0;
        int n = A.length;
        int totalNoOfSubArrays = (n * (n + 1)) / 2;

        for (int i = 0; i < 32; i++) {//Loop for bits
            int unsetBitCount = 0;
            int totalNoOfSubArraysWithUnsetBits = 0;
            for (int j = 0; j < n; j++) {// Loop for numbers
                int num = A[j];
                //Check the unset bits for position i
                if ((num & (1 << i)) == 0) {
                    unsetBitCount++;
                }

                if (((num & (1 << i)) != 0 && unsetBitCount != 0) || j == n - 1) {
                    totalNoOfSubArraysWithUnsetBits += ((unsetBitCount * (unsetBitCount + 1)) / 2);
                    unsetBitCount = 0;
                }
            }
            ans += ((totalNoOfSubArrays - totalNoOfSubArraysWithUnsetBits) * Math.pow(2, i));
        }

        return (int) (ans % 1000000007);
    }

    private static int solve(int[] A) {
        long n = A.length;
        long tot_subArray = (n * (n + 1)) / 2;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long subArray = 0;
            long bitzero = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) == 0) {
                    bitzero += 1;
                }
                if ((A[j] & (1 << i)) > 0 || j == n - 1) {
                    subArray += (bitzero * (bitzero + 1)) / 2;
                    bitzero = 0;
                }
            }
            ans += (tot_subArray - subArray) * (long) Math.pow(2, i);
            ans = ans % 1000000007;
        }
        return (int) ans;
    }
}
