package companies.microsoft;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }

    private static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long longDividend = dividend;
        long longDivisor = divisor;

        longDividend = Math.abs(longDividend);
        longDivisor = Math.abs(longDivisor);

        int ans = 0;

        while (longDividend >= longDivisor) {
            int count = 1;
            long tempDivisor = longDivisor;
            while (longDividend - tempDivisor >= tempDivisor) {
                tempDivisor = tempDivisor + tempDivisor;
                count++;
            }

            ans += count;

            longDividend = longDividend - tempDivisor;
        }

        return isNegative ? -ans : ans;
    }

    private static int divide_copied(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long longDividend = dividend;
        long longDivisor = divisor;

        longDividend = Math.abs(longDividend);
        longDivisor = Math.abs(longDivisor);

        int quotient = 0;

        while (longDividend >= longDivisor) {
            int shift = 0;
            while (longDividend >= (longDivisor << shift)) {
                shift++;
            }
            shift--;
            longDividend = longDividend - (longDivisor << shift);
            quotient = quotient + (1 << shift);
        }

        return isNegative ? -quotient : quotient;
    }
}
