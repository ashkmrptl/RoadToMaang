package scaler.twoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Given an one-dimensional integer array A of size N and an integer B.
 * Count all distinct pairs with difference equal to B.
 * Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
 */
public class PairsWithGivenDifference {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 3, 4, 2};
        int B = 3;
        System.out.println(solve(A, B));
        System.out.println(solveOptimized(A, B));

        A = new int[]{8, 12, 16, 4, 0, 20};
        B = 4;
        System.out.println(solve(A, B));
        System.out.println(solveOptimized(A, B));

        A = new int[]{1, 1, 1, 2, 2};
        B = 0;
        System.out.println(solve(A, B));
        System.out.println(solveOptimized(A, B));
    }

    private static int solveOptimized(int[] A, int B) {
        Arrays.sort(A);//TC: O(N logN)

        int count = 0;

        int i = 0;
        int j = 1;

        while (j < A.length) {
            int x = A[i];
            int y = A[j];

            int diff = y - x;

            if (diff == B) {
                count++;

                while (i < A.length && A[i] == x) {
                    i++;
                }
                while (j < A.length && A[j] == y) {
                    j++;
                }
            } else if (diff < B) {
                j++;
            } else {
                i++;
                if (i == j) {
                    j++;
                }
            }
        }

        return count;
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    private static int solve(int[] A, int B) {
        Arrays.sort(A);//TC: O(N logN)

        Set<Pair> pairs = new HashSet<>();//SC: (N). This can be omitted by comparing the next value with current till it is same

        int count = 0;

        int i = 0;
        int j = 1;

        while (j < A.length) {
            int diff = A[j] - A[i];

            if (diff == B) {
                final Pair pair = new Pair(A[i], A[j]);
                if (!pairs.contains(pair)) {
                    count++;
                }
                pairs.add(pair);
                i++;
                j++;
            } else if (diff < B) {
                j++;
            } else {
                i++;
                if (i == j) {
                    j++;
                }
            }
        }

        return count;
    }
}
