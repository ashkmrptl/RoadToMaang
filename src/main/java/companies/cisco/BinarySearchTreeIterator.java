package companies.cisco;

import java.util.*;

public class BinarySearchTreeIterator {

    int index = -1;
    final List<Integer> list;

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public BinarySearchTreeIterator(TreeNode root) {
        list = new ArrayList<>();

        inOrder(root);
    }

    public int next() {
        return list.get(++index);
    }

    public boolean hasNext() {
        return index < list.size() - 1;
    }

    public class TreeNode {
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
