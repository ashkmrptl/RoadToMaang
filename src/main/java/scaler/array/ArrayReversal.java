package scaler.array;


import java.util.Arrays;

public class ArrayReversal {
    public static void main(String[] args) {
        final int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        System.out.println("Array Before Reversal : " + Arrays.toString(arr));

        reverseArray(arr);

        System.out.println("Array After Reversal : " + Arrays.toString(arr));
    }

    public static void reverseArray(final int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[(n - 1) - i];
            arr[(n - 1) - i] = temp;
        }
    }
}
