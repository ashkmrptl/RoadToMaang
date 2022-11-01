package scaler.twoPointers;

/**
 * Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
 * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 4, 3};
        System.out.println(solve(A));

        A = new int[]{1};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int ans = Integer.MIN_VALUE;

        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            int amount = (j - i) * Math.min(A[i], A[j]);
            ans = Math.max(ans, amount);

            if (A[i] < A[j]) {
                i++;
            } else {
                j--;
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
