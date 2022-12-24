package scaler.tries;

class TrieNode {
    Character ch;
    TrieNode[] arr;
    boolean isEnd;

    int prefixCount = 1;

    public TrieNode(Character ch) {
        this.ch = ch;
        arr = new TrieNode[26];
        isEnd = false;
    }
}
