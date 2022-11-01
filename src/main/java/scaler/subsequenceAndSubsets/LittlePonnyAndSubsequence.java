package scaler.subsequenceAndSubsets;

/**
 * Problem Description
 * <p>
 * Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
 * A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example,
 * "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * A only contains lowercase alphabets.
 * <p>
 * Input Format
 * The first and the only argument of input contains the string, A.
 * Output Format
 * Return a string representing the answer.
 * Example Input
 * <p>
 * Input 1:
 * A = "abcdsfhjagj"
 * Input 2:
 * A = "ksdjgha"
 * <p>
 * Example Output
 * Output 1:
 * "aa"
 * Output 2:
 * "da"
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * "aa" is the lexicographically minimum subsequence from A.
 * Explanation 2:
 * "da" is the lexicographically minimum subsequence from A.
 */
public class LittlePonnyAndSubsequence {
    public static void main(String[] args) {
        String A = "zxdfoxxxzsszzshhhxhhdxxodhodffxxxxshhozzofhzhdhfoddohzofdsxhddszhhofdxdsfsdszsdxzzfodzoshsdxdsfssoxsofxhszzfffozsfzxzxhsdsxdzoosdofoxdzxhozfdzfhofzhddzfsdfzhxoxohxddhxfxhszfhdsfhfxzzhozxdoshzsfszshdfxsfffxfsososxoshxszzzdzxzdhdxxosfxzxodhdhhsoxoxfxfsdxhzfzhozxzxfhdsofxzffhzzdzdsoxhfzxzzofdfffohzdfszhdhhzdzhzoooxxfhfshofddhxdhfzfhozsfzsszodzzfdfssdxxfxoszzfxdsfzxzofsofosxhsohohszxxodfhhsozshxzsfzdddhhdhfxhfszohdozzosfozxxzoxoxdshxxfsszzodfzdsohfzodzoxoosdhosfxhsxxhzozddffhdodfosdzdxxdfdxhsdszszdofzfdoszzffdshdsxsdsfosoxdzdzzfxxdhdzxzdozhsdzofhfszxoxhzhhhzzfoxsc";
        System.out.println(solveOptimized(A));
    }

    private static String solveOptimized(String A) {
        char a = A.charAt(0);
        char b = A.charAt(1);

        int i = 2;

        while (i < A.length()) {
            if (b < a) {
                a = b;
                b = A.charAt(i);
            } else if (A.charAt(i) < b) {
                b = A.charAt(i);
            }
            i++;
        }

        return ""+a+b;
    }

    private static String solve(String A) {
        int n = A.length();
        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < Math.pow(2, n); i++) {
            StringBuilder subString = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subString.append(A.charAt(j));
                    if (subString.length() > minLength) {
                        break;
                    }
                }
            }
            System.out.println("----------- " + subString);

            boolean isSmall = true;
            if (subString.length() >= 2) {
                int j = 0;
                while (j < subString.length()) {
                    if (subString.charAt(j) > A.charAt(j)) {
                        isSmall = false;
                        break;
                    }
                    j++;
                }
            } else {
                isSmall = false;
            }

            //System.out.println("subString : " + subString + " isSmall : " + isSmall + " minLength : " + minLength);

            if (subString.toString().equals("cb")) {
                System.out.println();
            }

            if (isSmall && !subString.isEmpty() && subString.length() <= minLength) {
                if (subString.length() == minLength) {
                    if(subString.toString().compareTo(result) < 0) {
                        minLength = subString.length();
                        result = subString.toString();
                    }
                } else {
                    minLength = subString.length();
                    result = subString.toString();
                }
            }
        }

        return result;
    }
}
