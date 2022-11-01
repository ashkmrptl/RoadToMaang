package scaler.primeNumbers;

import java.util.Arrays;

public class PrimeSum {
    public static void main(String[] args) {
        int A = 4;
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(int A) {
        int n = A + 1;

        boolean[] sieve = new boolean[n];

        for (int i = 2; i < n; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int[] res = new int[2];
        for (int i = 2; i < n; i++) {
            if (sieve[i] && sieve[A - i]) {
                res[0] = i;
                res[1] = A - i;
                break;
            }
        }

        return res;
    }
}
