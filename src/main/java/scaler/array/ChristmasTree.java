package scaler.array;

/**
 * Problem Description
 * You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of
 * the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose
 * 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
 * The cost of these trees is Bp + Bq + Br.
 * <p>
 * You are to choose 3 trees such that their total cost is minimum. Return that cost.
 * <p>
 * If it is not possible to choose 3 such trees return -1.
 * <p>
 * Problem Constraints
 * 1 <= A[i], B[i] <= 109
 * 3 <= size(A) = size(B) <= 3000
 * <p>
 * Input Format
 * First argument is an integer array A.
 * Second argument is an integer array B.
 * <p>
 * Output Format
 * Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order, if not possible, -1.
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 3, 5]
 * B = [1, 2, 3]
 * Input 2:
 * <p>
 * A = [1, 6, 4, 2, 6, 9]
 * B = [2, 5, 7, 3, 2, 7]
 * <p>
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * 7
 * Example Explanation
 * Explanation 1:
 * <p>
 * We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6.
 * <p>
 * Bruteforce approach os to consider all triplets and then find the once satisfying the given conditions.
 * After that we take the minimum sum of all those triplets.
 * TC for brute force approach will be O(n^3)
 * <p>
 * This can be done by O(n^2) using prefix sum array or carry forward technique.
 * For prefix sum array the SC is O(n) and for carry forward approach the SC is O(1)
 */
public class ChristmasTree {
    public static void main(String[] args) {
        int[] A = new int[]{1, 6, 4, 2, 6, 9};
        int[] B = new int[]{2, 5, 7, 3, 2, 7};

        //System.out.println(solve(A, B));

        A = new int[]{1, 3, 5};
        B = new int[]{1, 2, 3};

        //System.out.println(solve(A, B));

        A = new int[]{5, 9, 10, 4, 7, 8};
        B = new int[]{5, 6, 4, 7, 2, 5};

        System.out.println(solve(A, B));
    }

    private static int solve(final int[] A, final int[] B) {
        final int n = A.length;
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            //Finding left minimum
            int leftMinimum = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    leftMinimum = Math.min(leftMinimum, B[j]);
                }
            }

            //Finding right minimum
            int rightMinimum = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    rightMinimum = Math.min(rightMinimum, B[j]);
                }
            }

            if (leftMinimum != Integer.MAX_VALUE && rightMinimum != Integer.MAX_VALUE) {
                result = Math.min(result, (leftMinimum + B[i] + rightMinimum));
            }
        }

        return result;
    }
}
