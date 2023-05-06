package companies.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array "nums" of distinct integers, return all the possible permutations. Answer can be returned in any order.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> answer = new ArrayList<>();

        recurse(nums, new ArrayList<>(), answer);

        return answer;
    }

    private static void recurse(int[] nums, List<Integer> permutation, List<List<Integer>> answer) {
        if (nums.length == permutation.size()) {
            answer.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 11) {
                    int temp = nums[i];
                    permutation.add(temp);
                    nums[i] = 11;
                    recurse(nums, permutation, answer);
                    nums[i] = temp;
                    permutation.remove(permutation.size() - 1);
                }
            }
        }

    }
}
