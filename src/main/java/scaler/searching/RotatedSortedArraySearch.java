package scaler.searching;

/**
 * Given a sorted array of integers A of size N and an integer B.
 * array A is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
 * You may assume no duplicate exists in the array.
 * NOTE: Users are expected to solve this in O(log(N)) time.
 */
public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        int B = 4;
        System.out.println(search(A, B));

        A = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        B = 3;
        System.out.println(search(A, B));

        A = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        B = 2;
        System.out.println(search(A, B));

        A = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        B = 5;
        System.out.println(search(A, B));

        A = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        B = 0;
        System.out.println(search(A, B));
    }

    private static int search(int[] A, int B) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[left] <= A[mid]) {
                if(B < A[mid] && B >= A[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (A[left] > A[mid]) {
                if (B > A[mid] && B <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
