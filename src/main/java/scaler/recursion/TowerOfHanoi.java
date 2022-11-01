package scaler.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solve(2)));
        System.out.println(Arrays.deepToString(solve(3)));
        System.out.println(Arrays.deepToString(solve(4)));
    }

    private static int[][] solve(int A) {
        List<List<Integer>> result = new ArrayList<>();
        towerOfHanoi(A, 1, 3, 2, result);

        int[][] res = new int[result.size()][result.get(0).size()];
        for (int j = 0; j < result.size(); j++) {
            List<Integer> list = result.get(j);
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            res[j] = arr;
        }

        return res;
    }

    private static void towerOfHanoi(int n, int src, int dest, int mid, List<List<Integer>> result) {
        if (n == 0) {
            return;
        }

        towerOfHanoi(n - 1, src, mid, dest, result);
        //System.out.println(n + " : " + src + " -> " + dest);
        result.add(List.of(n, src, dest));
        towerOfHanoi(n - 1, mid, dest, src, result);
    }
}
