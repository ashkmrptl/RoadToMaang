package scaler.gcd;

public class CalculateGCD {
    public static void main(String[] args) {
        int A = 12;
        int B = 30;

        System.out.println(calculateGCD(A, B));
    }

    /**
     * We know that GCD(x, y) = GCD(x, y - x) where y > x
     * Using the above we can say that GCD(x, y) = GCD(x, y % x). With this expression we can reduce one number to zero and
     * as GCD(0, X) = X. We can easily find the GCD this way.
     */
    private static int calculateGCD(int A, int B) {//Let's assume B is small
        while (B > 0) {
            int temp = A % B;
            A = B;
            B = temp;
        }
        return A;
    }
}
