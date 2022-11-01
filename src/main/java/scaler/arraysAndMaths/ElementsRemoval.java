package scaler.arraysAndMaths;

/**
 * Given an integer array A of size N. You can remove any element from the array in one operation.
 * The cost of this operation is the sum of all elements in the array present before this operation.
 * <p>
 * Find the minimum cost to remove all elements from the array.
 * <p>
 * Problem Constraints
 * 0 <= N <= 1000
 * 1 <= A[i] <= 103
 * <p>
 * Input Format
 * First and only argument is an integer array A.
 * <p>
 * Output Format
 * Return an integer denoting the total cost of removing all elements from the array.
 * <p>
 * Example Input
 * Input 1:
 * A = [2, 1]
 * Input 2:
 * A = [5]
 * <p>
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * 5
 * <p>
 * Example Explanation
 * Explanation 1:
 * Given array A = [2, 1]
 * Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
 * Remove 1 from the array => []. Cost of this operation is (1) = 1.
 * So, total cost is = 3 + 1 = 4.
 * Explanation 2:
 * There is only one element in the array. So, cost of removing is 5.
 */
public class ElementsRemoval {
    public static void main(String[] args) {
        final int[] A = new int[] {1, 2};
        System.out.println(solve(A));
    }

    /**
     * Approach :
     *      Let's say the array is [a, b, c, d]
     *      So cost for removing elements is a below:
     *      a = a + b + c + d
     *      b =     b + c + d
     *      c =         c + d
     *      d =             d
     *      ------------------
     *      total cost = a + 2b + 3c + 4d
     *
     *      This can be written as cost = cost + ((i + 1) * A[i])
     */
    private static int solve(final int[] A) {
        int cost = 0;

        for (int i = 0; i < A.length; i++) {
            cost += (i + 1) * A[i];
        }

        return cost;
    }
}
