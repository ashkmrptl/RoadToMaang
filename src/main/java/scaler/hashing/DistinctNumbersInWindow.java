package scaler.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * NOTE: if B > N, return an empty array.
 */
public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 1, 3, 4, 3};
        int B = 3;

        System.out.println(Arrays.toString(solve(A, B)));

        A = new int[]{1, 1, 2, 2};
        B = 1;

        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(int[] A, int B) {
        int[] res = new int[A.length - B + 1];

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        res[0] = map.size();

        int i = 1;
        int start = 1;
        int end = start + B - 1;

        while (end < A.length) {
            //Element removed
            int count = map.get(A[start - 1]) - 1;
            if (count == 0) {
                map.remove(A[start - 1]);
            } else {
                map.put(A[start - 1], count);
            }

            //Element added
            if (map.containsKey(A[end])) {
                map.put(A[end], map.get(A[end]) + 1);
            } else {
                map.put(A[end], 1);
            }

            res[i] = map.size();
            i++;
            start++;
            end++;
        }


        return res;
    }
}
