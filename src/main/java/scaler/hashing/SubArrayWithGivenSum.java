package scaler.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 * If the answer does not exist return an array with a single element "-1".
 * First sub-array means the sub-array for which starting index in minimum.
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * <p>
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 5
 * Input 2:
 * A = [5, 10, 20, 100, 105]
 * B = 110
 * <p>
 * Example Output
 * Output 1:
 * [2, 3]
 * Output 2:
 * -1
 * <p>
 * Example Explanation
 * Explanation 1:
 * [2, 3] sums up to 5.
 * Explanation 2:
 * No subarray sums up to required number.
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(final int[] A, final int B) {
        final int n = A.length;

        long sum = 0;
        int start = -1;
        int end = -1;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum == B) {
                start = 0;
                end = i;
                break;
            }
            long diff = sum - B;
            if (map.containsKey(diff)) {
                start = map.get(diff) + 1;
                end = i;
                break;
            } else {
                map.put(sum, i);
            }
        }

        if (start == -1) {
            return new int[]{-1};
        }

        int[] res = new int[end - start + 1];
        for (int i = start, j = 0; i <= end; i++, j++) {
            res[j] = A[i];
        }

        return res;
    }
}
