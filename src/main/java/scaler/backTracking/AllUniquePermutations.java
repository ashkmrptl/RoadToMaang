package scaler.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * NOTE: No 2 entries in the permutation sequence should be the same.
 */
public class AllUniquePermutations {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(1);
        A.add(2);

        System.out.println(solve(A));
    }

    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        final Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : A) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }

        findPermutations(0, A.size(), A, frequency, result);

        return result;
    }

    private static void findPermutations(int i, int n, ArrayList<Integer> A, Map<Integer, Integer> frequency, ArrayList<ArrayList<Integer>> result) {
        if (i == n) {
            result.add(new ArrayList<>(A));
            //System.out.println(A);
            return;
        }

        for (final Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            if (entry.getValue() != 0) {
                A.set(i, entry.getKey());
                entry.setValue(entry.getValue() - 1);
                findPermutations(i + 1, n, A, frequency, result);
                entry.setValue(entry.getValue() + 1);
            }
        }
    }
}
