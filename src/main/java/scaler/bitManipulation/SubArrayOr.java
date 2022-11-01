package scaler.bitManipulation;

/**
 * You are given an array of integers A of size N.
 * <p>
 * The value of a subarray is defined as BITWISE OR of all elements in it.
 * <p>
 * Return the sum of value of all subarrays of A % 109 + 7.
 */
public class SubArrayOr {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));

        A = new int[]{347148, 221001, 394957, 729925, 276769, 40726, 552988, 29952, 184491, 146773, 418965, 307, 219145, 183037, 178111, 81123, 109199, 683929, 422034, 346291, 11434, 7327, 340473, 316152, 364005, 359269, 170935, 105784, 224044, 22563, 48561, 165781, 9329, 357681, 169473, 175031, 605611, 374501, 6607, 329965, 76068, 836137, 103041, 486817, 195549, 107317, 34399, 56907, 37477, 189690, 36796, 376663, 39721, 177563, 174179, 183646, 217729, 408031, 429122, 631665, 282941, 526797, 262186, 306571, 63613, 57501, 70685, 226381, 1338, 9360, 130360, 20300, 400906, 87823, 180349, 108813, 18181, 119185, 1, 102611, 63591, 12889, 311185, 383896, 8701, 76077, 75481, 386017, 153553, 304913, 383455, 105948, 142885, 1, 12610, 137005, 119185, 16948, 66171, 123683};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        long sum = 0;

        long totalNoOfSubArrays = ((long) A.length * (A.length + 1)) / 2;

        for (int i = 0; i < 32; i++) {
            long zeroCount = 0;
            long ans = 0;
            for (int k : A) {
                if ((k & (1 << i)) == 0) {
                    zeroCount++;
                } else {
                    ans += (zeroCount * (zeroCount + 1)) / 2;
                    zeroCount = 0;
                }
            }
            ans += (zeroCount * (zeroCount + 1)) / 2;
            sum += (totalNoOfSubArrays - ans) * (long)(1 << i);
        }

        return (int) (sum % 1000000007);
    }
}
