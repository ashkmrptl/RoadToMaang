package scaler.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 8, 6, -1, 0, 9, 12, 5, 1, 1, 12};
        quickSort(A, 0, A.length - 1);

        System.out.println(Arrays.toString(A));
    }

    private static void quickSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = rearrange(A, l, r);

        quickSort(A, l, pivot - 1);
        quickSort(A, pivot + 1, r);
    }

    private static int rearrange(int[] a, int l, int r) {
        int p1 = l + 1;
        int p2 = r;

        while (p1 <= p2) {
            if (a[p1] <= a[l]) {
                p1++;
            } else if (a[p2] >= a[l]) {
                p2--;
            } else {
                swap(a, p1, p2);
                p1++;
                p2--;
            }
        }

        swap(a, l, p2);

        return p2;
    }

    private static void swap(int[] A, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
