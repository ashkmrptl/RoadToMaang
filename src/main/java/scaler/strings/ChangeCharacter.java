package scaler.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * You are given a string A of size N consisting of lowercase alphabets.
 * You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
 * Find the minimum number of distinct characters in the resulting string.
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= B < N
 * <p>
 * Input Format
 * The first argument is a string A.
 * The second argument is an integer B.
 * <p>
 * Output Format
 * Return an integer denoting the minimum number of distinct characters in the string.
 * <p>
 * Example Input
 * A = "abcabbccd"
 * B = 3
 * <p>
 * Example Output
 * 2
 * <p>
 * Example Explanation
 * We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
 * So the minimum number of distinct character will be 2.
 */
public class ChangeCharacter {
    public static void main(String[] args) {
        String A = "abcabbccd";
        int B = 3;
        System.out.println(solve(A, B));
    }

    private static int solve(String A,int B) {
        //Sort the array based upon count
        char[] array = A.toCharArray();

        int[] countArray = new int[26];

        for (int i = 0; i < array.length; i++) {
            int index = array[i] % 97;
            countArray[index] += 1;
        }
        Arrays.sort(countArray);

        //System.out.println(Arrays.toString(countArray));

        int i = 0;
        while (countArray[i] == 0) {
            i++;
        }

        while (B > 0) {
            int temp = countArray[i];
            countArray[i] -= B;
            B = B - temp;
            i++;
        }

        int count = 0;
        for (int j = 0; j < 26; j++) {
            if (countArray[j] > 0) {
                count++;
            }
        }

        return count;
    }
}
