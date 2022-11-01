package scaler.primeNumbers;

/**
 * A lucky number is a number that has exactly 2 distinct prime divisors.
 * <p>
 * You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        int A = 8;
        System.out.println(solve(A));

        A = 12;
        System.out.println(solve(A));
    }

    private static int solve(int A) {
        int n = A + 1;

        int[] seive = new int[n];
        for (int i = 0; i < n; i++) {
            seive[i] = 0;
        }

        for (int i = 2; i < n; i++) {
            if (seive[i] == 0) {
                for (int j = i; j < n; j += i) {
                    if (i != j) {
                        seive[j] += 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (seive[i] == 2) {
                count++;
            }
        }

        return count;
    }
}
