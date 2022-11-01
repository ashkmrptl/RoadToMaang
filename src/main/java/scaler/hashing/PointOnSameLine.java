package scaler.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
 * <p>
 * Find and return the maximum number of points that lie on the same line.
 */
public class PointOnSameLine {
    public static void main(String[] args) {
        int[] A = new int[]{-1, 0, 1, 2, 3, 3};
        int[] B = new int[]{1, 0, 1, 2, 3, 4};

        System.out.println(solve(A, B));

        A = new int[]{3, 1, 4, 5, 7, -9, -8, 6};
        B = new int[]{4, -8, -3, -2, -1, 5, 7, -4};

        System.out.println(solve(A, B));

        A = new int[]{2, 1, -7, 4, 1, -2, -7, 5};
        B = new int[]{-6, -7, 3, -10, 7, -10, 1, 2};

        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int[] B) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int equal = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j] && B[j] == B[i]) equal++;
                else {
                    int y = B[i] - B[j];
                    int x = A[i] - A[j];
                    int gcd = gcd(y, x);
                    String str = (x / gcd) + "_" + (y / gcd);
                    map.put(str, (map.containsKey(str) ? map.get(str) : 0) + 1);
                }
            }
            res = Math.max(res, equal);
            //System.out.println(map.toString());
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + equal);
            }
            map.clear();
        }
        return res;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
