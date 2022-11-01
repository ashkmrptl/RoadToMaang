package scaler.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
 * Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two
 * indices is defined as |i-j|. If there is no special pair in the array, then return -1.
 */
public class ShaggyAndDistances {
    public static void main(String[] args) {
        int[] A = new int[]{7, 1, 3, 4, 1, 7};
        System.out.println(solve(A));

        A = new int[]{1, 1};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int minDistance = A.length + 1;

        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                minDistance = Math.min(minDistance, i - map.get(A[i]));
            }
            map.put(A[i], i);
        }

        return minDistance;
    }
}
