package companies.visa;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(15));
    }

    public int consecutiveNumbersSum_copied(int n) {
        int ways = 0, i = 1;
        while (n>0){
            n -= i;
            if (n % i == 0){
                ways++;
            }
            i++;
        }
        return ways;
    }

    private static int consecutiveNumbersSum(int n) {
        int count = 0;

        /*for (int k = 1; 2 * n > k * (k - 1); k++) {
            int numerator = n - (k * (k - 1) / 2);
            if (numerator % k == 0) {
                count++;
            }
        }*/

        int i = 1;

        while ((2 * n) > (i * (i - 1))) {
            if ((n - ((i * (i - 1)) / 2)) % i == 0) {
                count++;
            }
            i++;
        }

        return count;
    }

    //Brute force
    private static int consecutiveNumbersSum_bf(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 1;

        int i = 1;
        int j = 1;
        int sum = 0;
        while (j <= i && ((i - 1) + (i - 2)) <= n) {
            if (sum == n) {
                count++;
                sum -= j;
                j++;
            } else if (sum > n) {
                sum -= j;
                j++;
            } else {
                sum += i;
                i++;
            }
        }

        return count;
    }
}
