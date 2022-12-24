package scaler.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
 * NOTE: Consider the level of root node as 1.
 */
public class OddAndEvenLevels {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 1, 15, 2, -1, -1, -1, -1));
        System.out.println(solve(A));
    }

    private static int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int evenSum = 0;
        int oddSum = 0;

        final Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 1));

        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();

            if (pair.level % 2 == 0) {
                evenSum += pair.node.val;
            } else {
                oddSum += pair.node.val;
            }

            if (pair.node.left != null) {
                queue.add(new Pair(pair.node.left, pair.level + 1));
            }

            if (pair.node.right != null) {
                queue.add(new Pair(pair.node.right, pair.level + 1));
            }
        }

        return oddSum - evenSum;
    }

    private static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
