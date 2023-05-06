package scaler.tries;

import java.util.*;

public class ContactFinder {
    public static void main(String[] args) {

    }

    public Node root = new Node();

    public List<Integer> solve(List<Integer> A, List<String> B) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                insertContact(B.get(i));
            } else {
                ans.add(freqCounter(B.get(i)));
            }
        }
        return ans;
    }

    public void insertContact(String contact) {
        Node currNode = root;
        for (int i = 0; i < contact.length(); i++) {
            int index = contact.charAt(i) - 'a';

            if (currNode.child[index] == null) {
                currNode.child[index] = new Node();
            } else {
                currNode.child[index].freq++;
            }
            currNode = currNode.child[index];
        }
        currNode.isEnd = true;
    }

    public int freqCounter(String contact) {
        Node currNode = root;
        for (int i = 0; i < contact.length(); i++) {
            int idx = contact.charAt(i) - 'a';
            if (currNode.child[idx] == null) {
                return 0;
            }
            currNode = currNode.child[idx];
        }
        return currNode.freq;
    }

    public static class Node {
        int freq;
        boolean isEnd;
        Node[] child = new Node[26];

        Node() {
            this.freq = 1;
            this.isEnd = false;
        }
    }
}
