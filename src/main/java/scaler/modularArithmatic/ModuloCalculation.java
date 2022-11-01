package scaler.modularArithmatic;

/**
 * modulo is nothing but the reminder and it can be calculated as given formula below.
 * <p>
 * reminder = dividend - (divisor * quotient)
 */
public class ModuloCalculation {
    public static void main(String[] args) {
        final int[] A = new int[]{20, -20};
        final int[] B = new int[]{4, 3, -4, -3};

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int a = A[i];
                int b = B[j];
                int mod = a % b;
                System.out.println(a + " % " + b + " = " + mod);
            }
        }
    }
}
