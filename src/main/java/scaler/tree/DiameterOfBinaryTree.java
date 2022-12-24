package scaler.tree;

import java.util.List;

/**
 * Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
 * The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));
        System.out.println(solve(A));
    }

    /**
     * Idea is to build the path array for the two longest paths. Then to find the Lowest common ancestor(LCA) and find the path required.
     */
    private static int solve(TreeNode A) {
        findHeight(A);
        return maxWidth;
    }

    private static int maxWidth = 0;

    private static int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        maxWidth = Math.max(maxWidth, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
