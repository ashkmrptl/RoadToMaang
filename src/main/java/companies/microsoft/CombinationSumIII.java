package companies.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(2, 18));

        System.out.println(combinationSum3(3, 9));

        System.out.println(combinationSum3(4, 1));
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(k, n, 1, new HashSet<>(), ans);

        return ans;
    }

    private static void backtrack(int k, int n, int start, Set<Integer> current, List<List<Integer>> ans) {
        if (n < 0) {
            return;
        }

        if (k == current.size()) {
            if (n == 0) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; ++i) {
            current.add(i);
            backtrack(k, n - i, i + 1, current, ans);
            current.remove(i);
        }
    }
}
