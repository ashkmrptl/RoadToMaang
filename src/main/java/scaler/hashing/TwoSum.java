package scaler.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * <p>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
 * Put both these numbers in order in an array and return the array from your function
 * ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 * <p>
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2,
 * choose the one with minimum index1 out of them.
 * <p>
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] A = new int[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        int B = -3;

        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(final int[] A, final int B) {
        final Map<Integer, Integer> map = new HashMap<>();

        int index1 = A.length;
        int index2 = A.length;

        for (int i = 0; i < A.length; i++) {
            int diff = B - A[i];

            if (map.containsKey(diff)) {
                if ((i < index2) || (i == index2 && map.get(diff) < index1)) {
                    index1 = map.get(diff);
                    index2 = i;
                }
            } else {
                if (!map.containsKey(A[i])) {
                    map.put(A[i], i);
                }
            }
        }

        if (index1 == -1) {
            return new int[]{};
        }

        return new int[]{index1 + 1, index2 + 1};
    }
}
