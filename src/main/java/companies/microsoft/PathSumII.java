package companies.microsoft;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null
                ),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, new TreeNode(5), new TreeNode(1))));

        System.out.println(pathSum(node, 22));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final List<List<Integer>> paths = new ArrayList<>();

        dfs(root, targetSum, 0, new ArrayList<>(), paths);

        return paths;
    }

    private static void dfs(TreeNode node, int targetSum, int currentSum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (targetSum == currentSum + node.val) {
                final List<Integer> list = new ArrayList<>(currentPath);
                list.add(node.val);
                paths.add(list);
            }
            return;
        }

        currentPath.add(node.val);
        dfs(node.left, targetSum, currentSum + node.val, currentPath, paths);
        dfs(node.right, targetSum, currentSum + node.val, currentPath, paths);
        currentPath.remove(currentPath.size() - 1);
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
