package scaler.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array A of size N.
 * Find the length of the longest set of consecutive elements from array A.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] A = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(solve(A));

        A = new int[]{2, 1, 1, 1, 2};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int ans = 1;

        final Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }

        for (int num : set) {
            int length = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    length++;
                    num++;
                }
                ans = Math.max(ans, length);
            }
        }

        return ans;
    }
}
