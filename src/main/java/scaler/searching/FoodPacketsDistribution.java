package scaler.searching;

public class FoodPacketsDistribution {
    public static void main(String[] args) {
        int[] A = new int[]{10000, 20000, 30000};
        int B = 6;

        System.out.println(solve(A, B));

        A = new int[]{2, 9, 5, 4};
        B = 13;
        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int B) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            r = Math.min(r, A[i]);
        }

        int ans = 0;

        while (l <= r) {
            int m = (l + r) / 2;

            //if (check(A, B, m)) {
            if (isMinimum(A, m, B)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }

    public static boolean isMinimum(int[] A, int mid, int B) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (mid == 0) {
                sum += A[i];
            } else {
                sum += (A[i] / mid);
            }
        }
        return sum >= B;
    }

    private static boolean check(int[] A, int B, int maxPopulation) {
        int offices = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= maxPopulation) {
                offices++;
            }

            if (A[i] > maxPopulation) {
                offices += A[i] / maxPopulation + (A[i] % maxPopulation > 0 ? 1 : 0);
            }

            if (offices > B) {
                return false;
            }
        }

        return true;
    }
}
