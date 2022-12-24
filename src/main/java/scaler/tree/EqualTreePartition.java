package scaler.tree;

public class EqualTreePartition {
    public static void main(String[] args) {

    }

    private static int total = 0;
    private static boolean ret = false;
    private static TreeNode originRoot = null;

    private static int solve(TreeNode root) {
        originRoot = root;
        total = getTotal(root);
        checkEqual(root);
        if (ret) return 1;
        else return 0;
    }

    private static int getTotal(TreeNode root) {
        // post-order DFS
        if (root == null) return 0;
        return getTotal(root.left) + getTotal(root.right) + root.val;
    }

    private static int checkEqual(TreeNode root) {
        // post-order DFS
        if (root == null || ret) return 0; // skip checking
        int curSum = checkEqual(root.left) + checkEqual(root.right) + root.val;
        if (total - curSum == curSum) {
            if (root != originRoot) { // skip the top level root
                ret = true;
                return 0;
            }
        }
        return curSum;
    }
}
