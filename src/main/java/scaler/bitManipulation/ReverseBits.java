package scaler.bitManipulation;

/**
 * Reverse the bits of an 32 bit unsigned integer A.
 */
public class ReverseBits {
    public static void main(String[] args) {
        long A = 3;
        System.out.println(solve(A));
    }

    /**
     * In this we swap bits till n/2. 'n' here is 32 which is o of bits.
     * Swapping is required in the case where the bits are different.
     * XOR can be used to swap bits.
     */
//    private static long solveOptimized() {
//        long reverseNumber = 0;
//
//        for (int i = 0; i < 32; i++) {
//
//        }
//    }

    private static long solve(long a) {
        String binaryString = decimalToBinary(a);

        return binaryToDecimal(binaryString);
    }

    private static String decimalToBinary(long a) {
        StringBuilder binary = new StringBuilder();

        while (a > 0) {
            long rem = a % 2;
            a = a / 2;
            binary.append(rem);
        }

        while (binary.length() < 32) {
            binary.append(0);
        }

        return binary.toString();
    }

    private static long binaryToDecimal(String binaryString) {
        long num = 0;

        for (int i = 31; i >= 0; i--) {
            if (binaryString.charAt(i) != '0') {
                num = num + power(2, 31 - i);
            }
        }

        return num;
    }

    private static long power(int a, int b) {
        if (b == 0) {
            return 1;
        }

        long power = power(a, b / 2);
        if (b % 2 == 0) {
            return power * power;
        } else {
            return power * power * a;
        }
    }
}
