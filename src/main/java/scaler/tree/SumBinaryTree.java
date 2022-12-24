package scaler.tree;

import java.util.List;

/**
 * Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
 * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
 * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 * Return 1 if it sum-binary tree else return 0.
 */
public class SumBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(26, 10, 3, 4, 6, -1, 3));
        System.out.println(solve(A));

        A = DeserializeBinaryTree.solve(List.of(26, 10, 3, 4, 6, -1, 4));
        System.out.println(solve(A));

        A = DeserializeBinaryTree.solve(List.of(1, 4, -1, -1, -1));
        System.out.println(solve(A));
    }

    private static int solve(TreeNode A) {
        isSumBinaryTree(A);

        return flag ? 1 : 0;
    }

    private static boolean flag = true;

    private static int isSumBinaryTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = isSumBinaryTree(node.left);
        int rightSum = isSumBinaryTree(node.right);

        if ((node.left != null || node.right != null) && (leftSum + rightSum != node.val) && flag){
            flag = false;
        }

        return leftSum + rightSum + node.val;
    }
}
