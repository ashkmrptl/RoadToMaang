package scaler.contest.contest2;

import java.util.HashMap;
import java.util.Map;

public class BricksAndWall {
    public static void main(String[] args) {
        int A = 2;
        int B = 7;
        int[] C = new int[]{3, 4, 2, 2, 3};

        System.out.println(solve(A, B, C));

        A = 6;
        B = 8;
        C = new int[]{7, 1, 7, 1, 7, 1, 7, 1, 7, 1, 7, 1};

        System.out.println(solve(A, B, C));

        A = 12;
        B = 8;
        C = new int[]{7, 1, 6, 1, 1, 5, 1, 1, 1, 1, 1, 3, 2, 1, 5, 2, 1, 8, 3, 3, 2, 1, 2, 4, 1, 3, 2, 3, 4, 3, 1, 7, 1, 3, 4, 1};

        System.out.println(solve(A, B, C));
    }

    private static int solve(int A, int B, int[] C) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int width = 0;

        for (int i = 0; i < C.length; i++) {
            width += C[i];

            if (width == B) {
                width = 0;
            } else {
                map.put(width, map.getOrDefault(width, 0) + 1);

                ans = Math.max(ans, map.get(width));
            }
        }

        return A - ans;
    }
}
