package companies.cisco;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(preorderTraversal(root));
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();

        preorder(root, list);

        return list;
    }

    private static void preorder(final TreeNode node, final List<Integer> ans) {
        if (node == null) {
            return;
        }

        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
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
