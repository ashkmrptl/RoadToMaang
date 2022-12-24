package scaler.tree;

import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 1, 15, 2, -1, -1, -1, -1));
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(TreeNode A) {
        if (A == null) {
            return new int[]{};
        }

        int leftMinLevel = 0;
        int rightMaxLevel = 0;

        final Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));

        final Map<Integer, List<Integer>> map = new HashMap<>();

        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();

            if (map.containsKey(pair.level)) {
                map.get(pair.level).add(pair.node.val);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(pair.node.val);
                map.put(pair.level, list);
            }

            if (pair.node.left != null) {
                leftMinLevel = Math.min(leftMinLevel, pair.level - 1);
                final Pair left = new Pair(pair.node.left, pair.level - 1);
                queue.add(left);
            }

            if (pair.node.right != null) {
                rightMaxLevel = Math.max(rightMaxLevel, pair.level + 1);
                final Pair right = new Pair(pair.node.right, pair.level + 1);
                queue.add(right);
            }
        }

        int n = rightMaxLevel - leftMinLevel + 1;
        int[] res = new int[n];

        for (int i = leftMinLevel, j = 0; i <= rightMaxLevel; i++, j++) {
            res[j] = map.get(i).get(0);
        }

        return res;
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
