package scaler.tree;

import java.util.List;

public class InvertTheBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));
        solve(A);
    }

    private static TreeNode solve(TreeNode A) {
        invert(A);
        return A;
    }

    private static void invert(TreeNode A) {
        if (A == null) {
            return;
        }

        invert(A.left);
        invert(A.right);

        TreeNode left = A.left;
        A.left = A.right;
        A.right = left;
    }
}
