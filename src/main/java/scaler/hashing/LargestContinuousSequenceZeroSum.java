package scaler.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of N integers.
 * <p>
 * Find the largest continuous sequence in a array which sums to zero.
 */
public class LargestContinuousSequenceZeroSum {//CONTINUOUS SEQUENCE IS NOTHING BUT SUB-ARRAY

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, -2, 4, -4};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(int[] A) {
        int end = -1;
        int start = -1;

        int max = 0;

        final Map<Integer, Integer> map = new HashMap<>();
        map.put(A[0], 0);

        int sum = A[0];
        if (sum == 0) {
            max = 1;
            end = 0;
            start = 0;
        }

        for (int i = 1; i < A.length; i++) {
            sum += A[i];

            if (sum == 0) {
                int dist = i + 1;
                if (dist > max) {
                    max = dist;
                    end = i;
                    start = 0;
                }
            }

            if (map.containsKey(sum)) {
                int dist = i - map.get(sum);
                if (dist > max) {
                    max = dist;
                    end = i;
                    start = map.get(sum) + 1;
                }
            } else {
                map.put(sum, i);
            }
        }

        if (start == -1) {
            return new int[]{};
        }

        int n = end - start + 1;
        int[] res = new int[n];
        for (int i = start, j = 0; i <= end; i++, j++) {
            res[j] = A[i];
        }

        return res;
    }
}
