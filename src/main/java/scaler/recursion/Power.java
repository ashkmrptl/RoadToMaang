package scaler.recursion;

public class Power {
    public static void main(String[] args) {
        int A = 2132, B = 0, C = 12;
        System.out.println(pow(A, B, C));

        A = -1;
        B = 1;
        C = 20;
        System.out.println(pow(A, B, C));

        A = 71045970;
        B = 41535484;
        C = 64735492;
        System.out.println(pow(A, B, C));
    }

    private static int pow(int A, int B, int C) {
        long x = powRecursive(A, B, C);
        return (int) (x < 0 ? x + C : x);
    }

    private static long powRecursive(int a, int n, int C) {
        if (n == 0) {
            return 1;
        }

        //System.out.println(n / 2);

        long x = powRecursive(a, n / 2, C);
        //System.out.println("x : : " + x);

        if (n % 2 == 0) {
            return x % C * x % C;
        } else {
            return ((long)a) % C * x % C * x % C;
        }
    }
}
