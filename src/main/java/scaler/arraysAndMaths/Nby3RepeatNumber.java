package scaler.arraysAndMaths;

/**
 * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
 * If so, return the integer. If not, return -1.
 * <p>
 * If there are multiple solutions, return any one.
 * <p>
 * Problem Constraints
 * 1 <= N <= 7*105
 * 1 <= A[i] <= 109
 * <p>
 * Input Format
 * The only argument is an integer array A.
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * Example Input
 * [1 2 3 1 1]
 * <p>
 * Example Output
 * 1
 * <p>
 * Example Explanation
 * 1 occurs 3 times which is more than 5/3 times.
 */
public class Nby3RepeatNumber {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }

    private static int solve(final int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return A[0];
        }

        int majority1 = Integer.MAX_VALUE;
        int majority2 = Integer.MIN_VALUE;

        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (majority1 == A[i]) {
                count1++;
            } else if (majority2 == A[i]) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                majority1 = A[i];
            } else if (count2 == 0) {
                count2++;
                majority2 = A[i];
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == majority1) {
                count1++;
            } else if (A[i] == majority2) {
                count2++;
            }
        }

        if (count1 > A.length / 3) {
            return majority1;
        }

        if (count2 > A.length / 3) {
            return majority2;
        }

        return -1;

    }
}
