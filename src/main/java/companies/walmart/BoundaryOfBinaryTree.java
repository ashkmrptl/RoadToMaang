package companies.walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 545. Boundary of Binary Tree
 * <p>
 * https://leetcode.com/problems/boundary-of-binary-tree/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class BoundaryOfBinaryTree {
    public static void main(String[] args) {
        final TreeNode root = new TreeNode();
        System.out.println(boundaryOfBinaryTree(root));
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode node) {
        final List<Integer> list = new ArrayList<>();

        // Add the root node
        list.add(node.val);

        if (isLeaf(node)) {
            return list;
        }

        // Add left boundary excluding leaf nodes
        addLeftBoundary(node, list);

        // Add Leaf Nodes from left to right
        addLeafNode(node, list);

        // Add right boundary excluding leaf nodes
        addRightBoundary(node, list);

        return list;
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> list) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                list.add(curr.val);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static void addRightBoundary(TreeNode root, List<Integer> list) {
        TreeNode curr = root.right;

        final Stack<Integer> stack = new Stack<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                stack.add(curr.val);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }

    private static void addLeafNode(TreeNode root, List<Integer> list) {
        if (isLeaf(root)) {
            list.add(root.val);
            return;
        }

        if (root.left != null) {
            addLeafNode(root.left, list);
        }
        if (root.right != null) {
            addLeafNode(root.right, list);
        }
    }

    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
