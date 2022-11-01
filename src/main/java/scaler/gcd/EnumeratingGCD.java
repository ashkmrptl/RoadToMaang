package scaler.gcd;

/**
 * You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
 * As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.
 *
 * You have to return the value of GCD found.
 *
 * The greatest common divisor of 2 numbers, A and B, is the largest number, D that divides both A and B perfectly.
 */
public class EnumeratingGCD {
    public static void main(String[] args) {
        String A = "123456781234567812345";
        String B = "1234567812345678123456781234567123456";

        System.out.println(solve(A, B));
    }

    /**
     * This can be solved in O(1) TC and O(1) SC as below.
     * There are two conditions.
     * 1) When a and b are equal.
     *  In this case the GCD becomes a.
     * 2) When a != b.
     *  So, GCD will be GCD(a, a+1, a+2+ ...... b)
     *  And, we know GCD(x, y) == GCD(x, y - x)
     *  So,GCD(a, a+1) = GCD(a, a+1-a) => GCD(a, 1) => 1
     *  The answer will always be 1
     */
    private static String solve(String a, String b) {
        if (a.equals(b)) {
            return a;
        } else {
            return "1";
        }
    }
}
