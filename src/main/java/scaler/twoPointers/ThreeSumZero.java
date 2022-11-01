package scaler.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
 */
public class ThreeSumZero {
    public static void main(String[] args) {
        int[] A = new int[]{-1, 0, 1, 2, -1, 4};
        System.out.println(Arrays.deepToString(solve(A)));
    }

    private static int[][] solve(int[] A) {//TC: O(n^2)
        Arrays.sort(A);

        final List<List<Integer>> list = new ArrayList<>();

        int i = 0;
        while (i < A.length) {
            int num = A[i];
            int k = 0 - num;

            int a = i + 1;
            int b = A.length - 1;

            while (a < b) {
                int x = A[a];
                int y = A[b];

                int sum = x + y;
                if (sum == k) {
                    final List<Integer> triplet = new ArrayList<>();
                    triplet.add(A[i]);
                    triplet.add(A[a]);
                    triplet.add(A[b]);

                    list.add(triplet);

                    while (a < A.length && A[a] == x)
                        a++;

                    while (b > i && A[b] == y)
                        b--;
                } else if (sum < k) {
                    a++;
                } else {
                    b--;
                }
            }

            while (i < A.length && A[i] == num)
                i++;
        }

        int[][] res = new int[list.size()][3];

        int a = 0;
        for (List<Integer> l : list) {
            res[a] = new int[]{l.get(0), l.get(1), l.get(2)};
            a++;
        }
        return res;
    }
}
