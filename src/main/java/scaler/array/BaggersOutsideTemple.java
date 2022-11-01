package scaler.array;

import java.util.Arrays;

/**
 * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
 * Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
 * For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B
 * <p>
 * Problem Constraints
 * 1 <= A <= 2 * 105
 * 1 <= L <= R <= A
 * 1 <= P <= 103
 * 0 <= len(B) <= 105
 * <p>
 * Input Format
 * The first argument is a single integer A.
 * The second argument is a 2D integer array B.
 * <p>
 * Output Format
 * Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
 * <p>
 * Example Input
 * Input 1:-
 * A = 5
 * B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 * <p>
 * Example Output
 * Output 1:-
 * 10 55 45 25 25
 * <p>
 * Example Explanation
 * Explanation 1:-
 * First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
 * Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
 * Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 */
public class BaggersOutsideTemple {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};

        System.out.println(Arrays.toString(solve(A, B)));
        System.out.println(Arrays.toString(solveForInitialArrayWithSomeValue(new int[]{1, 1, 1, 1, 1}, B)));
    }

    // Solution when the initial array has all elements as ZERO
    private static int[] solve(int A, int[][] B) {
        int[] result = new int[A];

        for (int i = 0; i < B.length; i++) {
            int left = B[i][0] - 1;
            int right = B[i][1] - 1;
            int value = B[i][2];

            result[left] += value;

            if (right + 1 < A) {
                result[right + 1] -= value;
            }
        }

        for (int i = 1; i < A; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }

    //This uses a temp array, hence SC is O(n)
    private static int[] solveForInitialArrayWithSomeValue(int[] A, int[][] B) {
        int[] tempArray = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            int left = B[i][0] - 1;
            int right = B[i][1] - 1;
            int value = B[i][2];

            tempArray[left] += value;

            if (right + 1 < A.length) {
                tempArray[right + 1] -= value;
            }
        }

        A[0] += tempArray[0];

        for (int i = 1; i < A.length; i++) {
            tempArray[i] += tempArray[i - 1];
            A[i] += tempArray[i];
        }

        return A;
    }

    //Here we're not using extra space
    private static int[] solveForInitialArrayWithSomeValueOptimized(int[] A, int[][] B) {

        for (int i = 0; i < B.length; i++) {
            int left = B[i][0] - 1;
            int right = B[i][1] - 1;
            int value = B[i][2];

            if (left + 1 < A.length) {
                A[left + 1] -= A[left];
            }
            A[left] += value;

            if (right + 1 < A.length) {
                A[right + 1] -= value;
            }
        }

        A[0] += A[0];

        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
            A[i] += A[i];
        }

        return A;
    }
}
