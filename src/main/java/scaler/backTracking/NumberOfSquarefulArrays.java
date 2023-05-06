package scaler.backTracking;

import java.util.*;

public class NumberOfSquarefulArrays {
    public static void main(String[] args) {
        int[] A = {1, 17, 8};

        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : A) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }

        final List<List<Integer>> answer = new ArrayList<>();

        findPermutations(0, A.length, frequency, answer, new ArrayList<>());

        return answer.size();
    }

    private static void findPermutations(int i, int n, Map<Integer, Integer> frequency, List<List<Integer>> answer, List<Integer> permutation) {
        if (i == n) {
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() != 0) {
                if (i > 0 && !isPerfectSquare(permutation.get(i - 1) + entry.getKey())) {
                    continue;
                }
                permutation.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                findPermutations(i + 1, n, frequency, answer, permutation);
                permutation.remove(permutation.size() - 1);
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

    private static boolean isPerfectSquare(int x) {
        if (x >= 0) {
            int sr = (int) Math.sqrt(x);
            return ((sr * sr) == x);
        }
        return false;
    }
}
