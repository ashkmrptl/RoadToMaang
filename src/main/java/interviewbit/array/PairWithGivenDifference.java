package interviewbit.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairWithGivenDifference {
    public static void main(String[] args) {
        int[] A = new int[]{5, 1, 3, 6, 8, 4, 1};
        int B = 2;

        System.out.println(countPairsWithGivenDifference(A, B));
        printPairsWithGivenSum(A, B);
    }

    private static void printPairsWithGivenSum(final int[] A, final int B) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                System.out.println((A[i] + B) + " " + A[i]);
            }
            set.add(A[i] - B);
        }
    }

    private static int countPairsWithGivenDifference(final int[] A, final int B) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                count++;
            }
            map.put(A[i] - B, 0);

        }

        return count;
    }
}
