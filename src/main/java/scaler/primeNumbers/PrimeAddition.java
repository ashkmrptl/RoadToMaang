package scaler.primeNumbers;

/**
 * You are given an even number N and you need to represent the given number as the sum of primes.
 * The prime numbers do not necessarily have to be distinct. It is guaranteed that at least one possible solution exists.
 * You need to determine the minimum number of prime numbers needed to represent the given number.
 * <p>
 * Ex:
 * You can represent 26 as: 13+13
 * So we require minimum of 2 prime numbers to represent the number 26.
 */
public class PrimeAddition {
    public static void main(String[] args) {
        System.out.println(solve(26));
        System.out.println(solve(100));
    }

    /**
     * Approach:
     * All the even number is a sum of two prime numbers except 2. hence ans will be 2 for numbers greater than 2 else 1
     */
    private static int solve(int A) {
        if (A > 2) {
            return 2;
        }
        return 1;
    }

}
