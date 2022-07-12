package scaler.array;

/**
 * Count the no of triplets in a given array A of size n, such that i < j < k and A[i] < A[j] < A[k]
 * <p>
 * Bruteforce approach is to consider all triplets and then count the one matching the given condition.
 * This take O(N^3) TC
 * <p>
 * Next best approach is to consider all elements starting from index 1 to n - 2 as middle element.
 * Then count the no of smaller elements to the left and no of larger elements to the right.
 * Then the answer will be (noOfSmallerElementsToLeft * noOfLargerElementsToRight), because we can construct those many no of triplets.
 * <p>
 * This take O(n^2) TC.
 * <p>
 * This can also be solved in TC O(NlogN) -> which will be discussed later
 */
public class CountTriplets {
    public static void main(String[] args) {
        int[] A = new int[]{3, 4, 6, 9, 2};
        System.out.println(solve(A));

        A = new int[]{2, 6, 9, 4, 10};
        System.out.println(solve(A));
    }

    private static int solve(final int[] A) {
        int result = 0;
        final int n = A.length;

        for (int i = 1; i < n - 1; i++) {
            int leftCount = countLeftSmall(i - 1, A[i], A);
            int rightCount = countRightBig(i + 1, A[i], A);

            result += (leftCount * rightCount);
        }

        return result;
    }


    private static int countLeftSmall(int end, int mid, int[] A) {
        int count = 0;

        for (int i = end; i >= 0; i--) {
            if (A[i] < mid) {
                count++;
            }
        }

        return count;
    }

    private static int countRightBig(int start, int mid, int[] A) {
        int count = 0;

        for (int i = start; i < A.length; i++) {
            if (A[i] > mid) {
                count++;
            }
        }

        return count;
    }
}
