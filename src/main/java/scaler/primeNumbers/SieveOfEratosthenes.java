package scaler.primeNumbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This algorithm helps to find the prime factorizations.
 * Find all the prime numbers from 1 to N
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int N = 50;
        System.out.println(Arrays.toString(solve(N)));
        System.out.println(Arrays.toString(solveOptimized(N)));
    }

    /**
     * This can be slightly optimized by restricting the fist loop to sqrt(A) and the second loop to directly to go to the square of the number
     */
    private static int[] solveOptimized(int A) {
        int n = A + 1;
        boolean[] boolArray = new boolean[n];

        //Starting from 2, because 0 and 1 are non-prime numbers
        for (int i = 2; i < n; i++) {
            boolArray[i] = true;
        }

        for (int i = 2; i * i  < n; i++) {
            for (int j = i * i; j < n; j += i) {
                if (j % i == 0) {
                    boolArray[j] = false;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (boolArray[i]) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }

    private static int[] solve(int A) {
        //We need take an array of size n + 1
        int n = A + 1;
        boolean[] boolArray = new boolean[n];
        boolArray[1] = false;

        //At start we consider all numbers except 1 as a prime number
        for (int i = 2; i < n; i++) {
            boolArray[i] = true;
        }

        for (int i = 2; i < n; i++) {
            for (int j = i + i; j < n; j += i) {
                if (j % i == 0) {
                    boolArray[j] = false;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (boolArray[i]) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(x -> x).toArray();

    }
}
