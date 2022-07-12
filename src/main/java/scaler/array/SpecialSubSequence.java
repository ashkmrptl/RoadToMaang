package scaler.array;

/**
 * You have given a string A having Uppercase English letters.
 * You have to find how many times subsequence "AG" is there in the given string.
 * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 * <p>
 * Problem Constraints
 * 1 <= length(A) <= 105
 * <p>
 * Input Format
 * First and only argument is a string A.
 * <p>
 * Output Format
 * Return an integer denoting the answer.
 * <p>
 * Example Input
 * Input 1:
 * A = "ABCGAG"
 * <p>
 * Input 2:
 * A = "GAB"
 * <p>
 * Example Output
 * Output 1:
 * 3
 * <p>
 * Output 2:
 * 0
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Subsequence "AG" is 3 times in given string
 * Explanation 2:
 * <p>
 * There is no subsequence "AG" in the given string.
 */
public class SpecialSubSequence {
    public static void main(String[] args) {
        final String s = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";
        System.out.println("Total no of 'AG' pairs = " + countPairsByBruteForceApproach(s.toCharArray()));
        System.out.println("Total no of 'AG' pairs optimized = " + countPairsOptimizedApproach(s.toCharArray()));
    }

    /**
     * In this approach we find all the possible pairs the take the count.
     * <p>
     * The TC here is O(n^2)
     *
     * @param array input char array
     * @return count of matching pairs
     */
    private static int countPairsByBruteForceApproach(final char[] array) {
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != 'A') {
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == 'G') {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * In this approach we iterate from n-1 to i, keep track of count of G. Then whenever A is encountered we increase the total count
     * by no of G already found.
     *
     * TC is O(n)
     *
     * @param array input char array
     * @return count of matching pairs
     */
    private static int countPairsOptimizedApproach(final char[] array) {
        int count = 0;
        int countOfG = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 'G') {
                countOfG++;
            } else if (array[i] == 'A') {
                count += countOfG;
            }
        }

        return (int) (count % (Math.pow(10, 9) + 7));
    }
}
