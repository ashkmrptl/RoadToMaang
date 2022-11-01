package scaler.recursion;

public class PrintReverseString {
    public static void main(String[] args) {
        final String s = "scaleracademy";
        solve(s, s.length() - 1);
    }

    private static void solve(final String s, final int n) {
        if (n == 0) {
            System.out.print(s.charAt(n));
        } else {
            System.out.print(s.charAt(n));
            solve(s, n - 1);
        }
    }
}
