package scaler.array;

import java.util.Arrays;

/**
 * Given an array of size N, count the number of special indices.
 * A special index is: If we delete this index element, then sum of odd indices elements = sum of even indices elements.
 * <p>
 * Example:
 * 4    3    2    7    6    -2
 * <p>
 * Here special indices are "0" and "2"
 * <p>
 * Explanation: Id we delete 0th index element, then the array is
 * 3    2    7    6    -2
 * Odd sum = 2 + 6 = 8
 * Even sum = 3 + 7 + (-2) = 8
 * <p>
 * If we remove 4th index element, the the array is
 * 4    3    7    6    -2
 * Odd sum = 3 + 6 = 9
 * Even sum = 4 + 7 + (-2) = 9
 */
public class SpecialIndices {
    public static void main(String[] args) {
        final int[] array = new int[]{4, 3, 2, 7, 6, -2};
        System.out.printf("Special indices count is %s", countSpecialIndicesUsingPrefixSums(array));
        System.out.println();
        System.out.printf("Special indices count is with O(1) space %s", countSpecialIndicesUsingConstantSpace(array));
        System.out.println();

        final int[] array1 = new int[]{2, 3, 1, 4, 0, -1, 2, -2, 10, 8};
        System.out.printf("Special indices count is %s", countSpecialIndicesUsingPrefixSums(array1));
        System.out.println();
        System.out.printf("Special indices count is with O(1) space %s", countSpecialIndicesUsingConstantSpace(array1));
    }

    private static int countSpecialIndicesUsingConstantSpace(final int[] array) {
        int count = 0;
        int totalEvenSum = 0;
        int totalOddSum = 0;

        for (int i = 0; i < array.length; i++) {
            if ((i & 1) == 0) {//even
                totalEvenSum += array[i];
            } else {//odd
                totalOddSum += array[i];
            }
        }

        int leftEven = 0;
        int leftOdd = 0;

        int rightEven = totalEvenSum;
        int rightOdd = totalOddSum;

        for (int i = 0; i < array.length; i++) {

            if ((i & 1) == 0) {//even
                rightEven -= array[i];
            } else {//odd
                rightOdd -= array[i];
            }

            int evenSum = leftEven + rightOdd;
            int oddSum = leftOdd + rightEven;

            if (evenSum == oddSum) {
                count++;
            }

            if ((i & 1) == 0) {
                leftEven += array[i];
            } else {
                leftOdd += array[i];
            }
        }

        return count;
    }

    private static int countSpecialIndicesUsingPrefixSums(final int[] array) {
        int count = 0;

        final int[] oddPF = new int[array.length];
        final int[] evenPF = new int[array.length];

        oddPF[0] = 0;
        evenPF[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if ((i & 1) == 0) {// Even Index
                evenPF[i] = evenPF[i - 1] + array[i];
                oddPF[i] = oddPF[i - 1];
            } else {
                evenPF[i] = evenPF[i - 1];
                oddPF[i] = oddPF[i - 1] + array[i];
            }
        }

        //Edge cases - index 0
        if ((oddPF[array.length - 1] - oddPF[0]) == (evenPF[array.length - 1] - evenPF[0])) {
            count++;
        }

        for (int i = 1; i < array.length; i++) {
            final int totalOdd = oddPF[i - 1] + (evenPF[array.length - 1] - evenPF[i]);
            final int totalEven = evenPF[i - 1] + (oddPF[array.length - 1] - oddPF[i]);

            if (totalOdd == totalEven) {
                count++;
            }
        }

        return count;
    }
}
