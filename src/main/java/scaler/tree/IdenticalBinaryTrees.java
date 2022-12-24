package scaler.tree;

import java.util.List;

public class IdenticalBinaryTrees {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));
        TreeNode B = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));

        System.out.println(solve(A, B));

        A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));
        B = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 12, -1, -1, 6, -1, -1, 8, -1, -1));

        System.out.println(solve(A, B));
    }

    private static int solve(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }

        if (A == null) {
            return 0;
        }

        if (B == null) {
            return 0;
        }

        int leftAns = solve(A.left, B.left);
        if (A.val != B.val) {
            return 0;
        }
        int rightAns = solve(A.right, B.right);

        if (leftAns == 1 && rightAns == 1) {
            return 1;
        } else {
            return 0;
        }

    }
}
