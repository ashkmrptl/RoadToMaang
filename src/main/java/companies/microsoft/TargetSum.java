package companies.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    private static int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0, 0, new HashMap<>());
    }

    private static int backtrack(int[] nums, int target, int index, int sum, final Map<Pair, Integer> dpMap) {
        //Base case
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        final Pair pair = new Pair(index, sum);

        //Check in DP map
        if (dpMap.containsKey(pair)) {
            return dpMap.get(pair);
        }

        //recursion
        int num = backtrack(nums, target, index + 1, sum + nums[index], dpMap) +
                backtrack(nums, target, index + 1, sum - nums[index], dpMap);
        dpMap.put(pair, num);

        return num;
    }

    private static class Pair {
        int index;
        int total;

        public Pair(int index, int total) {
            this.index = index;
            this.total = total;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index && total == pair.total;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, total);
        }
    }
}
