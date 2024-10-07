package companies.agoda;

/**
 * 3178. Find the Child Who Has the Ball After K Seconds
 * https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/description/?envType=company&envId=agoda&favoriteSlug=agoda-all
 */
public class FindTheChildWhoHasTheBallAfterKSeconds {
    public static void main(String[] args) {
        System.out.println(numberOfChild(3, 5));
        System.out.println(numberOfChild(5, 6));
        System.out.println(numberOfChild(4, 2));
    }

    private static int numberOfChild(int n, int k) {
        int totalRounds = k / (n - 1);
        int rem = k % (n - 1);
        if (totalRounds % 2 == 0) {
            return rem ;
        } else {
            return n - 1 - rem;
        }
    }
}
