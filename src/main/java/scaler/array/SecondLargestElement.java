package scaler.array;

import java.util.ArrayList;
import java.util.List;

public class SecondLargestElement {
    public static void main(String[] args) {
        final int[] arr = new int[]{1, 1};
        System.out.println(arr.length);

        final int[] arr2 = new int[2];
        System.out.println(arr2.length);


        System.out.println(findSecondLargestElement(arr));
        System.out.println(findThirdLargestElement(arr));
    }

    private static int findSecondLargestElement(final int[] array) {
        if(array.length < 2) {
            return -1;
        }
        int i, first, second;
        first = second = Integer.MIN_VALUE;

        for (i = 0; i < array.length; i++) {
            if (array[i] > first) {
                first = array[i];
            } else if (array[i] > second) {
                second = array[i];
            }
        }

        return second;
    }

    private static int findThirdLargestElement(final int[] array) {
        if(array.length < 3) {
            return -1;
        }
        int i, first, second, third;
        first = second = third = Integer.MIN_VALUE;

        for (i = 0; i < array.length; i++) {
            if (array[i] > first) {
                first = array[i];
            } else if (array[i] > second) {
                second = array[i];
            } else if (array[i] > third) {
                third = array[i];
            }
        }

        return third;
    }
}
