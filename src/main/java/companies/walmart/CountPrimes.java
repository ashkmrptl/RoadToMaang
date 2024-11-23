package companies.walmart;

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
    }

    private static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] arr = new boolean[n];
        for (int i = 2; i < n; i++) {
            arr[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (arr[i]) {//If prime then only check
                for (int j = i * i; j < n; j += i) {
                    if (j % i == 0) {
                        arr[j] = false;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i]) {
                count++;
            }
        }

        return count;
    }
}
