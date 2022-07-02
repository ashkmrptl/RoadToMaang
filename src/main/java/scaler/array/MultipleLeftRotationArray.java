package scaler.array;

import java.util.Arrays;

public class MultipleLeftRotationArray {
    public static void main(String[] args) {
        final int[] A = new int[]{1, 2, 3, 4, 5};
        final int[] B = new int[]{2, 2, 3};

        final int[][] result = rotate(A, B);

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] rotate(int[] a, int[] b) {
        //System.out.println(a.length + " " + b.length);
        final int[][] result = new int[b.length][a.length];

        for (int i = 0; i < b.length; i++) {
            result[i] = rotateLeft(a, b[i]);
        }

        return result;
    }

    private static int[] rotateLeft(final int[] array, final int k) {
        final int[] res = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            final int index = i - k < 0 ? array.length + (i - k) : i - k;
            //System.out.println("k : " + k + " index : " + index);
            res[index] = array[i];
        }

        //System.out.println(Arrays.toString(res));
        return res;
    }
}
