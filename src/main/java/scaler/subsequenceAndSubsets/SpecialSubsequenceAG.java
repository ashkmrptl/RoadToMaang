package scaler.subsequenceAndSubsets;

/**
 * You have given a string A having Uppercase English letters.
 * <p>
 * You have to find how many times subsequence "AG" is there in the given string.
 * <p>
 * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 */
public class SpecialSubsequenceAG {
    public static void main(String[] args) {
        String s = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";
        System.out.println(solve(s));
        System.out.println(solve(s));
    }

    private static int solveOptimized(String A) {
        long count = 0;
        long countOfG = 0;

        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == 'G') {
                countOfG++;
            } else if (A.charAt(i) == 'A') {
                count += countOfG;
            }
        }

        return (int) (count % 1000000007);
    }

    private static int solve(String A) {
        char[] arr = A.toCharArray();
        long count = 0;

        long noOfGs = 0;

        for (char c : arr) {
            if (c == 'G') {
                noOfGs++;
            }
        }

        for (char c : arr) {
            if (c == 'G') {
                noOfGs--;
                continue;
            }

            if (c == 'A') {
                count += noOfGs;
            }
        }

        return (int) (count % 1000000007);
    }
}
