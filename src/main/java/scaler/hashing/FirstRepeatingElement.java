package scaler.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array A of size N, find the first repeating element in it.
 * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
 * If there is no repeating element, return -1.
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 * <p>
 * Input Format
 * The first and only argument is an integer array A of size N.
 * <p>
 * Output Format
 * Return an integer denoting the first repeating element.
 * <p>
 * Example Input
 * Input 1:
 * A = [10, 5, 3, 4, 3, 5, 6]
 * Input 2:
 * A = [6, 10, 5, 4, 9, 120]
 * <p>
 * Example Output
 * Output 1:
 * 5
 * Output 2:
 * -1
 * <p>
 * Example Explanation
 * Explanation 1:
 * 5 is the first element that repeats
 * Explanation 2:
 * There is no repeating element, output -1
 */
public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] A = new int[]{8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3};

        System.out.println(solve(A));
    }

    private static int solve(final int[] A) {
        int index = Integer.MAX_VALUE;

        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                index = Math.min(index, map.get(A[i]));
            } else {
                map.put(A[i], i);
            }
        }

        return index == Integer.MAX_VALUE ? -1 : A[index];
    }
}
