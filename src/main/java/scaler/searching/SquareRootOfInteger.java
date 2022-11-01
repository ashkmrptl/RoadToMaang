package scaler.searching;

public class SquareRootOfInteger {
    public static void main(String[] args) {
        int A = 200;
        System.out.println(sqrt(A));
        System.out.println(sqrt(144));
        System.out.println(sqrt(2147483647));
    }

    private static int sqrt(int A) {
        if (A == 0) {
            return 0;
        }
        int l = 1;
        int r = A;

        long ans = 1;

        while (l <= r) {
            long mid = ((long)l + (long)r) / 2L;

            if (mid * mid == A) {
                return (int)mid;
            } else if (mid * mid < A) {
                ans = mid;
                l = (int)mid + 1;
            } else {
                r = (int)mid - 1;
            }
        }

        return (int)ans;
    }
}
