package scaler.primeNumbers;

/**
 * Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.
 * <p>
 * A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.
 * <p>
 * Input Format
 * <p>
 * The first argument given is an Array A, having N integers.
 * Output Format
 * <p>
 * Return an integer X, i.e number of Prime subsequences.
 * As X can be very large print X % (1000000007), here % is modulus operator.
 * Constraints
 * <p>
 * 1 <= N <= 1e3
 * 1 <= A[i] <= 1e6
 * For Example
 * <p>
 * Input:
 * A = [1, 2, 3]
 * Output:
 * 3
 * <p>
 * Explanation:
 * no. Subsequences      Prime subsequences
 * 1.  [1]                     No
 * 2.  [1, 2]                  No
 * 3.  [1, 3]                  No
 * 4.  [1, 2, 3]               No
 * 5.  [2]                     Yes
 * 6.  [2, 3]                  Yes
 * 7.  [3]                     Yes
 * 8.  []                      No
 * <p>
 * here we have 3 subsequences(5, 6, 7) those have only prime number(s).
 */
public class PrimeSubsequences {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int k : A) {
            max = Math.max(max, k);
        }

        //prepare boolean array of size max+1
        boolean[] booleans = new boolean[max + 1];

        //Set all numbers except 0 and 1 as prime
        for (int i = 2; i <= max; i++) {
            booleans[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (booleans[i] == true) {
                for (int j = i * i; j <= max; j += i) {
                    if (booleans[j] == true) {
                        booleans[j] = false;
                    }
                }
            }
        }

        long count = 0;
        long number = 1;
        int mod = 1000000007;

        for (int i = 0; i < A.length; i++) {
            if (booleans[A[i]] == true) {
                count = ((count % mod) + (number % mod)) % mod;
                number = (number * 2) % mod;
            }
        }

        return (int) count;
    }
}
