package scaler.arraysAndMaths;

/**
 * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * You may assume that the array is non-empty and the majority element always exists in the array.
 * <p>
 * Problem Constraints
 * ,1 <= N <= 5*105
 * ,1 <= num[i] <=,109
 * <p>
 * Input Format
 * Only argument is an integer array.
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * Example Input
 * [2,,1, 2]
 * <p>
 * Example Output
 * 2
 * <p>
 * Example Explanation
 * 2 occurs 2 times which is greater than 3/2.
 */
public class MajorityElements {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 3, 2, 2, 2};
        System.out.println(solve(A));
        System.out.println(solveBetter(A));

        A = new int[]{1000697, 1000110, 1000110, 1000671, 1000941, 1000304, 1000110, 1000742, 1000160, 1000558, 1000110, 1000110, 1000110, 1000650, 1000200, 1000110, 1000133, 1000110, 1000548, 1000002, 1000397, 1000110, 1000533, 1000724, 1000110, 1000882, 1000110, 1000515, 1000110, 1000110, 1000110, 1000181, 1000051, 1000110, 1000110, 1000644, 1000110, 1000301, 1000110, 1000040, 1000424, 1000336, 1000426, 1000244, 1000485, 1000439, 1000554, 1000110, 1000110, 1000497, 1000836, 1000760, 1000110, 1000135, 1000872, 1000110, 1000739, 1000242, 1000790, 1000110, 1000384, 1000110, 1000384, 1000110, 1000713, 1000110, 1000110, 1000048, 1000110, 1000172, 1000727, 1000502, 1000649, 1000830, 1000387, 1000953, 1000110, 1000640, 1000291, 1000612, 1000389, 1000110, 1000698, 1000462, 1000054, 1000110, 1000110, 1000181, 1000221, 1000408, 1000110, 1000905, 1000110, 1000532, 1000939, 1000110, 1000817, 1000388, 1000069, 1000110, 1000163, 1000453, 1000847, 1000908, 1000395, 1000574, 1000127, 1000132, 1000110, 1000110, 1000201, 1000689};
        System.out.println(solve(A));
        System.out.println(solveBetter(A));
    }

    private static int solveBetter(final int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int n = A.length;
        int majority = A[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (A[i] == majority) {
                count++;
            } else if (count == 1) {
                majority = A[i];
            } else {
                count--;
            }
            System.out.println(" : " + count);
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == majority) {
                count++;
            }
        }

        if (count > n / 2) {
            return majority;
        }
        return -1;
    }

    private static int solve(final int[] A) {
        Integer throne = null;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (throne == null) {
                throne = A[i];
                count++;
            } else if (throne == A[i]) {
                count++;
            } else if (throne != A[i]) {
                if (count > 1) {
                    count--;
                } else {
                    throne = null;
                    count = 0;
                }
            }
        }

        return throne == null ? 0 : throne;
    }
}
