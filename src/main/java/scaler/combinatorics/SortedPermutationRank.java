package scaler.combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 * <p>
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRank {
    public static void main(String[] args) {
        System.out.println(solve("cba"));
        System.out.println(solve("acb"));
        System.out.println(solveWhenDuplicates("cab"));
        System.out.println(solveWhenDuplicates("baa"));
        System.out.println(solveWhenDuplicates("acb"));
    }

    private static int solveWhenDuplicates(String A) {
        //Frequency of each character
        int[] ascii = new int[150];
        int N = A.length();
        for (int i = 0; i < N; i++) {
            ascii[A.charAt(i)]++;
        }

        //Generating factorials from [0 to LengthOfString]
        long[] factorials = new long[N + 1];
        long mod = 1000003;
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = (factorials[i - 1] % mod * ((long) i) % mod) % mod;
        }

        //Calculating answer
        long res = 0;
        int currPos = 1;
        for (int i = 0; i < N; i++) {
            char ch = A.charAt(i);

            long numerator = 0;
            long denominator = 1;
            for (int j = 0; j < 150; j++) {
                if (j < (int) ch) {
                    numerator += ascii[j];
                }
                denominator = (denominator % mod * factorials[ascii[j]] % mod) % mod;
            }

            //(numerator * factorials[N - currPos] / denominator) % mod
            //Since mod is a prime number and length can not be equal to or greater than mod.
            //Therefore, (numerator, mod) are co-primes
            //Apply fermat’s little thm for denominator
            long tempRes = res;
            res = (numerator % mod * factorials[(N - currPos)] % mod) % mod;
            res = (res % mod * fastPower(denominator, mod - 2, mod));
            res = (res % mod + tempRes % mod) % mod;

            ascii[ch]--;
            currPos++;
        }

        return (int) ((res + 1 + mod) % mod);
    }

    public static long fastPower(long a, long b, long m) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res % m * a % m) % m;
                b = b - 1;
            }

            a = (a % m * a % m) % m;
            b = b / 2;
        }

        return res;
    }

    /**
     * Approach:
     * Iterate over given string and find the order
     * <p>
     * if its char[next] < char[prev] then increase the count, then inside the outer loop find how many valid permutation
     * is possible at (n-ith) position and multiply it with count.
     */
    private static int solve(String A) {
        int n = A.length();

        long ans = 0;
        int mod = 1000003;

        //This following can be improved by taking an char[] of length 265 (the chars present in the string can be marked as 1 in the array else 0,
        // the chars in the string are unique, hence the max length of the string can be 256) and
        // pre-calculated factorial array of size 26(from 0 to 25, as chars are unique and there can at most be 26 chars)
        // **Note: This will not work for strings having duplicate characters


        for (int i = 0; i < A.length(); i++) {
            long count = 0;
            for (int j = i; j < A.length(); j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    count++;
                }
            }

            ans += (count * factorial(n - i - 1)) % mod;
        }

        //Following is a bit better version, as we don't need to scan from start each time which searching for smaller chars
        /*for (int i = 0; i < n; i++) {
            long count = 0;

            char ch = A.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char ch1 = A.charAt(j);
                if (ch1 < ch) {
                    count++;
                }
            }
            ans += (count * factorial(n - i - 1)) % mod;
        }*/

        return (int) (ans + 1) % mod;
    }

    private static int factorial(long n) {
        if (n == 0) {
            return 1;
        }

        int mod = 1000003;
        return (int) ((n * factorial(n - 1)) % mod);
    }
}
