package scaler.tree;

public class CountNoOfNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(solve(root));
    }

    private static int solve(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int count = solve(node.left) + solve(node.right);

        return count + 1;//Adding one for current node
    }
}
