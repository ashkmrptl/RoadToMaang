package companies.intuit;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaximumPathSum {

    static class TreeNode {
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
            return String.valueOf(this.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);

        final TreeNode twenty = new TreeNode(20);
        twenty.left = new TreeNode(15);
        twenty.right = new TreeNode(7);

        root.right = twenty;
        System.out.println(maxPathSum(root));

        maxSum = Integer.MIN_VALUE;
        root = new TreeNode(2);
        root.left = new TreeNode(-1);
        System.out.println(maxPathSum(root));
    }

    static int maxSum = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }

    private static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        final int sum = Math.max(leftSum, 0) + node.val + Math.max(rightSum, 0);
        maxSum = Math.max(maxSum, sum);
        return node.val + Math.max(Math.max(leftSum, rightSum), 0);
    }
}
