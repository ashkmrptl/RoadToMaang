package scaler.misc;

public class CombinationCalculation {
    public static void main(String[] args) {
        int A = 40;
        int B = 20;
        int C = 10007;

        System.out.println(calculate_new(A, B, C));
        System.out.println(calculate_optimized(A, B, C));
        //System.out.println(calculate(A, B, C));
    }

    private static int calculate_optimized(int A, int B, int C) {
        int[] comp = new int[B + 1];
        comp[0] = 1;

        for (int i = 1; i <= B; i++) {
            comp[i] = 1;
        }

        for (int i = 0; i<= A; i++) {
            int[] temp = comp.clone();
            for (int j = 0; j <= B; j++) {
                if (j == 0) {
                    comp[j] = 1;
                } else if (j > i) {
                    comp[j] = 0;
                } else if (j > 0) {
                    comp[j] = ((temp[j - 1] % C) + (temp[j] % C)) % C;
                }
            }
        }

        return comp[B];
    }

    static int calculate(int n, int r, int mod) {
        if (n == r || r == 0) {
            return 1;
        }

        return ((calculate(n - 1, r, mod) % mod) + (calculate(n - 1, r - 1, mod) % mod)) % mod;
    }

    static int calculate_new(int A, int B, int C) {
        long[] a = new long[A + 1];
        a[0] = 1;
        for (int i = 1; i <= A; i++) {
            a[i] = ((a[i - 1] % C) * (i % C)) % C;
            a[i] %= C;
        }

        long num = a[A] % C;
        long k = ((a[A - B] % C) * (a[B] % C)) % C;
        long power = pow(k, C - 2, C);
        long temp = ((num % C) * (power % C)) % C;
        return (int) temp;
    }

    public static long pow(long A, int B, int C) {
        if (A == 0) return 1;
        if (B == 0) return 1;
        if (B == 1) return (A + C) % C;

        long half = pow(A, B / 2, C);
        if (B % 2 == 0) {
            return ((half % C) * (half % C)) % C;
        } else {
            return ((half % C) * ((half * A) % C)) % C;
        }
    }
}
