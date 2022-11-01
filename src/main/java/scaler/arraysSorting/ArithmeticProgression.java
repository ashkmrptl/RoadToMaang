package scaler.arraysSorting;

import java.util.*;

/**
 * Problem Description
 * Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * <p>
 * Problem Constraints
 * 2 <= N <= 105
 * -109 <= A[i] <= 109
 * <p>
 * Input Format
 * The first and only argument is an integer array A of size N.
 * <p>
 * Output Format
 * Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.
 * <p>
 * Example Input
 * Input 1:
 * A = [3, 5, 1]
 * Input 2:
 * A = [2, 4, 1]
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 * <p>
 * Example Explanation
 * Explanation 1:
 * We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 * Explanation 2:
 * There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class ArithmeticProgression {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 5, 1);
        System.out.println(solve(list));

        list = Arrays.asList(5, 3, 5, 3);
        System.out.println(solve(list));

        list = Arrays.asList(-251, -323, -253, -53, -215, -143, -107, -161, -179, -431, -449, -17, -341, -413, -35, -125, -197, -377, -269, -71, -359, -89, -233, -287, -395);
        System.out.println(solve(list));

        list = Arrays.asList(-449, -431, -413, -395, -377, -359, -341, -323);
        System.out.println(solve(list));
    }

    private static int solve(final List<Integer> A) {
        //A.sort((x, y) -> Integer.compare(Math.abs(x - 2), y));
        Collections.sort(A);

        System.out.println("After sort : " + A);

        int diff = A.get(0) - A.get(1);

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) - A.get(i + 1) != diff) {
                return 0;
            }
        }

        return 1;
    }
}
