package scaler.stringsPatternMatching;

import java.util.Arrays;

/**
 * Given a String, find its associated Z Array
 */
public class FindZArray {
    public static void main(String[] args) {
        String string = "xxyzxxyzwxxyzxxyzx";
        System.out.println(Arrays.toString(solve(string)));

        string = "abxgthasbabxabxgthasbagtyaaababxy";
        System.out.println(Arrays.toString(solve(string)));
    }

    private static int[] solve(final String s) {
        int n = s.length();
        char[] A = s.toCharArray();

        int[] Z = new int[n];

        //Define segment
        int left = 0;
        int right = 0;

        //We don't find the count for 1st character as it is always same as the length of the array and it is of no use
        for (int i = 1; i < n; i++) {
            if (i > right) {//The current element is outside segment
                //Use bruteforce to find the count
                int k = 0;
                int j = i;
                while (j < n && A[k] == A[j]) {
                    k++;
                    j++;
                }
                Z[i] = k;//the char matches from 0 to k - 1, so length is ((k - 1) - 0 + 1) which is k

                //For bruteforce update the sequence
                left = i;
                right = j - 1;// Because the loop stops when the characters doesn't match(hence j - 1 and not j)
            } else { //Current character is inside segment
                int zElement = Z[i - left];
                int noOfCommonElements = right - i + 1;

                if (zElement < noOfCommonElements) {//trust the Bog brother and copy blindly
                    Z[i] = zElement;
                } else {//Apply bruteforce form the index after common element
                    int k = noOfCommonElements;
                    int j = right + 1;
                    while (j < n && A[k] == A[j]) {
                        j++;
                        k++;
                    }
                    Z[i] = k;
                    //Update the segment
                    left = i;
                    right = j - 1;
                }
            }
        }

        return Z;
    }
}
