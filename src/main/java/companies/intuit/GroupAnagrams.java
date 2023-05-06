package companies.intuit;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagramsUsingArray(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

        Map<Character, Integer> frequencyMap;
        for (final String str : strs) {
            frequencyMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0) + 1);
            }

            if (map.containsKey(frequencyMap)) {
                map.get(frequencyMap).add(str);
            } else {
                final List<String> list = new ArrayList<>();
                list.add(str);
                map.put(frequencyMap, list);
            }
        }

        final List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private static List<List<String>> groupAnagramsUsingArray(String[] strs) {
        if (strs == null) {
            return Collections.emptyList();
        }

        final Map<String, List<String>> map = new HashMap<>();
        for (final String str : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }

            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
