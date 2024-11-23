package companies.walmart;

/**
 * 298. Binary Tree Longest Consecutive Sequence
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class BinaryTreeLongestConsecutiveSequence {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.right = three;
        three.left = two;
        three.right = four;
        four.right = five;

        System.out.println(longestConsecutive(one));
    }

    private static int maxLength = 1;

    public static int longestConsecutive(TreeNode root) {
        return dfs(root, 0, root.val - 1);
    }

    private static int dfs(TreeNode node, int currentLength, int previousValue) {
        if (node == null) {
            return 0;
        }

        currentLength = node.val == previousValue + 1 ? currentLength + 1 : 1;

        int leftMax = dfs(node.left, currentLength, node.val);
        int rightMax = dfs(node.right, currentLength, node.val);

        return Math.max(currentLength, Math.max(leftMax, rightMax));
    }

    private static void dfs_old(TreeNode node, int currentLength) {
        if (node.left != null) {
            int leftLength = (node.left.val - node.val == 1) ? currentLength + 1 : 1;
            maxLength = Math.max(maxLength, leftLength);
            dfs_old(node.left, leftLength);
        }

        if (node.right != null) {
            int rightLength = (node.right.val - node.val == 1) ? currentLength + 1 : 1;
            maxLength = Math.max(maxLength, rightLength);
            dfs_old(node.right, rightLength);
        }
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
