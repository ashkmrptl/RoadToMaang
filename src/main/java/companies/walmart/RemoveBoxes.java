package companies.walmart;

public class RemoveBoxes {
    public static void main(String[] args) {
        int[] boxes = new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(removeBoxes(boxes));

        boxes = new int[]{1, 1, 1};
        System.out.println(removeBoxes(boxes));
    }

    private static int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return calculatePoints(boxes, 0, n - 1, 0, dp);
    }

    private static int calculatePoints(int[] boxes, int l, int r, int k, int[][][] dp) {
        if (l > r) {
            return 0;
        }

        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }

        // Keep adding same colour boxes at the start
        while (l < r && boxes[l] == boxes[l + 1]) {
            l++;
            k++;
        }

        // Option 1: Remove box[l] and get (k + 1) * (k + 1)
        dp[l][r][k] = (k + 1) * (k + 1) + calculatePoints(boxes, l + 1, r, 0, dp);

        // Option 2: Try to group box[l] with some boxes[l+1]...box[r]
        for (int j = l + 1; j <= r; j++) {
            if (boxes[l] == boxes[j]) {
                dp[l][r][k] = Math.max(dp[l][r][k],
                        calculatePoints(boxes, l + 1, j - 1, 0, dp) + calculatePoints(boxes, j, r, k + 1, dp));
            }
        }

        return dp[l][r][k];
    }
}
