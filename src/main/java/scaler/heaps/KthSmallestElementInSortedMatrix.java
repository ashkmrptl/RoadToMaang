package scaler.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a sorted matrix of integers A of size N x M and an integer B.
 * Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.
 * NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.
 */
public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] A = new int[][]{{9, 11, 15}, {10, 15, 17}};
        System.out.println(solve(A, 6));

        A = new int[][]{{5, 9, 11}, {9, 11, 13}, {10, 12, 15}, {13, 14, 16}, {16, 20, 21}};
        System.out.println(solve(A, 12));
    }

    private static int solve(int[][] A, int B) {
        final Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                minHeap.add(A[i][j]);
            }
        }

        int num = Integer.MAX_VALUE;
        while (B > 0) {
            num = minHeap.poll();
            B--;
        }

        return num;
    }

    public int solve_less_space(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        PriorityQueue<Integer> q = new PriorityQueue(new CustomComp());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (q.size() < B)
                    q.offer(A[i][j]);
                else {
                    if (A[i][j] < q.peek()) {
                        q.poll();
                        q.offer(A[i][j]);
                    }
                }
            }
        }
        return q.peek();
    }

    static class CustomComp implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }
}
