package scaler.misc;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();

        int count = 0;

        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                if(i == n / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        if(count == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
