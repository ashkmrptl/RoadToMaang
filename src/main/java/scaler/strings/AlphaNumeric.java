package scaler.strings;

public class AlphaNumeric {
    public static void main(String[] args) {
        char[] A = new char[]{'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.println(solve(A));
    }

    private static int solve(char[] A) {
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isNumber = false;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 97 && A[i] <= 122) {
                isLowerCase = true;
            } else if (A[i] >= 65 && A[i] <= 90) {
                isUpperCase = true;
            } else if (A[i] >= 48 && A[i] <= 57) {
                isNumber = true;
            } else {
                return 0;
            }
        }

        if (isLowerCase && isUpperCase && isNumber) {
            return 1;
        }

        return 0;
    }
}
