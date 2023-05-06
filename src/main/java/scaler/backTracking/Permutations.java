package scaler.backTracking;

import java.util.ArrayList;

/**
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 * <p>
 * NOTE:
 * <p>
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 */
public class Permutations {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        System.out.println(solve(A));
    }

    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        findPermutations(0, A.size(), A, result);

        return result;
    }

    private static void findPermutations(int i, int n, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result) {
        if (i == n) {
            result.add(new ArrayList<>(A));
            return;
        }

        for (int j = i; j < n; j++) {
            swap(i, j, A);
            findPermutations(i + 1, n, A, result);
            swap(j, i, A);
        }
    }

    private static void swap(int i, int j, ArrayList<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
