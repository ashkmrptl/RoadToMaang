package scaler.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        mergeSort(A, 0, A.length - 1, true);
        //System.out.println(Arrays.toString(A));

        A = new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        mergeSort(A, 0, A.length - 1, false);
        //System.out.println(Arrays.toString(A));

        //Following code sort 1st k as ascending and remain as descending
        A = new int[] {7, 43, 12, 4, 1, 3, 78, 6};
        mergeSort(A, 0, 4 - 1, true);
        System.out.println(Arrays.toString(A));
        mergeSort(A, 4, A.length - 1, false);
        System.out.println(Arrays.toString(A));
    }

    private static void mergeSort(int[] A, int start, int end, boolean isAscending) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A, start, mid, isAscending);
        mergeSort(A, mid + 1, end, isAscending);

        merge(A, start, mid + 1, end, isAscending);
    }

    private static void merge(int[] A, int start, int mid, int end, boolean isAscending) {
        int n = end - start + 1;
        int[] temp = new int[n];

        int i = start;
        int j = mid;
        int k = 0;

        if (isAscending) {
            while (i < mid && j <= end) {
                if (A[i] <= A[j]) {
                    temp[k] = A[i];
                    i++;
                } else {
                    temp[k] = A[j];
                    j++;
                }
                k++;
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
        } else {
            while (i < mid && j <= end) {
                if (A[i] >= A[j]) {
                    temp[k] = A[i];
                    i++;
                } else {
                    temp[k] = A[j];
                    j++;
                }
                k++;
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
        }


        //Copy to original array
        for (int a = 0; a < temp.length; a++) {
            A[a + start] = temp[a];
        }
    }
}
