package companies.walmart;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitSpaceOptimized(prices));

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitSpaceOptimized(prices));
    }

    /**
     * Approach is to build the left min array. Then take the difference from left to right.
     * We try from left to right. When we want to sell at a particular day, then we will be buying it at min cost before.
     * Hence, the left minimum array will be useful here.
     */
    private static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        final int[] leftMin = new int[prices.length];
        leftMin[0] = prices[0];
        for (int i = 1; i < leftMin.length; i++) {
            if (prices[i] < leftMin[i - 1]) {
                leftMin[i] = prices[i];
            } else {
                leftMin[i] = leftMin[i - 1];
            }
        }

        int answer = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            answer = Math.max(answer, prices[i] - leftMin[i]);
        }

        return answer;
    }

    private static int maxProfitSpaceOptimized(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int minSoFar = prices[0];

        int answer = 0;

        for (int i = 1; i < prices.length; i++) {
            answer = Math.max(answer, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return answer;
    }
}
