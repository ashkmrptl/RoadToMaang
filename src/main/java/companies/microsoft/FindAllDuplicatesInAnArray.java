package companies.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[] {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    private static List<Integer> findDuplicates(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        final Set<Integer> ans = new HashSet<>();

        for (final int num: nums) {
            if(set.contains(num)) {
                ans.add(num);
            } else {
                set.add(num);
            }
        }

        return new ArrayList<>(ans);
    }
}
