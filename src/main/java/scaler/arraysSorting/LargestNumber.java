package scaler.arraysSorting;

import java.util.*;

/**
 * Problem Description
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*109
 * <p>
 * Input Format
 * The first argument is an array of integers.
 * <p>
 * Output Format
 * Return a string representing the largest number.
 * <p>
 * Example Input
 * Input 1:
 * A = [3, 30, 34, 5, 9]
 * Input 2:
 * A = [2, 3, 9, 0]
 * <p>
 * Example Output
 * Output 1:
 * "9534330"
 * Output 2:
 * "9320"
 * <p>
 * Example Explanation
 * Explanation 1:
 * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 * Explanation 2:
 * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9));
        System.out.println(solve(A));
    }

    private static String solve(List<Integer> A) {
        System.out.println("Before sort : " + A);

        StringBuilder result = new StringBuilder();
        A.sort((x, y) -> {
            String xy = x + "" + y;
            String yx = y + "" + x;

            System.out.println(xy + " " + yx);

            return xy.compareTo(yx) > 0 ? -1 : 1;
        });
        System.out.println("After sort, before reverse : " + A);

        for (int i : A) {
            result.append(i);
        }

        return result.toString();
    }
}
