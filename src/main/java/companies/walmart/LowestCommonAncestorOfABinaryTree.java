package companies.walmart;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private static TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        if (node.val == p.val) {
            return node;
        }

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}