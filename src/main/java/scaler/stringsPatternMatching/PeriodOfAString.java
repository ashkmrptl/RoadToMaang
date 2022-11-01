package scaler.stringsPatternMatching;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
 * Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
 */
public class PeriodOfAString {
    public static void main(String[] args) {
        System.out.println(solve_bruteForce("aaaaaaaa"));
        System.out.println(solve_bruteForce("abcbcbab"));
        System.out.println(solve_bruteForce("abcmkbabcmzla"));
        System.out.println(solve_bruteForce("ababc"));
        System.out.println(solve_bruteForce("abababab"));

        System.out.println("Optimized : ");

        System.out.println(solve("aaaaaaaa"));
        System.out.println(solve("abcbcbab"));
        System.out.println(solve("abcmkbabcmzla"));
        System.out.println(solve("ababc"));
        System.out.println(solve("abababab"));
    }

    private static int solve(String A) {
        int n = A.length();
        if (n == 1)
            return 1;

        int[] Z = findZArray(A);
        for (int i = 1; i < n; i++) {
            if (Z[i] == n - i)
                return i;
        }
        return n;
    }

    private static int[] findZArray(String s) {
        int n = s.length();
        char[] A = s.toCharArray();
        int[] Z = new int[n];

        //For segment
        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {
            if (i > r) {//Current character is not inside segment
                //Apply bruteforce
                int k = 0;
                int j = i;

                while (j < n && A[k] == A[j]) {
                    k++;
                    j++;
                }

                Z[i] = k;
                l = i;
                r = j - 1;
            } else {
                int zCount = Z[i - l];
                int commonElementCount = r - i + 1;

                if (zCount < commonElementCount) {
                    Z[i] = zCount;
                } else {
                    int k = commonElementCount;
                    int j = r + 1;

                    while (j < n && A[k] == A[j]) {
                        k++;
                        j++;
                    }
                    Z[i] = k;
                    l = i;
                    r = j - 1;
                }
            }
        }

        return Z;
    }

    private static int solve_bruteForce(String A) {
        int k = 1;

        while (k <= A.length()) {
            boolean flag = true;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != A.charAt(i % k)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return k;
            } else {
                k++;
            }
        }

        return -1;
    }
}
