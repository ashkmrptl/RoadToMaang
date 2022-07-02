package scaler.array;

/**
 * Given an array of length N, find count of pairs (i, j) so that a[i] + a[j] = K and i != j and (i, j) is equal to (j, i)
 */
public class PairsOfGivenSum {
    public static void main(String[] args) {
        final int[] array = new int[]{3, -2, 1, 4, 3, 6, 8};
        final int k = 10;
        System.out.println("No of pairs having sum : " + k + " is : " + countPairs(array, array.length, k));

        final int[] array1 = new int[]{5, 3, -2, 1, 4, 3, 6, 8, 5};
        final int k1 = 10;
        System.out.println("No of pairs having sum : " + k1 + " is : " + countPairs(array1, array1.length, k1));
    }

    /**
     * Approach:
     * For an array of size n = 4, all possible pairs are
     * <p>
     * (0,0)   (0,1)   (0,2)   (0,3)
     * (1,0)   (1,1)   (1,2)   (1,3)
     * (2,0)   (2,1)   (2,2)   (2,3)
     * (3,0)   (3,1)   (3,2)   (3,3)
     * <p>
     * As give i != j, we can discard
     * (0,0)
     *          (1,1)
     *                  (2,2)
     *                          (3,3)
     * <p>
     * Also (i, j) is equal to (j, i),  hence either the lower half or the upper half can be ignored.
     * So, ignoring
     * (1,0)
     * (2,0)   (2,1)
     * (3,0)   (3,1)   (3,2)
     * <p>
     * we have left with
     * (0,1)   (0,2)   (0,3)
     *         (1,2)   (1,3)
     *                 (2,3)
     * <p>
     * Now if we filter all the pairs whose sum = K and count them we get the answer.
     *
     * Time Complexity here will be O(n^2)
     *
     * @param array input array
     * @param n     array length
     * @param k     given sum
     * @return count of pairs
     */
    private static int countPairs(final int[] array, final int n, final int k) {
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i] + array[j]) == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
