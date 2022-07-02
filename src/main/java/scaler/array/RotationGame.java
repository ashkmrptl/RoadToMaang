package scaler.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an integer array A of size N and an integer B, you have to print the same array after rotating it B times towards the right.
 */
public class RotationGame {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine();
        final String[] strArr = line.split(" ");

        int n = Integer.parseInt(strArr[0]);

        final int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(strArr[i + 1]);
        }

        //System.out.println("Array before : " + Arrays.toString(array));

        final int b = scanner.nextInt();

        reverse(array, 0, n - 1);
        reverse(array, 0, b - 1);
        reverse(array, b, n - 1);

        //System.out.println("Array after : " + Arrays.toString(array));
    }

    private static void reverse(final int[] array, final int start, final int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
