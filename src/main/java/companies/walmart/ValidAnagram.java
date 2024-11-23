package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));

        System.out.println(isAnagram("rat", "car"));
    }

    private static boolean isAnagram(String s, String t) {
        final Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }

        return map.isEmpty();
    }
}
