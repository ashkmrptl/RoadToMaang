package scaler.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] A = new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        System.out.println(Arrays.toString(sort(A)));
    }

    private static int[] sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            int minIndex = i;

            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    minIndex = j;
                }
            }

            //Swap
            A[minIndex] = A[i];
            A[i] = min;
        }
        return A;
    }
}
