package scaler.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * NOTE: You may assume that duplicates do not exist in the tree.
 */
public class BinaryTreeFromInOrderAndPostOrder {
    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 3};
        int[] B = new int[]{2, 3, 1};

        solve(A, B);
    }

    private static TreeNode solve(int[] A, int[] B) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        return buildTree(0, A.length - 1, B, 0, B.length - 1, map);
    }

    public static TreeNode buildTree(
            int inOrderStart,
            int inOrderEnd,
            int[] postOrder,
            int postOrderStart,
            int postOrderEnd,
            Map<Integer, Integer> map
    ) {
        if (postOrderStart > postOrderEnd || inOrderStart > inOrderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postOrderEnd]);
        int idx = map.get(root.val);
        int numsLeft = idx - inOrderStart;

        root.left = buildTree(inOrderStart, idx - 1, postOrder, postOrderStart, postOrderStart + numsLeft - 1, map);
        root.right = buildTree(idx + 1, inOrderEnd, postOrder, postOrderStart + numsLeft, postOrderEnd - 1, map);

        return root;
    }
}
