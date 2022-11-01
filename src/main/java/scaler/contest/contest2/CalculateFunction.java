package scaler.contest.contest2;

/**
 * F(A) = F(A-1) + F(A-2) + F(A-3) + A
 * <p>
 * Given A, find F(A)
 */
public class CalculateFunction {
    public static void main(String[] args) {
        int A = 3;
        System.out.println(solve(A));

        A = 4;
        System.out.println(solve(A));

        A = 5;
        System.out.println(solve(A));

        A = 20;
        System.out.println(solve(A));
    }

    private static int solve(int A) {
        if (A == 0 || A == 1) {
            return 1;
        }

        if (A == 2) {
            return 2;
        }

        return calculate(A);
    }

    private static int calculate(int A) {
        if (A == 0 || A == 1) {
            return 1;
        }

        if (A == 2) {
            return 2;
        }

        return A + calculate(A - 1) + calculate(A - 2) + calculate(A - 3);
    }
}
