package scaler.array;

/**
 * Given an array of size N. Find its equilibrium index.
 * Equilibrium index : An index is called equilibrium index if
 * Sum of elements of left of index = Sum of elements of right of index
 * <p>
 * Example: For array 1  2  3  4  8  10
 * Here index: 4 i.e. 8 is equilibrium index because (1 + 2 + 3 + 4 = 10) == (10)
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        final int[] array = new int[]{1, 2, 3, 4, 8, 10};
        System.out.printf("The equilibrium index using PF sum array %s", findEquilibriumIndexUsingPrefixSumArray(array));
        System.out.println();
        System.out.printf("The equilibrium index without using PF sum array %s", findEquilibriumIndexWithConstantSpace(array));
        System.out.println();

        final int[] array2 = new int[]{1, -1, 1, -2, -1, 3};
        System.out.printf("The equilibrium index using PF sum array %s", findEquilibriumIndexUsingPrefixSumArray(array2));
        System.out.println();
        System.out.printf("The equilibrium index without using PF sum array %s", findEquilibriumIndexWithConstantSpace(array2));
        System.out.println();

        final int[] array3 = new int[]{-1, 1, -2, -1, 3, 1};
        System.out.printf("The equilibrium index using PF sum array %s", findEquilibriumIndexUsingPrefixSumArray(array3));
        System.out.println();
        System.out.printf("The equilibrium index without using PF sum array %s", findEquilibriumIndexWithConstantSpace(array3));
    }

    /**
     * In this approach instead of calculate the prefix sum before hand we calculate it on the fly.
     * But we need to calculate the total sum before.
     * <p>
     * Then for the index "0" and "n - 1" (i.e. edge case) we check for (totalSum - a[0] == 0) and (totalSum - a[n - 1) == 0),
     * if matches then we return 0 and (n - 1) respectively.
     * <p>
     * For each element of the array starting from index "1" to "n - 1", we do
     * leftSum = leftSum + a[i - 1];
     * rightSum = totalSum - (leftSum + a[i])
     * <p>
     * if(leftSum == rightSum){
     * return i;
     * }
     * <p>
     * Finally we return -1.
     */
    private static int findEquilibriumIndexWithConstantSpace(final int[] array) {
        int totalSum = 0;

        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }

        int leftSum = 0;
        int rightSum = totalSum;

        for (int i = 0; i < array.length; i++) {
            rightSum -= array[i];
            if(leftSum == rightSum) {
                return i;
            }

            leftSum += array[i];
        }

        return -1;
    }

    /**
     * In this approach we first calculate the prefix sum array.
     * Then for each element A[i] of the array(starting from 1 to A.length - 1) we calculate the left and right sums.
     * leftSum = PF[i - 1] and rightSum = PF[A.length -1] - PF[i]
     * if leftSum == rightSum we return i; else check for next index
     * <p>
     * finally if nothing is found, we return -1
     * <p>
     * This has TC O(N) and SC O(N)
     */
    private static int findEquilibriumIndexUsingPrefixSumArray(final int[] array) {
        final int[] pf = new int[array.length];
        pf[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            pf[i] = pf[i - 1] + array[i];
        }

        if ((pf[array.length - 1] - array[0]) == 0) {
            return 0;
        }

        if (pf[array.length - 2] == 0) {
            return array.length - 1;
        }

        for (int i = 1; i < array.length; i++) {
            int leftSum = pf[i - 1];
            int rightSum = pf[array.length - 1] - pf[i];

            //System.out.printf("i=%s, left sum: %s, right sum: %s", i, leftSum, rightSum);
            //System.out.println();

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
