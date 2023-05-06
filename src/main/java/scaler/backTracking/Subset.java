package scaler.backTracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a set of distinct integers A, return all possible subsets.
 * <p>
 * NOTE:
 * <p>
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 */
public class Subset {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        System.out.println(solve(A));
    }

    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        Collections.sort(A);

        final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        final ArrayList<Integer> subSet = new ArrayList<>();

        findSubset(0, A.size(), A, subSet, ans);

        return ans;
    }

    private static void findSubset(int i, int n, ArrayList<Integer> A, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> subsets) {
        if (i == n) {
            return;
        }

        //pick ith element
        subSet.add(A.get(i));
        subsets.add(new ArrayList<>(subSet));
        findSubset(i + 1, n, A, subSet, subsets);

        //don't pick ith element
        subSet.remove(subSet.size() - 1);
        findSubset(i + 1, n, A, subSet, subsets);

    }
}
