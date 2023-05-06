package scaler.backTracking;

import java.util.ArrayList;

public class VerticalAndHorizontalSums {
    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C) {

        if (helper(A, B, C, 0, 0)) return 1;

        return 0;

    }

    private boolean isValidArray(ArrayList<Integer> A, int target) {

        int sum = 0;

        for (int i = 0; i < A.size(); i++) {

            sum = 0;
            for (int j = i; j < A.size(); j++) {
                int val = A.get(j);
                if (val > target) {
                    return false;
                }
                sum += val;
                if (sum > target) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid2D(ArrayList<ArrayList<Integer>> B, int C) {
        for (int i = 0; i < B.size(); i++) {
            if (!isValidArray(B.get(i), C)) return false;
        }
        for (int i = 0; i < B.get(0).size(); i++) {
            ArrayList<Integer> colList = new ArrayList<>();
            for (int j = 0; j < B.size(); j++) {
                colList.add(B.get(j).get(i));
            }
            if (!isValidArray(colList, C)) return false;
        }
        return true;
    }

    private boolean helper(int A, ArrayList<ArrayList<Integer>> B, int C, int r, int c) {
        if (isValid2D(B, C)) {
            return true;
        }

        if (A == 0) {
            if (isValid2D(B, C)) {
                return true;
            }
            return false;
        }

        if (c >= B.get(0).size()) {
            r++;
            c = 0;
        }

        if (r >= B.size()) {
            return false;
        }

        B.get(r).set(c, -1 * B.get(r).get(c));
        boolean withoutChange = helper(A - 1, B, C, r, c + 1);// a is the flip count
        if (withoutChange) {
            return true;
        }

        B.get(r).set(c, -1 * B.get(r).get(c));
        boolean withChange = helper(A, B, C, r, c + 1);
        if (withChange) {
            return true;
        }
        return false;
    }
}
