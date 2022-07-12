package scaler.array;

/**
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the length of the longest consecutive 1’s that can be achieved.
 * Constraints
 *
 * 1 <= length of string <= 1000000
 * A contains only characters 0 and 1.
 * For Example
 *
 * Input 1:
 *     A = "111000"
 * Output 1:
 *     3
 *
 * Input 2:
 *     A = "111011101"
 * Output 2:
 *     7
 */
public class LengthOfLongestConsecutiveOnes {
    public static void main(String[] args) {
        final String A = "11110000100111000101110010111101";

        System.out.println(solve(A));
    }

    public static int solve(String A) {
        int result = 0;
        int n = A.length();
        int noOfOnes = 0;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                noOfOnes++;
            }
        }

        if (n == noOfOnes) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                //Count ones on the left till a zero is found or start is reached
                int leftCount = countLeftOnes(0, i - 1, A);

                //Count ones on the left till a zero is found or end is reached
                int rightCount = countRightOnes(i + 1, n - 1, A);

                if (noOfOnes == (leftCount + rightCount)) {
                    result = Math.max(result, (leftCount + rightCount));
                } else {
                    result = Math.max(result, (leftCount + rightCount + 1));
                }
            }
        }

        return result;
    }

    private static int countLeftOnes(int start, int end, String A) {
        int count = 0;
        for (int i = end; i >= 0 && A.charAt(i) == '1'; i--) {
            count++;
        }
        return count;
    }

    private static int countRightOnes(int start, int end, String A) {
        int count = 0;
        for (int i = start; i <= end && A.charAt(i) == '1'; i++) {
            count++;
        }
        return count;
    }
}
