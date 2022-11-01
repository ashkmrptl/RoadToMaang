package scaler.strings;

public class StringReverse {
    public static void main(String[] args) {
        String A = "scaler";
        System.out.println(solve(A));
    }

    private static String solve(String A) {
        char[] s = A.toCharArray();
        int n = s.length;
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
        return new String(s);
    }
}
