package scaler.primeNumbers;

/**
 * Smallest prime factors from the numbers 1 -> N
 */
public class SmallestPrimeFactor {
    public static void main(String[] args) {
        int A = 1007;
        solve(A);
    }

    private static void solve(int A) {
        int n = A + 1;

        int[] spf = new int[n];
        for (int i = 1; i < n; i++) {
            spf[i] = i;
        }

        for (int i = 2; i < n; i++) {
            if (spf[i] == i) {//prime number
                for (int j = i * i; j < n; j += i) {
                    if (spf[j] == j) {//If not updated then update
                        spf[j] = i;
                    }
                }
            }
        }

        for (int num : spf) {
            System.out.print(num + " ");
        }
    }
}
