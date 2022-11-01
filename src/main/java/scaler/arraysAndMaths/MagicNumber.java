package scaler.arraysAndMaths;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given an integer A, find and return the Ath magic number.
 * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 * <p>
 * Problem Constraints
 * 1 <= A <= 5000
 * <p>
 * Input Format
 * The only argument given is integer A.
 * <p>
 * Output Format
 * Return the Ath magic number.
 * <p>
 * Example Input
 * Example Input 1:
 * A = 3
 * Example Input 2:
 * A = 10
 * <p>
 * Example Output
 * Example Output 1:
 * 30
 * Example Output 2:
 * 650
 * <p>
 * Example Explanation
 * Explanation 1:
 * Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
 * 3rd element in this is 30
 * Explanation 2:
 * In the sequence shown in explanation 1, 10th element will be 650.
 */
public class MagicNumber {
    public static void main(String[] args) {
        int A = 10;
        System.out.println(solve(A));

        A = 16;
        System.out.println(solve(A));
    }

    private static int solve(final int A) {
        List<Double> list = new ArrayList<>();
        int i = 1;

        while (true) {
            if (list.isEmpty()) {
                list.add(Math.pow(5, i));
            } else {
                int n = list.size();
                double num = Math.pow(5, i);
                list.add(num);
                for (int j = 0; j < n; j++) {
                    list.add(list.get(j) + num);
                }
            }
            i++;
            if (list.size() >= A) {
                return list.get(A - 1).intValue();
            }
        }

    }
}
