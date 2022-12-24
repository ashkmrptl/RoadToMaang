package scaler.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
 * <p>
 * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
 * <p>
 * NOTE:
 * <p>
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 */
public class DeserializeBinaryTree {
    public static void main(String[] args) {
        List<Integer> A = List.of(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1);
        solve(A);
    }

    public static TreeNode solve(List<Integer> A) {
        if (A == null || A.isEmpty() || A.get(0) == -1) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(A.get(0));
        queue.add(root);

        int i = 1;

        while (i < A.size() - 1) {
            TreeNode parent = queue.poll();
            if (A.get(i) != -1) {
                final TreeNode left = new TreeNode(A.get(i));
                parent.left = left;
                queue.add(left);
            }

            if (A.get(i + 1) != -1) {
                final TreeNode right = new TreeNode(A.get(i + 1));
                parent.right = right;
                queue.add(right);
            }

            i += 2;
        }

        return root;
    }
}
