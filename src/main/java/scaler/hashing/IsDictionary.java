package scaler.hashing;

import java.util.Comparator;

/**
 * Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
 * <p>
 * Problem Constraints
 * 1 <= N, length of each word <= 105
 * Sum of the length of all words <= 2 * 106
 * <p>
 * Input Format
 * The first argument is a string array A of size N.
 * The second argument is a string B of size 26, denoting the order.
 * <p>
 * Output Format
 * Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
 * <p>
 * Example Input
 * Input 1:
 * A = ["hello", "scaler", "interviewbit"]
 * B = "adhbcfegskjlponmirqtxwuvzy"
 * Input 2:
 * A = ["fine", "none", "no"]
 * B = "qwertyuiopasdfghjklzxcvbnm"
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 * <p>
 * Example Explanation
 * Explanation 1:
 * The order shown in string B is: h < s < i for the given words. So return 1.
 * Explanation 2:
 * "none" should be present after "no". Return 0.
 */
public class IsDictionary {
    public static void main(String[] args) {
        String[] A = new String[]{"hello", "scaler", "interviewbit"};
        String B = "adhbcfegskjlponmirqtxwuvzy";
        System.out.println(solve(A, B));

        A = new String[]{"fine", "none", "no"};
        B = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(solve(A, B));
    }

    private static int solve(final String[] A, final String B) {
        for (int i = 0; i < A.length - 1; i++) {
            if (!checkIfLexicographical(A[i], A[i + 1], B)) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean checkIfLexicographical(String s1, String s2, String B) {
        int n = Math.min(s1.length(), s2.length());

        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            int idx1 = B.indexOf(ch1);
            int idx2 = B.indexOf(ch2);

            if (idx1 < idx2) {
                return true;
            } else if (idx1 > idx2) {
                return false;
            }
        }

        if (s1.length() < s2.length() || s1.length() == s2.length()) {
            return true;
        } else {
            return false;
        }
    }
}
