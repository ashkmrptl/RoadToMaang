package scaler.tree;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class SortedArrayToBBST {
    /*public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 5, 10};
        TreeNode tree = solve(A);
        System.out.println(tree);
    }

    private static TreeNode solve(int[] A) {
        return createTree(A, 0, A.length - 1);
    }

    private static TreeNode createTree(int[] A, int start, int end) {
        int mid = (start + end) / 2;

        if (start > end) {
            return null;
        }

        final TreeNode node = new TreeNode(A[mid]);
        node.left = createTree(A, start, mid - 1);
        node.right = createTree(A, mid + 1, end);

        return node;
    }*/

    public static void main(String[] args) {
        List<Integer> A = List.of(1, 2, 3, 5, 10);
        TreeNode tree = solve(A);
        System.out.println(tree);
    }

    private static TreeNode solve(List<Integer> A) {
        return createTree(A, 0, A.size() - 1);
    }

    private static TreeNode createTree(List<Integer> A, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(A.get(mid));
        node.left = createTree(A, start, mid - 1);
        node.right = createTree(A, mid + 1, end);
        return node;
    }
}
