package scaler.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N
 * represents a unique point (x, y) in 2D Cartesian plane.
 * <p>
 * Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k])
 * form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
 * NOTE: The answer may be large so return the answer modulo (109 + 7).
 */
public class CountRightTriangles {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2};
        int[] B = new int[]{1, 2, 1};

        System.out.println(solve(A, B));

        A = new int[]{1, 1, 2, 3, 3};
        B = new int[]{1, 2, 1, 2, 1};

        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int[] B) {
        int count = 0;

        Map<Integer, Integer> xCountMap = new HashMap<>();
        Map<Integer, Integer> yCountMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (xCountMap.containsKey(A[i])) {
                xCountMap.put(A[i], xCountMap.get(A[i]) + 1);
            } else {
                xCountMap.put(A[i], 1);
            }

            if (yCountMap.containsKey(B[i])) {
                yCountMap.put(B[i], yCountMap.get(B[i]) + 1);
            } else {
                yCountMap.put(B[i], 1);
            }
        }

        for (int i = 0; i < A.length; i++) {//Fixing one point
            int x = A[i];
            int y = B[i];

            int count1 = xCountMap.get(x) - 1;
            int count2 = yCountMap.get(y) - 1;

            count += (count1 * count2);
        }

        return count;
    }
}
