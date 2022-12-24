package scaler.tries;

import java.util.Arrays;

/**
 * Given an array of words A (dictionary) and another array B (which contain some words).
 * You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
 * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 * Such problems can be seen in real life when we work on any online editor (like Google Document), if the word is not valid it is underlined by a red line.
 * NOTE: Try to do this in O(n) time complexity.
 */
public class SpellingChecker {
    public static void main(String[] args) {
        String[] A = new String[]{"hat", "cat", "rat"};
        String[] B = new String[]{"cat", "ball"};

        System.out.println(Arrays.toString(solve(A, B)));

        A = new String[]{"hat", "cat", "rat"};
        B = new String[]{"cat", "rat"};

        System.out.println(Arrays.toString(solve(A, B)));

        A = new String[]{"hat", "cat", "rat"};
        B = new String[]{"ball", "call"};

        System.out.println(Arrays.toString(solve(A, B)));

        A = new String[]{"tape", "bcci"};
        B = new String[]{"table", "cci"};

        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(String[] A, String[] B) {
        final TrieNode root = createTries(A);
        final int[] res = search(root, B);

        return res;
    }

    private static int[] search(TrieNode root, String[] B) {
        int[] res = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            TrieNode current = root;
            for (char ch : B[i].toCharArray()) {
                if (current.arr[ch - 'a'] != null) {
                    current = current.arr[ch - 'a'];
                } else {
                    break;
                }
            }
            if (current.isEnd) {
                res[i] = 1;
            }
        }

        return res;
    }

    private static TrieNode createTries(String[] A) {

        final TrieNode root = new TrieNode(null);

        for (String str : A) {
            TrieNode current = root;
            for (char ch : str.toCharArray()) {
                if (current.arr[ch - 'a'] == null) {
                    current.arr[ch - 'a'] = new TrieNode(ch);
                }

                current = current.arr[ch - 'a'];
            }

            current.isEnd = true;
        }

        return root;
    }

}
