package scaler.greedyAlgorithms;

/**
 * The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values.
 * The values used are:
 *  1, 5, 25, 125, 625, 3125, 15625, ...
 * Formally, for each K >= 0 there are coins worth 5K.
 * Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly
 * the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).
 */
public class AnotherCoinProblem {
    public static void main(String[] args) {
        System.out.println(solve(47));
        System.out.println(solve(9));
        System.out.println(solve(35));
    }

    private static int solve(int A) {
        ans = 0;
        solveRec(A);
        return ans;
    }

    static int ans = 0;

    private static void solveRec(int A) {
        if (A == 0) {
            return;
        }
        int k = 0;

        while (Math.pow(5, k) <= A) {
            k++;
        }

        ans++;

        solveRec((int) (A - Math.pow(5, k - 1)));
    }

}
