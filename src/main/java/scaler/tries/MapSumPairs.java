package scaler.tries;

import java.util.*;

/**
 * Rishabh was sitting ideally in his office and then suddenly his boss gave him some operations to perform.
 * You being his friend tried to help him in finishing the task fast.
 * So you have to perform Q operation of two types:
 * Operation 1: INSERT : You are given an pair of (string, integer).The string represents the key and the integer represents the value. Insert the key-value pair in the hash and If the key already exists in hash, then the original key-value pair will be overridden to the new one.
 * Operation 2: SUM : you'll be given an pair of (string, -1) where string representing the prefix, and you need to return the sum of all the pairs' value in the hash whose key starts with the prefix.
 */
public class MapSumPairs {
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("apple");
        A.add("ap");
        A.add("app");
        A.add("ap");

        ArrayList<Integer> B = new ArrayList<>();
        B.add(3);
        B.add(-1);
        B.add(2);
        B.add(-1);

        System.out.println(solve(A, B));
    }

    static Map<String, Integer> hash = new HashMap<>();

    private static ArrayList<Integer> solve(ArrayList<String> A, ArrayList<Integer> B) {
        int n = A.size();
        TrieNode root = new TrieNode();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (B.get(i) == -1) {
                res.add(sum(root, A.get(i)));
            } else {
                insert(root, A.get(i), B.get(i));
            }
        }
        return res;
    }

    private static int sum(TrieNode curr, String prefix) {
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] != null) {
                curr = curr.children[c - 'a'];
            } else {
                return 0;
            }
        }
        return curr.sum;
    }

    private static void insert(TrieNode curr, String key, int val) {
        int data = val - hash.getOrDefault(key, 0);
        hash.put(key, val);
        int n = key.length();
        for (int i = 0; i < n; i++) {
            char c = key.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            curr.sum += data;
        }
    }

    private static class TrieNode {
        int sum;
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            sum = 0;
            isEnd = false;
            children = new TrieNode[26];
        }
    }
}
