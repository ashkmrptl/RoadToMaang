package companies.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementMagicDictionary {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        //System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));

    }

    private static class MagicDictionary {
        final Map<Integer, Set<String>> map;

        public MagicDictionary() {
            map = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (final String word : dictionary) {
                if (map.containsKey(word.length())) {
                    map.get(word.length()).add(word);
                } else {
                    final Set<String> set = new HashSet<>();
                    set.add(word);
                    map.put(word.length(), set);
                }
            }
        }

        public boolean search(String searchWord) {
            if (map.containsKey(searchWord.length())) {
                for (final String word : map.get(searchWord.length())) {
                    int count = 0;

                    for (int i = 0; i < word.length(); i++) {
                        if (searchWord.charAt(i) != word.charAt(i)) {
                            count++;
                        }

                        if (count > 1) {
                            break;
                        }
                    }
                    if (count == 1) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    /*private static class TrieNode {
        Character ch;
        boolean isEnd;
        TrieNode[] children;

        @Override
        public String toString() {
            return String.valueOf(ch);
        }
    }*/
}
