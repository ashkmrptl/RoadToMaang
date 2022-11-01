package scaler.stringsPatternMatching;

public class PatternMatchingUsingZAlgo {
    public static void main(String[] args) {
        String string = "mynameisashish";
        String pattern = "mei";

        System.out.println(solve(string, pattern));
    }

    /**
     * Steps:
     * Step 1: add the pattern as the prefix to the given string with some delimiter
     * Step 2: Find the new string's Z array
     * Step 3: Iterate through the Z array and check if any element with the length of the given pattern,
     * If length matches return true, else return false;
     */
    private static boolean solve(String string, String pattern) {
        String mergedString = pattern + "$" + string;
        int n = mergedString.length();
        int m = pattern.length();

        int[] z = findZArray(mergedString);

        for (int i = 0; i < n; i++) {
            if (z[i] == m) {
                return true;
            }
        }

        return false;
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
