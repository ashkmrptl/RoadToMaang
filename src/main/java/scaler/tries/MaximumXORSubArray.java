package scaler.tries;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array, A of integers of size N. Find the sub-array AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
 * NOTE: If there are multiple sub-arrays with the same maximum value, return the sub-array with minimum length.
 * If the length is the same, return the sub-array with the minimum starting index.
 */
public class MaximumXORSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 4, 3};
        System.out.println(Arrays.toString(new MaximumXORSubArray().solve(A)));

        A = new int[]{8};
        System.out.println(Arrays.toString(new MaximumXORSubArray().solve(A)));
    }

    Node root = new Node();

    /**
     * Approach is to use prefix XOR and then finding the pair having maximum XOR to find the sub-array
     */
    public int[] solve(int[] A) {
        int[] prefXor = new int[A.length + 1];
        prefXor[0] = 0;
        for (int i = 1; i < prefXor.length; i++) {
            prefXor[i] = A[i - 1] ^ prefXor[i - 1];
        }
        int maxXor = Integer.MIN_VALUE;
        for (int i = 0; i < prefXor.length; i++) {
            int xor = addNumAndReturnMaxXor(root, prefXor[i]);
            maxXor = Math.max(maxXor, xor);
        }
        //FOUND MAX_XOR, NOW FIND START AND END INDEX OF THE SUB-ARRAY, SUCH THAT ITS LENGTH AND START ARE MINIMUM//
        HashMap<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int minStart = Integer.MAX_VALUE;
        int minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < prefXor.length; i++) {
            int val = maxXor ^ prefXor[i];
            if (map.containsKey(val)) {
                int start = map.get(val) + 1;
                int len = i - start + 1;
                if (len < minLen) {
                    minLen = len;
                    minStart = start;
                    minEnd = i;
                } else if (len == minLen && start < minStart) {
                    minStart = start;
                    minEnd = i;
                }
            }
            map.put(prefXor[i], i);
        }
        return new int[]{minStart, minEnd};
    }

    //ADD NUMBER TO TRIE AND CALCULATE ITS MAX XOR//
    public int addNumAndReturnMaxXor(Node root, int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new Node();
            }
            curr = curr.children[bit];
        }
        int xor = 0;
        curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = ((num >> i) & 1) ^ 1;
            if (curr.children[bit] != null) {
                xor += (1 << i);
                curr = curr.children[bit];
            } else {
                curr = curr.children[bit ^ 1];
            }
        }
        return xor;
    }

    private static class Node {
        Node[] children;

        public Node() {
            this.children = new Node[2];
        }
    }
}
