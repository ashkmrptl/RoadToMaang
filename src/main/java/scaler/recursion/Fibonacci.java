package scaler.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int A = 5;
        System.out.println(solve(A));

        A = 2;
        System.out.println(solve(A));

        A = 9;
        System.out.println(solve(A));
    }

    private static int solve(final int A) {
        return fibonacci(A);
    }

    private static int fibonacci(int A) {
        if (A <= 1) {
            return A;
        }
        int a = fibonacci(A - 1);
        int b = fibonacci(A - 2);

        return a + b;
    }
}
