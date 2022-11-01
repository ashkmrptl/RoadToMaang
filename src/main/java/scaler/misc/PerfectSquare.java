package scaler.misc;

import java.util.Scanner;

/**
 * Given a number A. Return square root of the number if it is perfect square otherwise return -1.
 */
public class PerfectSquare {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int number = scan.nextInt();

        System.out.println(findSquareRootRecursively(1, number, number));

    }

    private static long findSquareRootRecursively(final long start, final long end, final long number) {
        long mid = (start + end) / 2;

        if(mid * mid == number) {
            return mid;
        }

        if(mid == end) {
            return -1;
        }

        if(mid * mid > number) {
            return findSquareRootRecursively(start, mid - 1, number);
        } else {
            return findSquareRootRecursively(mid + 1, end, number);
        }
    }
}
