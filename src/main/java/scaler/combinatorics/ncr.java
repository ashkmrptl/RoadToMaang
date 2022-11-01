package scaler.combinatorics;

/**
 * Compute nCr % m
 * <p>
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
 * <p>
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 */
public class ncr {
    public static void main(String[] args) {
        System.out.println(solve(5, 3, 10));
        System.out.println(solve_usingFactorial(5, 3, 10));
    }

    /**
     * nCr can be written as n-1Cr + n-1Cr-1
     */
    private static int solve(int n, int r, int m) {
        if (n == r || r == 0) {
            return 1;
        }

        return solve(n - 1, r, m) + solve(n - 1, r - 1, m);
    }

    /**
     * nCr = (n!)/((n-r)! * r!)
     */
    private static int solve_usingFactorial(int n, int r, int m) {
        int nFact = factorial(n);
        int nMinusRFact = factorial(n - r);
        int rFact = factorial(r);

        return (nFact / (nMinusRFact * rFact));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
