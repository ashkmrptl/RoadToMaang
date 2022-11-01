package scaler.searching;

public class FindAPeakElement {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        }

        if (A[0] >= A[1]) {
            return A[0];
        }

        if (A[n - 1] >= A[n - 2]) {
            return A[n - 1];
        }

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
                return A[mid];
            } else if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else if (A[mid] < A[mid - 1]) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
