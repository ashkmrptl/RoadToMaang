package scaler.tree;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
 */
public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 1, 15, 2, 3, 8, 19, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A));
        System.out.println(solve_optimized(A));
    }

    /**
     * In this approach we use 2 stacks, one for storing even level nodes and one for odd level nodes.
     * Also while inserting the elements to the stack, we insert the nodes in reverse order as the required order os level.
     * Not working- Need to see why
     */
    private static ArrayList<ArrayList<Integer>> solve_optimized(TreeNode A) {
        if (A == null) {
            return null;
        }

        ArrayList<Integer> innerList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        final Stack<TreeNode> oddStack = new Stack<>();
        final Stack<TreeNode> evenStack = new Stack<>();

        //We will start with 0th level, hence adding root to the even stack
        evenStack.add(A);

        int level = 0;
        Stack<TreeNode> currentStack = evenStack;
        while (!currentStack.isEmpty()) {
            final TreeNode node = currentStack.pop();
            innerList.add(node.val);

            if (currentStack.isEmpty()) {
                level++;
                list.add(innerList);
                innerList = new ArrayList<>();
                if (level % 2 != 0) {
                    currentStack = oddStack;
                } else {
                    currentStack = evenStack;
                }
            }

            if (level % 2 != 0) {//Odd level
                if (node.left != null) {
                    currentStack.add(node.left);
                }
                if (node.right != null) {
                    currentStack.add(node.right);
                }
            } else {//Even level
                if (node.right != null) {
                    currentStack.add(node.right);
                }
                if (node.left != null) {
                    currentStack.add(node.left);
                }
            }
        }

        return list;
    }

    private static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        if (A == null) {
            return null;
        }
        boolean toggle = false;

        ArrayList<Integer> innerList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);

        while (queue.size() > 1) {
            final TreeNode node = queue.poll();

            if (node == null) {
                if (toggle) {
                    Collections.reverse(innerList);
                }
                list.add(innerList);
                innerList = new ArrayList<>();
                queue.add(null);
                toggle = !toggle;
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            innerList.add(node.val);
        }

        if (toggle) {
            Collections.reverse(innerList);
        }
        list.add(innerList);

        return list;
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
