package scaler.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given a binary tree represented by root A.
 * Assume a BST is defined as follows:
 * 1) The left subtree of a node contains only nodes with keys less than the node's key.
 * 2) The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3) Both the left and right subtrees must also be binary search trees.
 */
public class ValidBinarySearchTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 5, 9, 4, 6, 8, 10, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solveUsingInOrderTraversal(A));

        A = DeserializeBinaryTree.solve(List.of(7, 5, 9, 4, 6, 8, 2, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solveUsingInOrderTraversal(A));

        A = DeserializeBinaryTree.solve(List.of(3, 2, 4, 1, 3, -1, -1, -1, -1, -1, -1));
        System.out.println(solveUsingInOrderTraversal(A));
    }

    private static int solve(TreeNode A) {
        return 1;
    }

    static TreeNode previous = null;

    private static int solveUsingInOrderTraversal(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int isLeftBST = solveUsingInOrderTraversal(node.left);
        if (previous != null && node.val <= previous.val) {
            return 0;
        }
        previous = node;
        int isRightBST = solveUsingInOrderTraversal(node.right);

        return isLeftBST == 1 && isRightBST == 1 ? 1 : 0;
    }
}
