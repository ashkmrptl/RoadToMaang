package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * A sequence x1, x2, ..., xn is Fibonacci-like if:
 * <p>
 * n >= 3
 * xi + xi+1 == xi+2 for all i + 2 <= n
 * Given a strictly increasing array arr of positive integers forming a sequence,
 * return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
 * <p>
 * A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr,
 * without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
 */
public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        //System.out.println(lenLongestFibSubseq(arr));
        System.out.println(lenLongestFibSubseq_optimized(arr));

        arr = new int[]{1, 3, 7, 11, 12, 14, 18};
        //System.out.println(lenLongestFibSubseq(arr));
        System.out.println(lenLongestFibSubseq_optimized(arr));
    }

    private static int lenLongestFibSubseq_optimized(int[] arr) {
        int length = arr.length;
        int[][] dp = new int[length][length];
        int result = 0;
        for (int i = 2; i < length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int val = arr[left] + arr[right] - arr[i];
                if (val < 0) {
                    left++;
                } else if (val > 0) {
                    right--;
                } else {
                    dp[right][i] = dp[left][right] + 1;
                    result = Math.max(result, dp[right][i]);
                    left++;
                    right--;
                }
            }
        }
        return result == 0 ? 0 : result + 2;
    }

    private static int lenLongestFibSubseq(int[] arr) {
        int maxLength = 0;
        //Map to fetch index of the diff in constant time
        final Map<Integer, Integer> map = new HashMap<>();

        //Add all elements as key and their indices as value
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        //Create a dp array to store the maxLength of fibonacci sequence between index i and index j. dp[i][j] contains the maxLength
        final int[][] dp = new int[arr.length][arr.length];

        //Constraint is given that the array will have a minimum of 3 elements. And onr, or two elements are always a fibonacci seq. So start at 2
        for (int i = 2; i < arr.length; i++) {
            //Go backward till zero to find the diff, if found fibonacci exists
            for (int j = i - 1; j >= 0; j--) {
                final int diff = arr[i] - arr[j];

                //Check if the diff exists in the array and if found its index is before j
                if (map.containsKey(diff) && map.get(diff) < j) {
                    //Update the maxLength in dp array
                    dp[i][j] = Math.max(dp[i][j], dp[j][map.get(diff)] + 1);

                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        //If max length is greater than zero add 2, the length of first two elements
        return maxLength > 0 ? maxLength + 2 : maxLength;
    }
}
