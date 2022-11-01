package scaler.bitManipulation;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
 * Find the two integers that appear only once.
 * <p>
 * Problem Constraints
 * 2 <= |A| <= 100000
 * 1 <= A[i] <= 109
 * <p>
 * Input Format
 * The first argument is an array of integers of size N.
 * <p>
 * Output Format
 * Return an array of two integers that appear only once.
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 1, 2, 4]
 * Input 2:
 * A = [1, 2]
 * <p>
 * Example Output
 * Output 1:
 * [3, 4]
 * Output 2:
 * [1, 2]
 * <p>
 * Example Explanation
 * Explanation 1:
 * 3 and 4 appear only once.
 * Explanation 2:
 * <p>
 * 1 and 2 appear only once.
 */
public class SingleNumber3 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1, 2, 4};
        solve(array);
        solve_given_in_hint(array);

        array = new int[]{36, 50, 24, 56, 36, 24, 42, 50};
        solve(array);
        solve_given_in_hint(array);
    }

    private static void solve_given_in_hint(int[] A) {
        int aXorb = 0; // the result of a xor b;
        for (int item : A)
            aXorb ^= item;
        int lastBit = (aXorb & (aXorb - 1)) ^ aXorb; // the last bit that a diffs b
        int intA = 0, intB = 0;
        for (int item : A) {
            // based on the last bit, group the items into groupA(include a) and groupB
            if ((item & lastBit) != 0)
                intA = intA ^ item;
            else
                intB = intB ^ item;
        }
        int x = Math.min(intA, intB), y = Math.max(intA, intB);
        int[] ans = new int[2];
        ans[0] = x;
        ans[1] = y;
        System.out.println(Arrays.toString(ans));
    }

    /**
     * Approach :
     * Step 1:
     * We take XOR of all elements.
     * Step 2:
     * We find any set bit of the element we got by performing XOR of all elements in Step 1.
     * Step 3:
     * We can take the elements where the bit we found in above step is SET to get one number and
     * we can take the elements where the bit we found in above step is UNSET to get another element.
     *
     * @param A input array
     */
    public static void solve(final int[] A) {
        int xor = 0;

        for (int j : A) {
            xor ^= j;
        }

        //We can pick any SET bit, but for simplicity we're taking the left most set bit.
        int setBitPosition = 0;
        while (xor > 0) {
            if ((xor & 1) == 1) {
                break;
            }
            xor = xor >> 1;
            setBitPosition++;
        }

        // For based on this setBitPosition we will segregate the numbers into two set where it is SET and where it is UNSET.
        int xorSetBitSet = 0;
        int xorUnsetBitSet = 0;
        for (int i = 0; i < A.length; i++) {
            if (isBitSet(A[i], setBitPosition)) {
                xorSetBitSet ^= A[i];
            } else {
                xorUnsetBitSet ^= A[i];
            }
        }

        int[] ans = new int[2];
        if (xorSetBitSet > xorUnsetBitSet) {
            ans[0] = xorUnsetBitSet;
            ans[1] = xorSetBitSet;
        } else {
            ans[0] = xorSetBitSet;
            ans[1] = xorUnsetBitSet;
        }

        System.out.println(Arrays.toString(ans));
    }

    private static boolean isBitSet(final int N, final int i) {
        if ((N & (1 << i)) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private static long solve(long A, int B) {
        long ans = A;
        for (int i = 0; i < B; i++) {
            if ((A & (1L << i)) != 0) {
                ans = ans - (1L << i);
            }
        }
        return ans;
    }
}
