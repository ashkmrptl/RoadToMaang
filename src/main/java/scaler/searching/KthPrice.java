package scaler.searching;

public class KthPrice {
    public static void main(String[] args) {
        int[] A = new int[] {1, 1, 1, 8, 8, 9, 10, 12, 24};
        int B = 3;

        System.out.println(solve(A, B));
    }

    private static int solve(final int[] A, final int B) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            low = Math.min(low, A[i]);
            high = Math.max(high, A[i]);
        }

        int ans = -1;
        int smallerCount;

        while(low <= high) {
            smallerCount = 0;
            int mid = (low + high) / 2;

            for (int i = 0; i < A.length; i++) {
                if(A[i] <= mid) {
                    smallerCount++;
                }
            }

            if(smallerCount >= B) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
