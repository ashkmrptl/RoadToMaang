package scaler.tree;

import java.util.*;

/**
 * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
 * <p>
 * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
 * <p>
 * NOTE:
 * <p>
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 */
public class SerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1));
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(TreeNode A) {
        final List<Integer> list = new ArrayList<>();
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            list.add(node.val);

            if (node.val == -1) {
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
            } else {
                queue.add(new TreeNode(-1));
            }

            if (node.right != null) {
                queue.add(node.right);
            } else {
                queue.add(new TreeNode(-1));
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
