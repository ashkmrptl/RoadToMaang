package scaler.searching;

/**
 * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.
 * <p>
 * NOTE:
 * <p>
 * A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
 */
public class SearchInBitonicArray {
    public static void main(String[] args) {
        int[] A = new int[]{5, 6, 7, 8, 9, 10, 3, 2, 1};
        int B = 30;
        System.out.println(solve(A, B));

        A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        B = 12;
        System.out.println(solve(A, B));

        A = new int[]{1, 20, 50, 40, 10};
        B = 5;
        System.out.println(solve(A, B));
    }

    //Approach: The approach is to use 3 binary searches.
    // 1st to find the pivot, 2nd to search in left and 3rd to search in right;
    private static int solve(int[] A, int B) {
        //Find max element;
        int low = 0;
        int high = A.length - 1;

        int max = getMaxIndex(A, low, high);

        if (B == A[max]) {
            return max;
        }

        int ans = -1;
        //Search in left
        low = 0;
        high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == B) {
                ans = mid;
                break;
            } else if (B < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Search in right if not found on left
        if (ans == -1) {
            low = max + 1;
            high = A.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (A[mid] == B) {
                    ans = mid;
                    break;
                } else if (A[mid] < B) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return ans;
    }

    private static int getMaxIndex(int[] A, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
