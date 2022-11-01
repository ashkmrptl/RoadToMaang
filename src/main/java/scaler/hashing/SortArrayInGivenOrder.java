package scaler.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
 * For the elements not present in B, append them at last in sorted order.
 * <p>
 * Return the array A after sorting from the above method.
 * <p>
 * NOTE: Elements of B are unique.
 */
public class SortArrayInGivenOrder {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{5, 4, 2};

        System.out.println(Arrays.toString(solve(A, B)));

        A = new int[]{5, 1, 2, 4, 2, 5, 1};
        B = new int[]{5, 4, 2};

        System.out.println(Arrays.toString(solve(A, B)));
    }

    /**
     * Approach:
     * - Sort the array
     * - create a frequency map
     * - add elements from B to answer array and update the frequency(decrease) till frequency reaches 0
     * - add elements left in A in same order as they appear and update the frequency
     */
    private static int[] solve(int[] A, int[] B) {
        Arrays.sort(A);

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        int[] result = new int[A.length];

        //Put elements from array B
        int k = 0;
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                result[k] = B[i];
                k++;

                if (map.get(B[i]) == 1) {
                    map.remove(B[i]);
                } else {
                    map.put(B[i], map.get(B[i]) - 1);
                    i--;
                }
            }
        }

        //Put elements from array A
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                result[k] = A[i];
                k++;

                if (map.get(A[i]) == 1) {
                    map.remove(A[i]);
                } else {
                    map.put(A[i], map.get(A[i]) - 1);
                }
            }
        }

        return result;
    }
}
