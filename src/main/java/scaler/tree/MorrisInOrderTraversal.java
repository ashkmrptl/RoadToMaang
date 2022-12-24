package scaler.tree;

import java.util.List;

public class MorrisInOrderTraversal {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));
        solve(A);
    }

    private static void solve(TreeNode A) {
        if (A == null) {
            return;
        }

        TreeNode current = A;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                //Find the inorder predecessor
                TreeNode temp = current.left;

                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }

                if (temp.right == current) {
                    temp.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            }
        }
    }
}
