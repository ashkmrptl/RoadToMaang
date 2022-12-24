package scaler.tree;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 1, 15, 2, -1, -1, -1, -1));
        System.out.println(solve(A));
    }

    private static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        if (A == null) {
            return new ArrayList<>();
        }

        int leftMinLevel = 0;
        int rightMaxLevel = 0;

        final Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));

        final Map<Integer, List<Integer>> levelElementsMap = new HashMap<>();

        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();

            if (levelElementsMap.containsKey(pair.level)) {
                levelElementsMap.get(pair.level).add(pair.node.val);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(pair.node.val);
                levelElementsMap.put(pair.level, list);
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

        final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = leftMinLevel; i <= rightMaxLevel; i++) {
            ans.add((ArrayList<Integer>) levelElementsMap.get(i));
        }

        return ans;
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
