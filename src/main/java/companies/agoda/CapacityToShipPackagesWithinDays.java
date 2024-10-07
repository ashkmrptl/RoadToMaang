package companies.agoda;

/**
 * 1011. Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/?envType=company&envId=agoda&favoriteSlug=agoda-all
 */

public class CapacityToShipPackagesWithinDays {
    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));

        weights = new int[]{3, 2, 2, 4, 1, 4};
        days = 3;

        System.out.println(shipWithinDays(weights, days));

        weights = new int[]{1, 2, 3, 1, 1};
        days = 4;

        System.out.println(shipWithinDays(weights, days));

        weights = new int[]{10, 50, 100, 100, 50, 100, 100, 100};
        days = 5;

        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int min = weights[0];
        int sum = 0;

        for (int weight : weights) {
            min = Math.max(min, weight);
            sum += weight;
        }

        int max = sum;

        //Perform binary search

        int ans = max;

        while (min <= max) {
            int mid = (min + max) / 2;

            boolean possible = isPossible(mid, weights, days);
            if (possible) {
                ans = Math.min(ans, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int weight, int[] weights, int days) {
        int i = 0;

        int tempDays = 0;

        while (i < weights.length) {
            int sum = 0;

            while (i < weights.length && sum + weights[i] <= weight) {
                sum += weights[i];
                i++;
            }

            tempDays++;
        }

        if (tempDays <= days) {
            return true;
        } else {
            return false;
        }
    }
}
