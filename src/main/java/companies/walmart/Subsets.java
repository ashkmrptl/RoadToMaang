package companies.walmart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 * (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
        System.out.println(subsets_copied(nums));

        nums = new int[]{1};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets_copied(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(new ArrayList<>()));

        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>(res);
            for (List<Integer> e : tmp) {
                List<Integer> newList = new ArrayList<>(e);
                newList.add(num);
                res.add(newList);
            }
        }
        return res;
    }

    private static List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> answer = new ArrayList<>();
        recurse(nums, 0, answer, new ArrayList<>());
        return answer;
    }

    private static void recurse(int[] nums, int index, List<List<Integer>> answer, List<Integer> subset) {
        answer.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            recurse(nums, i + 1, answer, subset);
            subset.remove(subset.size() - 1);
        }
    }

}
