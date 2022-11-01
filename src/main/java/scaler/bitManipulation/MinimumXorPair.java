package scaler.bitManipulation;

import java.util.Arrays;

/**
 * Find the pair with the minimum XOR.
 * <p>
 * Approach: The closer the numbers the smaller their XORs, because closer numbers has chances of having similar bits in maximum MSB position.
 * Hence, we'll sort the array then, compare XORs of each consecutive elements.
 */
public class MinimumXorPair {
    public static void main(String[] args) {
        int[] A = new int[]{3, 5, 7, 8, 10, 12, 14};
        solve(A);

        A = new int[]{0, 4, 7, 8};
        solve(A);
    }

    private static void solve(final int[] A) {
        //Sort the array
        Arrays.sort(A);

        int minimumXor = Integer.MAX_VALUE;
        int minXorIndex = -1;

        //getting the xor of all consecutive elements
        for (int i = 0; i < A.length - 1; i++) {
            if ((A[i] ^ A[i + 1]) < minimumXor) {
                minXorIndex = i;
                minimumXor = (A[i] ^ A[i + 1]);
            }
        }

        System.out.println("minimum XOR is : " + minimumXor);
        System.out.println("minimum XOR pair is : " + A[minXorIndex] + " " + A[minXorIndex + 1]);
    }
}
