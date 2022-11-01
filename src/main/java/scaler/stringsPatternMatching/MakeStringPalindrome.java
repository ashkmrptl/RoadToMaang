package scaler.stringsPatternMatching;

public class MakeStringPalindrome {
    public static void main(String[] args) {
        String A = "abc";
        //System.out.println(solve_twoPointers(A));
        System.out.println(solve_twoPointers("abcxbca"));
    }

    private static int solve_twoPointers(String A) {
        int counter = 0, resetCounter = 0;
        int i = 0;
        int j = A.length() - 1;

        while (i <= j) {
            if (i != j && A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
                resetCounter++;
            } else if (i != 0 && A.charAt(i) != A.charAt(j)) {
                i = 0;
                counter += resetCounter;
                resetCounter = 0;
            } else if (A.charAt(i) != A.charAt(j)) {
                counter++;
                j--;
            } else {
                j--;
            }
        }
        return counter;
    }
}
