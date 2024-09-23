package companies.visa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        final Map<String, List<String>> map = new HashMap<>();

        for (final String word : strs) {
            final char[] arr = new char[26];
            for (final char c : word.toCharArray()) {
                arr[c - 'a']++;
            }

            final String str = new String(arr);

            if (map.containsKey(str)) {
                map.get(str).add(word);
            } else {
                final List<String> list = new ArrayList<>();
                list.add(word);
                map.put(str, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
