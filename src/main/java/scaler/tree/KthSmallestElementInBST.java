package scaler.tree;

import java.util.List;

/**
 * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
 */
public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 5, 9, 4, 6, 8, 10, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A, 0));
        System.out.println(solve(A, 1));
        System.out.println(solve(A, 2));
        System.out.println(solve(A, 3));
        System.out.println(solve(A, 4));
        System.out.println(solve(A, 5));
        System.out.println(solve(A, 6));
    }

    /**
     * This can be solved using any of the traversal method.
     * <p>
     * In-order traversal of a BST gives an array with sorted in ascending order.
     * So, we start from root with k = B and start traversing using on-order
     */
    private static int solve(TreeNode A, int B) {
        K = B - 1;
        inOrder(A);

        return ans;
    }

    static int ans = 0;
    static int K = 0;

    private static void inOrder(TreeNode A) {
        if (A == null) {
            return;
        }

        inOrder(A.left);
        if (K == 0) {
            ans = A.val;
        }
        K--;
        inOrder(A.right);
    }
}
