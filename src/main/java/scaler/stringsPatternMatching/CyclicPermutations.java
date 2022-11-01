package scaler.stringsPatternMatching;

public class CyclicPermutations {
    public static void main(String[] args) {
        String A = "1001";
        String B = "0011";

        System.out.println(solve(A, B));
    }

    private static int solve(String A, String B) {
        B = B + B;
        String str = A + "$" + B.substring(0, B.length() - 1);

        int[] Z = findZArray(str);

        int count = 0;
        for (int i = A.length() + 1; i < str.length(); i++) {
            if (Z[i] == A.length()) {
                count++;
            }
        }

        return count;
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
}
