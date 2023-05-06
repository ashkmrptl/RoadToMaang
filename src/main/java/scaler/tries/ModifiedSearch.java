package scaler.tries;

import java.util.HashSet;

public class ModifiedSearch {

    private static class Node {
        private boolean isEnd;
        private final Node[] children;

        public Node() {
            this.isEnd = false;
            this.children = new Node[26];

        }
    }


    private Node root = new Node();

    private void insertWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new Node();
            }
            curr = curr.children[childIdx];
        }
        curr.isEnd = true;
    }


    private boolean searchWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) {
                return false;
            }
            curr = curr.children[childIdx];
        }
        return curr.isEnd;

    }


    public String solve(String[] A, String[] B) {
        for (String word : A) {
            insertWord(word);
        }

        StringBuilder ans = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        for (String word : B) {
            set.add(word);
            boolean isFound = false;
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                char oldChar = charArr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    charArr[i] = ch;
                    String newString = new String(charArr);
                    if (set.contains(newString)) {
                        continue;
                    }
                    isFound = searchWord(newString);
                    if (isFound) {
                        break;
                    }
                }
                charArr[i] = oldChar;
                if (isFound) {
                    break;
                }
            }

            if (isFound) {
                ans.append(1);
            } else {
                ans.append(0);
            }
        }
        return new String(ans);
    }
}