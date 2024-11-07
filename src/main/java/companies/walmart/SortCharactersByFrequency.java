package companies.walmart;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    private static String frequencySort(String s) {
        final Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //Sort the map by values
        List<Map.Entry<Character, Integer>> list = map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toList());

        final StringBuilder sb = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            Map.Entry<Character, Integer> entry = list.get(j);
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
