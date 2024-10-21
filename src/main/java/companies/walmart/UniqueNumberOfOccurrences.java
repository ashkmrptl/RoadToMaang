package companies.walmart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));

        arr = new int[]{1, 2};
        System.out.println(uniqueOccurrences(arr));

        arr = new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (final int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final Set<Integer> set = new HashSet<>(map.values());
//        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            set.add(entry.getValue());
//        }

        return map.size() == set.size();
    }
}
