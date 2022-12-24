package scaler.tree;

import java.util.List;

/**
 * You are given a Binary Tree A with N nodes.
 * Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
 * If the complete Binary Tree is BST, then return the size of the whole tree.
 * NOTE:
 * The largest subtree is the subtree with the most number of nodes.
 */
public class LargestBSTSubtree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 5, 9, 4, 6, 8, 10, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A));
    }

    /**
     * Approach:
     * Check if root is valid BST.
     * For each valid BST, get Size of BST
     * Return max size of BST subTree
     */
    private static int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }

        boolean isValidBST = isBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (isValidBST) {
            return getSize(A);
        }

        int leftSize = solve(A.left);
        int rightSize = solve(A.right);

        return Math.max(leftSize, rightSize);
    }

    /**
     * This approach used pre-order traversal
     */
    private static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.val < min || node.val > max) {
            return false;
        }

        boolean isLeftBST = isBST(node.left, min, node.val - 1);
        boolean isRightBST = isBST(node.right, node.val + 1, max);

        return isLeftBST && isRightBST;
    }

    private static int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return getSize(node.left) + 1 + getSize(node.right);
    }
}
