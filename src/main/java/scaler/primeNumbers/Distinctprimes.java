package scaler.primeNumbers;

import java.util.HashSet;
import java.util.Set;

/**
 * You have given an array A having N integers. Let say G is the product of all elements of A.
 * You have to find the number of distinct prime divisors of G.
 * <p>
 * Input:
 * A = [1, 2, 3, 4]
 * Output:
 * 2
 * <p>
 * Explanation:
 * here G = 1 * 2 * 3 * 4 = 24
 * and distinct prime divisors of G are [2, 3]
 */
public class Distinctprimes {
    public static void main(String[] args) {
        int[] A = new int[]{96, 98, 5, 41, 80};
        System.out.println(solve(A));
    }

    //We can use sieve of eratosthenes to find the prime no from 1 to MAX(A) + 1;
    private static int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        //Marking all numbers as prime
        int[] isPrime = new int[max + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = 1;
        }

        //Applying sieve of eratosthenes
        for (int i = 2; i * i < max + 1; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j < max + 1; j += i) {
                    if (j % i == 0) {
                        isPrime[j] = 0;
                    }
                }
            }
        }

        //take a HashSet and put the prime divisors of each elements in A, the size of SET is answer
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j * j <= isPrime.length; j++) {
                if (A[i] % j == 0) {
                    if (isPrime[j] == 1) {
                        set.add(j);
                    }
                    if (isPrime[A[i] / j] == 1) {
                        set.add(A[i] / j);
                    }
                }
            }
        }

        return set.size();
    }
}
