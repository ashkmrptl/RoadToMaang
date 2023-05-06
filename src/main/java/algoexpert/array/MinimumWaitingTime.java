package algoexpert.array;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        int[] queries = new int[] {1, 4, 5, 6};

        System.out.println(solve(queries));
    }

    private static int solve(int[] queries) {
        Arrays.sort(queries);

        int res = 0;
        int ans = 0;

        for (int i = 1; i < queries.length; i++) {
            ans = ans + queries[i - 1];
            res += ans;
        }

        return res;
    }
}
