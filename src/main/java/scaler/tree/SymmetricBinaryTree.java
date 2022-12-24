package scaler.tree;

import java.util.List;

/**
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 2, 3, 4, 4, 3));
        System.out.println(solve(A));

        A = DeserializeBinaryTree.solve(List.of(1, 2, 2, 3, -1, -1, 3));
        System.out.println(solve(A));

        A = DeserializeBinaryTree.solve(List.of(1, 2, 2, 3, 4, -1, 3));
        System.out.println(solve(A));
    }

    /**
     * Approach: We need to check if the left of root is mirror of right
     */
    private static int solve(TreeNode A) {
        boolean ans = inOrder(A.left, A.right);
        return ans ? 1 : 0;
    }

    private static boolean inOrder(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }

        if (A == null) {
            return false;
        } else if (B == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        boolean x = inOrder(A.left, B.right);
        boolean y = inOrder(A.right, B.left);

        return x & y;
    }
}
