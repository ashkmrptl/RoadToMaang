package scaler.recursion;

public class Factorial {
    public static void main(String[] args) {
        int A = 5;
        System.out.println(solve(A));

        A = 4;
        System.out.println(solve(A));

        A = 1;
        System.out.println(solve(A));
    }

    private static int solve(int n) {
        return factorial(n);
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
