package scaler.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonNodesInTwoBST {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(25, 18, 30, 14, 21, 28, 33, 6, 17, 20, 22, 27, 29, 31, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));
        TreeNode B = DeserializeBinaryTree.solve(List.of(18, 11, 24, 6, 14, 21, 28, 4, 7, 12, 16, 19, 22, 25, 31, -1, 5, -1, 9, -1, 13, 15, 17, -1, 20, -1, 23, -1, 26, 30, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));

        System.out.println(solve(A, B));
    }

    private static final int mod = 1000 * 1000 * 1000 + 7;

    private static int solve(TreeNode A, TreeNode B) {
        final Map<Integer, Integer> map = new HashMap<>();
        inOrderTraverse(A, map);
        inOrderCompute(B, map);

        return (int) (sum % mod);

    }

    private static void inOrderTraverse(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.left, map);
        if (map.containsKey(node.val)) {
            map.put(node.val, map.get(node.val) + 1);
        } else {
            map.put(node.val, 1);
        }
        inOrderTraverse(node.right, map);
    }

    static long sum = 0;

    private static void inOrderCompute(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        inOrderCompute(node.left, map);
        if (map.containsKey(node.val)) {
            sum = (sum % mod + ((long) node.val % mod)) % mod;
        }
        inOrderCompute(node.right, map);
    }
}
