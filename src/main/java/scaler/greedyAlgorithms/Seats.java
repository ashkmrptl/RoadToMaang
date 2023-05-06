package scaler.greedyAlgorithms;

/**
 * There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
 * There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
 * An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
 * Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat
 * between them in such a way that the total number of hops or jumps to move them should be minimum.
 * In one jump a person can move to the adjacent seat (if available).
 * NOTE: 1. Return your answer modulo 107 + 3.
 */
public class Seats {
    public static void main(String[] args) {
        System.out.println(solve("....x..xx...x.."));
        System.out.println(solve("....xxx"));
    }

    private static int solve(String A) {
        int count = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                count++;
            }
        }

        if (count == 0 || count == 1) {
            return 0;
        }

        int mid = 0;
        int half = count / 2;
        count = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                count++;
            }
            if (count > half) {
                mid = i;
                break;
            }
        }

        long ans = 0;
        long mod = (long) 1e7 + 3;

        int lastIndex = mid;
        for (int i = mid + 1; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                ans = (ans + i - lastIndex - 1) % mod;
                lastIndex++;
            }
        }
        lastIndex = mid;
        for (int i = mid - 1; i >= 0; i--) {
            if (A.charAt(i) == 'x') {
                ans = (ans + lastIndex - i - 1) % mod;
                lastIndex--;
            }
        }
        return (int) ans;
    }
}
