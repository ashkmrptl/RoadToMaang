package companies.walmart;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode leafThree = new TreeNode(3);
        TreeNode minusTwo = new TreeNode(-2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode minusThree = new TreeNode(-3);
        TreeNode eleven = new TreeNode(11);
        TreeNode ten = new TreeNode(10);
        ten.left = five;
        ten.right = minusThree;
        five.left = three;
        five.right = two;
        two.right = one;
        three.left = leafThree;
        three.right = minusTwo;
        minusThree.right = eleven;

        System.out.println(pathSum(ten, 8));
    }

    //This approach is similar to count subarrays with given sum(fixed using prefix sum)
    private static int pathSum(TreeNode root, int targetSum) {
        final Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);  // Initialize with sum 0 having one way
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private static int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        // Update the current path sum
        currentSum += node.val;

        // Check if there’s a prefix sum that makes the current path sum equal to targetSum
        int count = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // Add the current path sum to the map
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // Recurse left and right
        count += dfs(node.left, currentSum, targetSum, prefixSumMap);
        count += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // Backtrack: remove the current path sum from the map
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return count;
    }

    private static int count = 0;

    // Bfutr force, this takes O(n * n)
    private static int pathSum_bf(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        dfs(root, targetSum, 0);
        pathSum_bf(root.left, targetSum);
        pathSum_bf(root.right, targetSum);

        return count;
    }

    private static void dfs(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return;
        }

        currentSum += node.val;

        if (currentSum == targetSum) {
            count++;
        }

        dfs(node.left, targetSum, currentSum);
        dfs(node.right, targetSum, currentSum);
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
    }
}
