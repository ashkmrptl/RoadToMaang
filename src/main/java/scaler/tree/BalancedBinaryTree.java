package scaler.tree;

import java.util.List;

/**
 * Given a root of binary tree A, determine if it is height-balanced.
 * <p>
 * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 1, 15, 2, -1, -1, -1, -1));
        System.out.println(solve(A));
    }

    static boolean isBalanced = true;

    private static int solve(TreeNode A) {
        height(A);
        return isBalanced ? 1 : 0;
    }

    private static int height(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int leftHeight = height(A.left) + 1;
        int rightHeight = height(A.right) + 1;

        if (Math.abs(leftHeight - rightHeight) > 1 && isBalanced) {
            isBalanced = false;
        }

        return Math.max(leftHeight, rightHeight);
    }
}
