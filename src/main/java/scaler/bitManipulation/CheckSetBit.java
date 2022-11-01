package scaler.bitManipulation;

/**
 * given a number N, check if ith bit is set(i.e. 1)
 */
public class CheckSetBit {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(check(n, 1));
        System.out.println(check(n, 2));
    }

    /**
     * Approach 1: We can right shift the number i times to get the Ith bit to the LSB(Least significant bit or the first position),
     * Then we can perform the shifted number an AND operation with one(i.e. ((N>>i) & 1) ). If the O/P is one the bit is set else unset.
     * Approach 2: We can left shift the number 1 to left by Ith times and the perform the AND operation. Basically we are moving the SET bit in
     * 1 to the ith location of the number.
     * So, after AND if the O/P is not zero, we can say the bit is SET else UNSET.
     *
     * @param n number
     * @param i ith bit
     * @return boolean
     */
    private static boolean check(final int n, final int i) {
        /*if (((n >> i) & 1) == 1) {
            return true;
        }
        return false;
        */

        if ((n & (1 << i)) > 0) {
            return true;
        }

        return false;
    }
}
