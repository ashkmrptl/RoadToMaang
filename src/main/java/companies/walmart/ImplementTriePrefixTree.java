package companies.walmart;

public class ImplementTriePrefixTree {
    private static class TrieNode {
        Character ch;
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(Character ch) {
            this.ch = ch;
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        final Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.startsWith("app"));
    }

    private static class Trie {
        final TrieNode root;

        public Trie() {
            root = new TrieNode(null);//Dummy node
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                final int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    final TrieNode node = new TrieNode(word.charAt(i));
                    curr.children[index] = node;
                }
                curr = curr.children[index];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                final int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                final int index = prefix.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }
            return true;
        }
    }
}
