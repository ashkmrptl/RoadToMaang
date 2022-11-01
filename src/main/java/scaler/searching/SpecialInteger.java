package scaler.searching;

/**
 * Given an array A and an integer B. Find and return the maximum value of K such that there is no sub-array in A of
 * size K with the sum of sub-array elements greater than B.
 * <p>
 * Ex: A = [1, 2, 3, 4, 5]
 * B = 10;
 * <p>
 * Ans = 2
 * <p>
 * **NOTE: This will not work with the array having -ve integers
 */
public class SpecialInteger {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int B = 10;

        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int B) {
        int left = 0;
        int right = A.length;

        int ans = 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(A, mid, B)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private static boolean check(int[] A, int K, int B) {
        long sum = 0;

        for (int i = 0; i < K; i++) {
            sum += A[i];
            if (sum > B) {
                return false;
            }
        }

        int i = 1;
        int j = i + K - 1;

        while (j < A.length) {
            sum = sum - A[i - 1] + A[j];
            if (sum > B) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}
