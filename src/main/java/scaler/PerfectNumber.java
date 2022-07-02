package scaler;

import java.util.Scanner;

/**
 * You are given N positive integers.
 * For each given integer A, you have to tell whether it is a perfect number or not.
 * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
 *
 * Example Input
 * Input 1:
 *  2
 *  4
 *  6
 *
 * Input 2:
 *  1
 *  3
 *
 * Example Output
 * Output 1:
 *  NO
 *  YES
 *
 * Output 2:
 *  NO
 */
public class PerfectNumber {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if(number == findProperDivisorSum(number)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int findProperDivisorSum(final int n) {
        int sum = 0;

        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                sum += i;

                int secondDivisor = n / i;
                if(secondDivisor != n) {
                    sum += secondDivisor;
                }
                System.out.println("divisor 1 : " + i +" divisor 2 : " + secondDivisor + " sum : " + sum);
            }
        }

        return sum;
    }
}
