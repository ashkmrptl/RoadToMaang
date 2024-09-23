package companies.microsoft;

public class ValidateBinarySearchTree {
    private static TreeNode previous = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        previous = null;
        System.out.println(isValidBST(root));

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        previous = null;
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        final boolean isLeftBST = isValidBST(root.left);

        if (previous != null && root.val <= previous.val) {
            return false;
        }
        previous = root;

        final boolean isRightBST = isValidBST(root.right);

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
    }
}
