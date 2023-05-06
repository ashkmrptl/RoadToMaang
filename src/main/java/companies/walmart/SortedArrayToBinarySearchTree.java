package companies.walmart;

import scaler.tree.TreeNode;

public class SortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};

        TreeNode ans = sortedArrayToBST(nums);
        System.out.println(ans);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private static TreeNode createTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        final TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = createTree(nums, start, mid - 1);
        treeNode.right = createTree(nums, mid + 1, end);

        return treeNode;
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
