package scaler.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an array A of N integers.
 * Find the largest continuous sequence in a array which sums to zero.
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * -107 <= A[i] <= 107
 * <p>
 * Input Format
 * Single argument which is an integer array A.
 * <p>
 * Output Format
 * Return an array denoting the longest continuous sequence with total sum of zero.
 * NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 * <p>
 * Example Input
 * A = [1,2,-2,4,-4]
 * <p>
 * Example Output
 * [2,-2,4,-4]
 * <p>
 * Example Explanation
 * [2,-2,4,-4] is the longest sequence with total sum of zero.
 */
public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, -2, 4, -4};
        System.out.println(Arrays.toString(solve(A)));

        A = new int[]{-19, 8, 2, -8, 19, 5, -2, -23};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(final int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int length = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == 0) {
                if (i + 1 > length) {
                    start = 0;
                    end = i;
                    length = i + 1;
                }
            } else if (map.containsKey(sum)) {
                if (i - map.get(sum) > length) {
                    start = map.get(sum) + 1;
                    end = i;
                    length = i - map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }

        if (length == Integer.MIN_VALUE) {
            return new int[0];
        }

        int[] result = new int[length];

        for (int i = start, j = 0; i <= end; i++, j++) {
            result[j] = A[i];
        }

        return result;
    }
}
