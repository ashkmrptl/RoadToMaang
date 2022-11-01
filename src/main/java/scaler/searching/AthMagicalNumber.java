package scaler.searching;

/**
 * You are given three positive integers, A, B, and C.
 * Any positive integer is magical if divisible by either B or C.
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.
 */
public class AthMagicalNumber {
    public static void main(String[] args) {
        System.out.println(solve(4, 2, 3));
        System.out.println(solve(807414236, 3788, 38141));
    }

    private static int solve(int A, int B, int C) {
        int mod = 1000000007;
        long LCM = ((long) B * C) / gcd(B, C);

        long left = Math.min(B, C);
        long right = (long) Math.min(B, C) * A;

        if (A == 1) {
            return (int) left;
        }

        long ans = left;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long noOfMultiples = (mid / B) + (mid / C) - (mid / LCM);

            if (noOfMultiples >= A) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans < 0) {
            ans = ans + mod;
        }

        return (int) (ans % mod);
    }

    private static long gcd(long A, long B) {
        while (B > 0) {
            long temp = A % B;
            A = B;
            B = temp;
        }

        return A;
    }

    private static int gcd(long A, long B, int mod) {
        while (B > 0) {
            long temp = A % B;
            A = B;
            B = temp;
        }

        return (int) A % mod;
    }
}
