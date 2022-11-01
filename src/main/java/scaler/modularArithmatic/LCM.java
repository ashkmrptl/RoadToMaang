package scaler.modularArithmatic;

public class LCM {
    public static void main(String[] args) {
        int A = 6, B = 9;
        System.out.println("LCM : " + solve(A, B));
        System.out.println("LCM : " + solveOptimized(A, B));

        A = 2;
        B = 3;
        System.out.println("LCM : " + solve(A, B));
        System.out.println("LCM : " + solveOptimized(A, B));

        A = 2;
        B = 6;
        System.out.println("LCM : " + solve(A, B));
        System.out.println("LCM : " + solveOptimized(A, B));

        A = 2;
        B = 2;
        System.out.println("LCM : " + solve(A, B));
        System.out.println("LCM : " + solveOptimized(A, B));

        A = 69;
        B = 23;
        System.out.println("LCM : " + solve(A, B));
        System.out.println("LCM : " + solveOptimized(A, B));

        A = 52;
        B = 704;
        System.out.println("LCM : " + solve(A, B));
        System.out.println("LCM : " + solveOptimized(A, B));
    }

    private static int solveOptimized(final int A, final int B) {
        int num = 1;
        for (int i = 1; i <= Math.min(A, B); i++) {
            if (A % i == 0 && B % i == 0) {
                num = i;
            }
        }

        return ((A * B) / num);
    }

    private static int solve(int A, int B) {
        int result = 1;
        int n = Math.min(A, B);
        for (int i = 2; i <= n; i++) {
            if ((A % i == 0) && (B % i == 0)) {
                result *= i;
                A = A / i;
                B = B / i;
                i = 1;
            }
        }

        result *= (A == B) ? A : A * B;

        return result;
    }
}
