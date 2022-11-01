package scaler.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int A = 46;
        System.out.println(solve(A));
    }

    private static int solve(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + solve(n / 10);
    }
}
