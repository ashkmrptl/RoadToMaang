package scaler.stringsPatternMatching;

/**
 * Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
 * Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.
 */
public class SmallestPrefixString {
    public static void main(String[] args) {
        //System.out.println(solve("abba", "cdd"));
        //System.out.println(solve("acd", "bay"));
        System.out.println(solve("tom", "riddle"));
    }

    private static String solve(String A, String B) {
        StringBuilder ans = new StringBuilder();
        ans.append(A.charAt(0));
        int i = 1;
        char bVal = B.charAt(0);
        while (i < A.length() && A.charAt(i) <= bVal) {
            ans.append(A.charAt(i));
            if (A.charAt(i) == bVal) {
                return ans.toString();
            }
            i++;
        }
        ans.append(bVal);
        return ans.toString();
    }
}
