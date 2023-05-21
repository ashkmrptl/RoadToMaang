package leetCode.maths;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-120));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-1534236469));
    }

    private static int reverse(int x) {
        /*int res = 0;
        while (x != 0) {
            int reminder = x % 10;
            res = (res * 10) + reminder;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && reminder > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && reminder < -8)) {
                return 0;
            }
            x = x / 10;
        }

        return res;*/

        int res = 0;
        while (x != 0) {
            int reminder = x % 10;

            //Positive boundary check
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && reminder > 7)) {
                return 0;
            }

            //Negative boundary check
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && reminder < -8)) {
                return 0;
            }
            res = res * 10 + reminder;

            x = x / 10;
        }
        return res;
    }
}
