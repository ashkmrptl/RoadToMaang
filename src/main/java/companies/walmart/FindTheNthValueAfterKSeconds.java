package companies.walmart;

import java.util.Arrays;

/**
 * 3179. Find the N-th Value After K Seconds
 * https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class FindTheNthValueAfterKSeconds {
    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(4, 5));
        System.out.println(valueAfterKSeconds(5, 3));
    }

    private static int valueAfterKSeconds(int n, int k) {
        int[] a = new int[n];
        Arrays.fill(a, 1);

        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n; j++) {
                a[j] = (a[j - 1] + a[j]) % 1_000_000_007;
            }
        }

        return a[n - 1];
    }

    private static int valueAfterKSeconds_old(int n, int k) {
        final int mod = 1000000007;

        int[] a = new int[n];

        Arrays.fill(a, 1);

        for (int i = 0; i < k; i++) {
            int[] prefixSum = new int[n];
            prefixSum[0] = a[0];

            for (int j = 1; j < n; j++) {
                prefixSum[j] = (prefixSum[j - 1] + a[j]) % mod;
            }

            System.arraycopy(prefixSum, 0, a, 0, n);
        }

        return a[n - 1];
    }
}
