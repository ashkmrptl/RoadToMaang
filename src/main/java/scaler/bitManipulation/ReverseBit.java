package scaler.bitManipulation;

/**
 * Problem Description
 * Reverse the bits of an 32 bit unsigned integer A.
 * <p>
 * Problem Constraints
 * 0 <= A <= 232
 * <p>
 * Input Format
 * First and only argument of input contains an integer A.
 * <p>
 * Output Format
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 * <p>
 * Example Input
 * Input 1:
 * 0
 * Input 2:
 * 3
 * <p>
 * Example Output
 * Output 1:
 * 0
 * Output 2:
 * 3221225472
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Explanation 2:
 * <p>
 * 00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */
public class ReverseBit {

    public static void main(String[] args) {
        long a = 3;

        final StringBuilder binaryString = new StringBuilder(Long.toBinaryString(a));

        binaryString.reverse();

        int n = binaryString.length();

        for (int i = 0; i < (32 - n); i++) {
            binaryString.append("0");
        }

        long num = Long.parseLong(binaryString.toString(), 2);

        System.out.println(num);
    }
}
