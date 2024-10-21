package companies.walmart;

import java.util.Arrays;

/**
 * 1356. Sort Integers by The Number of 1 Bits
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        int[] arr = {3, 8, 5, 7, 1, 2};
        int[] sortedArr = sortByBits(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] sortByBits(int[] arr) {
        // Convert int[] to Integer[] for custom sorting
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort the array based on the number of set bits, then natural order
        Arrays.sort(array, (t1, t2) -> {
            int count1 = countSetBits(t1);
            int count2 = countSetBits(t2);

            if (count1 != count2) {
                return count1 - count2;  // Sort by number of set bits (ascending)
            } else {
                return t1 - t2;  // Sort by natural order if set bit counts are equal
            }
        });

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    private static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);  // Clear the lowest set bit
            count++;
        }
        return count;
    }
}
