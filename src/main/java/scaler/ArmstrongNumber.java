package scaler;

import java.util.Scanner;

/**
 * You are given an integer N you need to print all the Armstrong Numbers between 1 to N.
 *
 * If sum of cubes of each digit of the number is equal to the number itself, then the number is called an Armstrong number.
 *
 * For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();

        for(int i = 1; i <= n; i++) {
            if(i == findSumOfCubesOfDigits(i)) {
                System.out.println(i);
            }
        }
    }

    private static int findSumOfCubesOfDigits(int number) {
        int sum = 0;

        while(number > 0) {
            int rem = number % 10;

            sum = sum + (rem * rem * rem);

            number = number / 10;
        }

        return sum;
    }
}
