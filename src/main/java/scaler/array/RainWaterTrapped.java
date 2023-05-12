package scaler.array;

/**
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * Input Format
 * First and only argument is the vector A
 * <p>
 * Output Format
 * Return one integer, the answer to the question
 * <p>
 * Example Input
 * Input 1:
 * A = [0, 1, 0, 2]
 * Input 2:
 * A = [1, 2]
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 * <p>
 * Example Explanation
 * Explanation 1:
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 * No water is trapped.
 */
public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 0, 2};
        System.out.println(solve(A));
        System.out.println(solveUsingOneArray(A));
    }

    private static int solveUsingOneArray(int[] A) {
        int sum = 0;

        //Construct right max array
        int[] rm = new int[A.length];
        rm[A.length - 1] = A[A.length - 1];

        for (int i = A.length - 2; i >= 0; i--) {
            rm[i] = Math.max(A[i], rm[i + 1]);
        }

        //We will construct the left max array on the fly
        int lm = A[0];

        for (int i = 1; i < A.length - 1; i++) {
            sum += Math.max((Math.min(lm, rm[i]) - A[i]), 0);
            lm = Math.max(lm, A[i]);
        }

        return sum;
    }

    //This approach uses left max and right max array. Hence, it takes SC as O(n). TC is O(n). This can be solved in O(1) SC using two pointers approach
    private static int solve(int[] A) {
        int sum = 0;

        //Construct left max array
        int[] lm = new int[A.length];
        lm[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            lm[i] = Math.max(lm[i - 1], A[i]);
        }

        //Construct right max array
        int[] rm = new int[A.length];
        rm[A.length - 1] = A[A.length - 1];

        for (int i = A.length - 2; i >= 0; i--) {
            rm[i] = Math.max(A[i], rm[i + 1]);
        }

        for (int i = 1; i < A.length - 1; i++) {
            sum += Math.min(lm[i], rm[i]) - A[i];
        }

        return sum;
    }
}
