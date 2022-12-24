package scaler.tree;

import java.util.*;

//Approach is to use the level order traversal and to print the element just after the null
public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 1, 15, 2, -1, -1, -1, -1));
        System.out.println(Arrays.toString(solve_copied(A)));
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

        TreeNode prev = null;
        while (queue.size() > 1) {
            final TreeNode node = queue.poll();
            if (node == null) {
                list.add(prev.val);
                queue.add(null);
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
            prev = node;
        }

        list.add(prev.val);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private static int[] solve_copied(TreeNode A) {
        if (A == null) {
            return new int[]{};
        }

        final ArrayList<Integer> ans = new ArrayList<>();

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
