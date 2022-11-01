package scaler.sorting;

import java.util.Arrays;

public class UniqueElements {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 3};
        //System.out.println(solve_usingSelectionSort(A));
        System.out.println(solve(A));

        A = new int[]{2, 4, 5};
        //System.out.println(solve_usingSelectionSort(A));
        System.out.println(solve(A));

        A = new int[]{2, 2, 2};
        //System.out.println(solve_usingSelectionSort(A));
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        Arrays.sort(A);
        int steps = 0;
        int min = A[0];

        for (int i = 1; i < A.length; i++) {
            min = Math.max(min + 1, A[i]);
            steps += min - A[i];
        }

        return steps;
    }

    static int res = 0;

    //Not working
    private static int solve_usingMergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return res;
    }

    private static void mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);

        res += merge(A, start, mid + 1, end);
    }

    private static int merge(int[] A, int start, int mid, int end) {
        int count = 0;
        int n = end - start + 1;
        int[] temp = new int[n];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j <= end) {
            if (A[i] == A[j]) {
                A[i] = A[i] + 1;
                count++;
                continue;
            }
            if (A[i] < A[j]) {
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

        //Copy to original array
        for (int a = 0; a < temp.length; a++) {
            A[a + start] = temp[a];
        }
        return count;
    }

    private static int solve_usingSelectionSort(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            int minIndex = i;

            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    minIndex = j;
                } else if (i != j && A[j] == min) {
                    A[j] = A[j] + 1;
                    j--;
                    count++;
                }
            }
            //Swap
            int temp = A[i];
            A[i] = min;
            A[minIndex] = temp;
        }
        return count;
    }
}
