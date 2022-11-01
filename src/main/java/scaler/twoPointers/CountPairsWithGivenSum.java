package scaler.twoPointers;

/**
 * Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 */
public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(solve(A, B));

        A = new int[]{5, 10, 20, 100, 105};
        B = 110;
        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int B) {
        int count = 0;

        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            long sum = (long) A[i] + (long) A[j];
            if (sum == B) {
                count++;
                i++;
                j--;
            } else if (sum < B) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
