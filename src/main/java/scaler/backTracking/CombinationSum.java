package scaler.backTracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(6);
        A.add(7);

        System.out.println(combinationSum(A, 7));
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        //Sort the array first it reduces the sorting required before returning the list.
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (A.size() == 0) {
            return list;
        }

        combinationSum(0, 0, A, B, new ArrayList<>(), list);
        return list;
    }

    private static void combinationSum(int index, int sum, ArrayList<Integer> A, int B, ArrayList<Integer> out, ArrayList<ArrayList<Integer>> list) {
        //Returns if sum exceeds the target value
        if (sum > B) {
            return;
        }
        if (sum == B) {
            //Check if the list already present don't add it again, duplicates lists can come because input list can have duplicate elements
            if (!list.contains(out))
                list.add(new ArrayList<>(out));
            return;
        }

        for (int i = index; i < A.size(); i++) {
            out.add(A.get(i));
            //Don't need to increase the index here as we need all possible sum even if the value is counted multiple times.
            combinationSum(i, sum + A.get(i), A, B, out, list);
            out.remove(out.size() - 1);
        }
    }

}
