package scaler.arraysSorting;

import java.util.Arrays;

/**
 * Problem Description
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 2*105
 * 1 <= A[i] <= 107
 * <p>
 * Input Format
 * First and only argument is an integer array A.
 * <p>
 * Output Format
 * Return 1 if any such integer p is present else, return -1.
 * <p>
 * Example Input
 * Input 1:
 * A = [3, 2, 1, 3]
 * Input 2:
 * A = [1, 1, 3, 3]
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * -1
 * <p>
 * Example Explanation
 * Explanation 1:
 * For integer 2, there are 2 greater elements in the array..
 * Explanation 2:
 * There exist no integer satisfying the required conditions.
 */
public class NobleInteger {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 3};
        System.out.println(solve(A));

        A = new int[] {3, 2, 1, 3, 3};
        System.out.println(solve(A));

        A = new int[] {3, 2, 1, 4, 4, 4};
        System.out.println(solve(A));
    }

    private static int solve(final int[] A) {
        int count = 1;
        int n = A.length;
        Arrays.sort(A);

        if (A[n - 1] == 0) {
            return 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if ((A[i] != A[i + 1]) && (A[i] == count)) {
                return 1;
            }
            count++;
        }
        return -1;
    }
}
