package companies.walmart;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));

        wordList = List.of("hot", "dot", "dog", "lot", "log");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();

            final String currentWord = pair.word;
            char[] arr = currentWord.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (arr[i] != j) {
                        arr[i] = j;
                        final String newWord = new String(arr);
                        if (newWord.equals(endWord)) {
                            return pair.length + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.add(new Pair(newWord, pair.length + 1));
                            wordSet.remove(newWord);
                        }
                    }
                }
                arr = currentWord.toCharArray();
            }
        }

        return 0;
    }

    private static class Pair {
        String word;
        int length;

        public Pair(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }
}
