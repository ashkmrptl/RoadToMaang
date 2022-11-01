package scaler.bitManipulation;

/**
 * Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
 * <p>
 * NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Approach:
 * XOR of two same numbers is always zero and any number SORed with zero returned the same number.
 *
 * So, by applying this to all numbers in the array we can finally get the unique number
 */
public class SingleNumber {
    public static void main(String[] args) {
        final int[] A = new int[]{1, 4, 3, 6, 5, 3, 5, 4, 1};

        int ans = A[0];

        for (int i = 1; i < A.length; i++) {
            ans ^= A[i];
        }

        System.out.println("The unique number is  : " + ans);
    }
}
