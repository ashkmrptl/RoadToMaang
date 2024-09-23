package companies.microsoft;

import test.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateBinaryTree {

    public static void main(String[] args) {
        final TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.left = new TreeNode(2);
        tree.right.right = new TreeNode(4);
        tree.right.left.left = new TreeNode(4);

        System.out.println(findDuplicateSubtrees(tree));
    }

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> subtreeMap = new HashMap<>();

        dfs(root, subtreeMap, result);

        return result;
    }

    private static String dfs(TreeNode node, Map<String, Integer> subtreeMap, List<TreeNode> result) {
        if (node == null) {
            return "#";
        }

        // Generate unique identifier of the current subtree
        final String subtree = node.val + "," + dfs(node.left, subtreeMap, result) + "," + dfs(node.right, subtreeMap, result);

        // Increment count in hashmap and check for duplicates
        subtreeMap.put(subtree, subtreeMap.getOrDefault(subtree, 0) + 1);
        if (subtreeMap.get(subtree) == 2) {
            result.add(node);
        }

        return subtree;
    }


    private static class TreeNode {
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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
