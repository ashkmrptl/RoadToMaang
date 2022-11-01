package scaler.array;

/**
 * Problem Description
 *
 * Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.
 * See example for clarifications over the pattern.
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * Input Format
 * First line is an integer N
 * Output Format
 * N lines conatining only char '*' as per the question.
 *
 * Example Input
 * Input 1:
 * 4
 * Input 2:
 * 6
 *
 * Example Output
 * Output 1:
 *
 * ********
 * ***  ***
 * **    **
 * *      *
 * *      *
 * **    **
 * ***  ***
 * ********
 *
 * Output 2:
 *
 * ************
 * *****  *****
 * ****    ****
 * ***      ***
 * **        **
 * *          *
 * *          *
 * **        **
 * ***      ***
 * ****    ****
 * *****  *****
 * ************
 */
public class StarPattern {
    public static void main(String[] args) {
        int n = 4;
        print(n);
        n = 6;
        print(n);
        n = 10;
        print(n);
    }

    private static void print(final int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > n - 1 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j > n - 1 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
