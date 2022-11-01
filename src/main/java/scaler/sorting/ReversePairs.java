package scaler.sorting;

/**
 * Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
 * Return the number of important reverse pairs in the given array A.
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 2, 3, 1};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private static int mergeSort(int[] A, int left, int right) {
        if (left == right) {
            return 0;
        }

        // Divide the array into two parts
        int mid = (left + right) / 2;
        int a = mergeSort(A, left, mid);
        int b = mergeSort(A, mid + 1, right);

        // Merge the two parts
        int aWithB = merge(A, left, mid, right);
        return a + b + aWithB;
    }

    private static int merge(int[] A, int left, int mid, int right) {
        int count = 0;
        int i = left;       // i is index for left sub-array
        int j = mid + 1;    // j is index for right sub-array
        int k = 0;          // k is index for resultant merged sub-array
        int[] temp = new int[right - left + 1];

        // Counting number of valid pairs
        while (i <= mid && j <= right) {
            if ((long) A[i] > (long) 2 * A[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        // Using Merge Sort to sort and update resultant array
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[k] = A[i];
                i++;
            } else {
                temp[k] = A[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = A[i];
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = A[j];
            j++;
            k++;
        }
        /*Copy back the merged elements to original array*/
        k = 0;
        for (int z = left; z <= right; z++, k++) {
            A[z] = temp[k];
        }
        return count;
    }
}
