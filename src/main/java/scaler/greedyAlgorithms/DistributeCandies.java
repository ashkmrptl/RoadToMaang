package scaler.greedyAlgorithms;

/**
 * N children are standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum number of candies you must give?
 */
public class DistributeCandies {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 2, 1};
        System.out.println(candy(A));

        A = new int[]{1, 2};
        System.out.println(candy(A));
    }

    private static int candy(int[] A) {
        int totalCandies = 0;

        final int[] candies = new int[A.length];

        //Give 1 candy to each student
        for (int i = 0; i < A.length; i++) {
            candies[i] = 1;
        }

        //Start from left to right
        for (int i = 1; i < A.length; i++) {//Skipping A[0] as it has no left neighbour
            if (A[i] > A[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        //Start from right to left
        for (int i = A.length - 2; i >= 0; i--) {//Skipping A[A.length - 1] as it has no right neighbour
            if (A[i] > A[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);//candies[i + 1] + 1;
            }
        }

        for (int i = 0; i < A.length; i++) {
            totalCandies += candies[i];
        }

        return totalCandies;
    }
}
