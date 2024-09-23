package companies.visa;


public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(8, new TreeNode(7, new TreeNode(4), null), new TreeNode(8)));

        System.out.println(isValidBST(root));

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        System.out.println(isValidBST(root));
    }

    private static TreeNode previous = null;

    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftBST = isValidBST(root.left);

        if (previous != null && root.val <= previous.val) {
            return false;
        }

        previous = root;

        boolean isRightBST = isValidBST(root.right);

        return isLeftBST && isRightBST;
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
