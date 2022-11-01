package scaler.sorting;

/**
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
 */
public class InversionCount {
    public static void main(String[] args) {
        int[] A = new int[]{45, 10, 15, 25, 50};
        System.out.println(inversionCount(A, 0, A.length - 1));
    }

    private static int inversionCount(int[] A, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;

        int x = inversionCount(A, start, mid);
        int y = inversionCount(A, mid + 1, end);

        int z = merge(A, start, mid + 1, end);

        return x + y + z;
    }

    private static int merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid;
        int k = 0;
        int count = 0;

        while (i < mid && j <= end) {
            if (A[i] <= A[j]) {
                temp[k] = A[i];
                i++;
                k++;
            } else {
                temp[k] = A[j];
                j++;
                k++;
                count = count + mid - i;
            }
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

        return count;
    }
}
