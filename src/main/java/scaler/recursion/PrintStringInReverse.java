package scaler.recursion;

import java.util.Scanner;

public class PrintStringInReverse {
    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        final String str = s.nextLine();
        reverse(str, 0);
    }

    private static void reverse(String s, int i) {
        if (i == s.length() - 1) {
            System.out.print(s.charAt(i));
            return;
        }

        reverse(s, i + 1);
        System.out.print(s.charAt(i));
    }
}
