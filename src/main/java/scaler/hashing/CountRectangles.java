package scaler.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
 * <p>
 * Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k])
 * and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
 */
public class CountRectangles {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 2};
        int[] B = new int[]{1, 2, 1, 2};

        System.out.println(solve(A, B));

        A = new int[]{1, 1, 2, 2, 3, 3};
        B = new int[]{1, 2, 1, 2, 1, 2};

        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int[] B) {
        int count = 0;

        //Preparing co-ordinates set for access in constant time
        final Set<String> coordinates = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            coordinates.add(A[i] + "-" + B[i]);
        }

        for (int i = 0; i < A.length; i++) {//bottom left x and y coordinates
            int x1 = A[i];
            int y1 = B[i];

            for (int j = 0; j < A.length; j++) {//top right x and y coordinates
                if (i != j) {
                    int x2 = A[j];
                    int y2 = B[j];

                    if (x1 < x2 && y1 < y2) {
                        final String topLeft = x1 + "-" + y2;
                        final String bottomRight = x2 + "-" + y1;

                        if (coordinates.contains(topLeft) && coordinates.contains(bottomRight)) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
