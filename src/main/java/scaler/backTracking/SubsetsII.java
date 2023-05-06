package scaler.backTracking;

import java.util.*;

public class SubsetsII {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);

        System.out.println(solve(A));

        A = new ArrayList<>();
        A.add(1);
        A.add(1);

        System.out.println(solve(A));

        A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        System.out.println(solve(A));
    }

    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        Collections.sort(A);

        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        final Set<ArrayList<Integer>> freq = new HashSet<>();

        subsetsWithDup(result, A, 0, new ArrayList<>(), freq);

        return result;
    }

    private static void subsetsWithDup(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> A, int index,
                                       ArrayList<Integer> subset, Set<ArrayList<Integer>> freq) {
        if (!freq.contains(subset)) {
            final ArrayList<Integer> temp = new ArrayList<>(subset);
            result.add(temp);
            freq.add(temp);
        }

        for (int i = index; i < A.size(); i++) {
            subset.add(A.get(i));
            subsetsWithDup(result, A, i + 1, subset, freq);
            subset.remove(subset.size() - 1);
        }
    }
}
