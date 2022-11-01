package scaler.array;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] A = new int[]{3, 6, -9, -1, 4, 6, -9};
        solve(A);

        A = new int[]{3, 6, -1, -9, 4, 6, 1};
        solve(A);

        A = new int[]{-6, -5, -4, -3, -2, -1};
        solve(A);
    }

    private static void solve(int[] A) {
        int curr = 0;
        int start = 0;

        int maxStart = -1;
        int maxEnd = -1;
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            curr += A[i];
            if (curr > sum) {
                sum = curr;
                maxStart = start;
                maxEnd = i;
            }
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }

        System.out.printf("Max sum is between %s and %s and sum is : %s%n", maxStart, maxEnd, sum);
    }
}
