package leetCode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
        System.out.println(convert(s, 4));
        System.out.println(convert(s, 5));

        System.out.println(solve_copiedFromLeetCodeSolution(s, 3));
        System.out.println(solve_copiedFromLeetCodeSolution(s, 4));
        System.out.println(solve_copiedFromLeetCodeSolution(s, 5));
    }

    private static String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows == 1) {
            return s;
        }

        int totalDiff = 2 * (numRows - 1);

        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {

            int diff1 = totalDiff - (2 * i);
            int diff2 = totalDiff - diff1;

            boolean toggle = false;

            int j = i;
            while (j < s.length()) {
                result.append(s.charAt(j));
                if (diff1 == 0) {
                    j += diff2;
                    continue;
                }
                if (diff2 == 0) {
                    j += diff1;
                    continue;
                }
                if (!toggle) {
                    j += diff1;
                } else {
                    j += diff2;
                }
                toggle = !toggle;
            }
        }

        return result.toString();
    }

    private static String solve_copiedFromLeetCodeSolution(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
