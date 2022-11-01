package scaler.modularArithmatic;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * <p>
 * Problem Constraints
 * 1 <= length of the column title <= 5
 * <p>
 * Input Format
 * The only argument is a string that represents the column title in the excel sheet.
 * <p>
 * Output Format
 * Return a single integer that represents the corresponding column number.
 * <p>
 * Example Input
 * Input 1:
 * AB
 * Input 2:
 * ABCD
 * <p>
 * Example Output
 * Output 1:
 * 28
 * Output 2:
 * 19010
 * <p>
 * Example Explanation
 * Explanation 1:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelColumnNumber {
    public static void main(String[] args) {
        String A = "A";
        System.out.println(solve(A));

        A = "Z";
        System.out.println(solve(A));

        A = "AB";
        System.out.println(solve(A));

        A = "ABCD";
        System.out.println(solve(A));
    }

    /**
     * Approach :
     * Approach is similar to binary to decimal conversion. The only difference is the base, which is 26 here.
     * Ex: A -> 1 * 26^0 = 1
     * B -> 2 * 26^0 = 2
     * AB -> (1 * 26^1) + (2 * 26^0)
     *
     * @param string input String
     * @return column corresponding to string
     */
    private static int solve(final String string) {
        int n = string.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int character = string.charAt(n - 1 - i);
            character = character % 64;
            result += (character * Math.pow(26, i));
        }

        return result;
    }
}
