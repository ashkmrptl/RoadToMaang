package scaler.array;

import java.util.Arrays;

/**
 * Given an array of size N, rotate the array K times clockwise, given K < N;
 */
public class ArrayRotation {
    public static void main(String[] args) {
        final int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Array before rotation : " + Arrays.toString(arr));
        rotateWithoutUsingExtraSpace(arr, 3);
        System.out.println("Array after rotating 3 times : " + Arrays.toString(arr));

        final int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Array before rotation : " + Arrays.toString(arr1));
        rotateWithoutUsingExtraSpace(arr1, 4);
        System.out.println("Array after rotating 4 times : " + Arrays.toString(arr1));

        final int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Array before rotation : " + Arrays.toString(arr2));
        System.out.println("Array after rotating 3 times : " + Arrays.toString(rotateWithExtraSpace(arr2, 3)));

        final int[] arr3 = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Array before rotation : " + Arrays.toString(arr3));
        System.out.println("Array after rotating 5 times : " + Arrays.toString(rotateWithExtraSpace(arr2, 5)));
    }

    /**
     * Approach without using extra space.
     * <p>
     * There are 3 steps to it.
     * 1) Reverse the  whole array i.e. o to n - 1
     * 2) Reverse the 1st half i.e. 0 to k - 1
     * 3) Reverse the 2nd half i.e. k to n - 1
     * <p>
     * After 3rd step we should have the array with k no of clockwise rotations
     * <p>
     * **NOTE: If K > N, the we will have to get the modulo of n % K to get how many actual rotations we need to do.
     *
     * Here Time Complexity is O (n) and Space Complexity O(1)
     *
     * @param array input array
     * @param k     no of times to rotate clockwise
     */
    private static void rotateWithoutUsingExtraSpace(final int[] array, final int k) {
        reverse(array, 0, array.length - 1);
        //System.out.println("Array after 1st reverse : " + Arrays.toString(array));
        reverse(array, 0, k - 1);
        //System.out.println("Array after 2nd reverse : " + Arrays.toString(array));
        reverse(array, k, array.length - 1);
        //System.out.println("Array after 3rd reverse : " + Arrays.toString(array));
    }

    private static void reverse(final int[] array, final int start, final int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Approach :
     * In this approach we shift the elements in array in required direction by k
     * If the location to shift is greater than one, than we (i+k) % n to get the original position to swap with.
     *
     * Here Time Complexity is O(n) and Space Complexity is O(n)
     *
     * @param array input array
     * @param k     no of times to rotate
     */
    private static int[] rotateWithExtraSpace(final int[] array, final int k) {
        final int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if((i + k) >= array.length) {
                result[(i + k) % array.length] = array[i];
            } else {
                result[i + k] = array[i];
            }
        }

        return result;
    }
}
