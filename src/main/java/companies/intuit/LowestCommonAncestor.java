package companies.intuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        root.left = five;
        root.right = one;
        five.left = six;
        five.right = two;
        one.left = zero;
        one.right = eight;
        two.left = seven;
        two.right = four;

        TreeNode p = five;
        TreeNode q = one;

        System.out.println(lowestCommonAncestor(root, p, q).val);
        System.out.println(lowestCommonAncestorOptimized(root, p, q).val);
    }

    private static TreeNode lowestCommonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q) {
        return optimized(root, p, q);
    }

    private static TreeNode optimized(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }
        TreeNode left = optimized(node.left, p, q);
        TreeNode right = optimized(node.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final List<TreeNode> path1 = new ArrayList<>();
        findPath(root, p, path1);

        final List<TreeNode> path2 = new ArrayList<>();
        findPath(root, q, path2);

        //Reversing the paths to traverse from the node to the root till we find a match
        Collections.reverse(path1);
        Collections.reverse(path2);

        int i = 0;
        int j = 0;

        TreeNode ans = null;

        while (i < path1.size() && j < path2.size()) {
            if (path1.get(i).val == path2.get(j).val) {
                ans = path1.get(i);
                i++;
                j++;
            } else {
                break;
            }
        }

        return ans;
    }

    private static boolean findPath(TreeNode node, TreeNode p, List<TreeNode> path) {
        if (node == null) {
            return false;
        }

        if (node.val == p.val) {
            path.add(node);
            return true;
        }

        final boolean foundOnLeft = findPath(node.left, p, path);
        final boolean foundOnRight = findPath(node.right, p, path);

        if (foundOnLeft || foundOnRight) {
            path.add(node);
            return true;
        }

        return false;
    }
}
