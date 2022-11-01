package interviewbit.array;

/**
 * Given an integer array A of size N.
 * <p>
 * You have to pick exactly B elements from either left or right end of the array A to get maximum sum.
 * <p>
 * Find and return this maximum possible sum.
 * <p>
 * NOTE: Suppose B = 4 and array A contains 10 elements then
 * <p>
 * You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc.
 * You need to return the maximum possible sum of elements you can pick.
 */
public class PickFromBothSides {
    public static void main(String[] args) {
        int[] A = new int[]{5, -2, 3, 1, 2};
        int B = 3;

        System.out.println("Max sum : " + solve(A, B));
    }

    private static int solve(final int[] A, final int B) {
        int n = A.length;

        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        int maxSum = sum;
        int currentSum = sum;
        for (int i = 0; i < B; i++) {
            currentSum = currentSum - A[B - i - 1] + A[n - i - 1];
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
