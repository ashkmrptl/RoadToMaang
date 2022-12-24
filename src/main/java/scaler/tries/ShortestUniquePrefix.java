package scaler.tries;

import java.util.Arrays;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        String[] A = new String[]{"zebra", "dog", "duck", "dove"};
        System.out.println(Arrays.toString(solve(A)));

        A = new String[]{"apple", "ball", "cat"};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static String[] solve(String[] A) {
        return search(A, buildTrie(A));
    }

    private static TrieNode buildTrie(String[] A) {
        final TrieNode root = new TrieNode(null);

        for (String str : A) {
            TrieNode current = root;
            for (Character ch : str.toCharArray()) {
                if (current.arr[ch - 'a'] == null) {
                    current.arr[ch - 'a'] = new TrieNode(ch);
                } else {
                    current.arr[ch - 'a'].prefixCount++;
                }
                current = current.arr[ch - 'a'];
            }
            current.isEnd = true;
        }

        return root;
    }

    private static String[] search(String[] A, TrieNode root) {
        final String[] res = new String[A.length];

        for (int i = 0; i < A.length; i++) {
            TrieNode current = root;
            final StringBuilder sb = new StringBuilder();
            for (Character ch : A[i].toCharArray()) {
                TrieNode node = current.arr[ch - 'a'];
                sb.append(node.ch);
                if (node.prefixCount == 1) {
                    break;
                }
                current = node;
            }
            res[i] = sb.toString();
        }

        return res;
    }
}
