package algoexpert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        System.out.println(threeNumberSum(new int[]{1, 2, 3}, 6));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        final ArrayList<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            int first = array[i];

            int j = i + 1;
            int k = array.length - 1;

            while (j < k) {
                int x = array[j];
                int y = array[k];
                int sum = first + x + y;

                if (sum == targetSum) {
                    result.add(new Integer[]{first, array[j], array[k]});

                    j++;
                    while (j < array.length - 1 && array[j] == x) {
                        result.add(new Integer[]{first, array[j], array[k]});
                        j++;
                    }

                    k--;
                    while (k > i && array[k] == y) {
                        result.add(new Integer[]{first, array[j], array[k]});
                        k--;
                    }
                } else if (sum < targetSum) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
