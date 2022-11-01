package scaler.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers A, find and return whether the given array contains a non-empty sub-array with a sum equal to 0.
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 */
public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));

        A = new int[]{1, -1};
        System.out.println(solve(A));
    }

    /**
     * Approach is to use prefix sum with farthest equal element in the prefix sum array.
     * We don't need to create the prefix sum, on the fly we can do this.
     * Also we have to make sure the sub-array starting with first element of the array, i.e. the element in PF sum array as 0
     */
    private static int solve(int[] A) {
        final Set<Long> set = new HashSet<>();
        set.add((long) A[0]);

        long sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum += A[i];

            if (sum == 0 || set.contains(sum)) {
                return 1;
            }

            set.add(sum);
        }

        return 0;
    }
}
