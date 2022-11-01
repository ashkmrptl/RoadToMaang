package scaler.recursion;

/**
 * Problem Description
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).
 * <p>
 * Problem Constraints
 * 1 <= A <= 20
 * 1 <= B <= 2A - 1
 * <p>
 * Input Format
 * First argument is an integer A.
 * Second argument is an integer B.
 * <p>
 * Output Format
 * Return an integer denoting the Bth indexed symbol in row A.
 * <p>
 * Example Input
 * Input 1:
 * A = 2
 * B = 1
 * Input 2:
 * A = 2
 * B = 2
 * <p>
 * Example Output
 * Output 1:
 * 0
 * Output 2:
 * 1
 * <p>
 * Example Explanation
 * Explanation 1:
 * Row 1: 0
 * Row 2: 01
 * Explanation 2:
 * Row 1: 0
 * Row 2: 01
 */
public class KthSymbol {
    public static void main(String[] args) {
        int A = 2;
        int B = 1;
        System.out.println(solve(A, B));
        System.out.println(solveOptimized(A, B));

        A = 2;
        B = 2;
        System.out.println(solve(A, B));
        System.out.println(solveOptimized(A, B));
    }

    private static int solve(int A, int B) {
        String row = "0";
        for (int i = 0; i < A; i++) {
            row = generateRow(row, row.length() - 1);
        }

        return Integer.parseInt(String.valueOf(row.charAt(B - 1)));
    }

    private static String generateRow(String row, int i) {
        if (i == 0) {
            return row.charAt(i) == '0' ? "01" : "10";
        }

        return generateRow(row, i - 1) + (row.charAt(i) == '0' ? "01" : "10");
    }

    private static int solveOptimized(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }

        int x = solveOptimized(A - 1, (B % 2 == 0) ? B / 2 : (B + 1) / 2);

        if (x == 0) {//produces 0 1
            if (B % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {//produces 1 0
            if (B % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
