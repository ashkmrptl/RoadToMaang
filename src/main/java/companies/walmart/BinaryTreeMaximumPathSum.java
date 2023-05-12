package companies.walmart;

public class BinaryTreeMaximumPathSum {
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

    private static int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }

    private static int maxSum = Integer.MIN_VALUE;

    private static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        int sum = Math.max(leftSum, 0) + node.val + Math.max(rightSum, 0);
        maxSum = Math.max(sum, maxSum);

        return node.val + Math.max(Math.max(leftSum, rightSum), 0);
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
