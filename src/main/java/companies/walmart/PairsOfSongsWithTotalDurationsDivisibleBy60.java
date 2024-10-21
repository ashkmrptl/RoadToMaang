package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        int[] time = new int[]{30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(time));

        time = new int[]{60, 60, 60};
        System.out.println(numPairsDivisibleBy60(time));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;

        final Map<Integer, Integer> map = new HashMap<>();

        for (int t : time) {
            int reminder = t % 60;
            int complement = (60 - reminder) % 60;

            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }

        return count;
    }
}
