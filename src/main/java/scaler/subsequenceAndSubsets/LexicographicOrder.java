package scaler.subsequenceAndSubsets;

import java.util.*;

class LexicographicOrder {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(3);

        System.out.println(subsets(A));
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        int size = A.size();
        int totalBinary = (int) Math.pow(2, size);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < totalBinary; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < A.size(); j++) {
                if (((i >> j) & 1) == 1) {
                    temp.add(A.get(j));
                }
            }
            result.add(temp);
        }

        result.sort((ArrayList<Integer> a, ArrayList<Integer> b) -> {
            for (int i = 0; i < a.size() && i < b.size(); i++) {
                if (a.get(i) < b.get(i)) return -1;
                if (a.get(i) > b.get(i)) return 1;
            }
            if (a.size() > b.size()) return 1;
            return -1;
        });
        return result;
    }
}