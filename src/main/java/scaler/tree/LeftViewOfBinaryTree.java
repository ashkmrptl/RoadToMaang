package scaler.tree;

import java.util.*;

public class LeftViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 1, 15, 2, -1, -1, -1, -1));
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(TreeNode A) {
        if (A == null) {
            return new int[]{};
        }

        final List<Integer> list = new ArrayList<>();
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        list.add(A.val);

        while (queue.size() > 1) {
            final TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    list.add(queue.peek().val);
                }
                queue.add(null);
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
