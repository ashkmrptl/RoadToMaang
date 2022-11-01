package scaler.sorting;

import java.util.Arrays;

/**
 * We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
 * Here, the distance between two points on a plane is the Euclidean distance.
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
 * <p>
 * A = [
 * [1, 3],
 * [-2, 2]
 * ]
 * B = 1
 * <p>
 * ans : [[-2, 2]]
 */
public class BClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 3}, {-2, 2}};
        System.out.println(Arrays.deepToString(solve(A, 2)));
    }

    // Approach is to use the merge sort
    private static int[][] solve(int[][] A, int B) {
        mergeSort(A, 0, A.length - 1);
        int[][] res = new int[B][2];
        for (int i = 0; i < B; i++) {
            res[i] = A[i];
        }
        return res;
    }

    private static void mergeSort(int[][] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);

        merge(A, start, mid + 1, end);
    }

    private static void merge(int[][] A, int start, int mid, int end) {
        int n = end - start + 1;
        int[][] temp = new int[n][2];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j <= end) {
            double distance1 = calculateEuclideanDistance(A[i][0], A[i][1]);
            double distance2 = calculateEuclideanDistance(A[j][0], A[j][1]);

            if (distance1 < distance2) {
                temp[k] = A[i];
                i++;
            } else {
                temp[k] = A[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            temp[k] = A[i];
            i++;
            k++;
        }

        while (j <= end) {
            temp[k] = A[j];
            j++;
            k++;
        }

        for (int a = 0; a < temp.length; a++) {
            A[a + start] = temp[a];
        }
    }

    private static double calculateEuclideanDistance(int x, int y) {
        return Math.sqrt((x * x) + (y * y));
    }
}
