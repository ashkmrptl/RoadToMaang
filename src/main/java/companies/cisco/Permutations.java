package companies.cisco;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> permutations = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), permutations);

        return permutations;
    }

    private static void backtrack(int[] nums, List<Integer> permutation, List<List<Integer>> permutations) {
        if (nums.length == permutation.size()) {
            permutations.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 11) {
                    int temp = nums[i];
                    permutation.add(temp);
                    nums[i] = 11;//Update no to 11(11 because range of numbers is from -10 to 10) to mark as visited
                    backtrack(nums, permutation, permutations);
                    nums[i] = temp;//Update back to original number
                    permutation.remove(permutation.size() - 1);
                }
            }
        }
    }
}
