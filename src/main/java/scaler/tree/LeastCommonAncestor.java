package scaler.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 */
public class LeastCommonAncestor {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));
        System.out.println(solve(A, 4, 6));
        System.out.println(solve(A, 8, 9));
        System.out.println(solve(A, 4, 9));
        System.out.println(solve(A, 5, 6));
    }

    private static int solve(TreeNode A, int B, int C) {
        final List<Integer> pathB = new ArrayList<>();
        findPath(A, B, pathB);

        final List<Integer> pathC = new ArrayList<>();
        findPath(A, C, pathC);

        Collections.reverse(pathB);
        Collections.reverse(pathC);

        int i = 0;
        int j = 0;

        int ans = -1;

        while (i < pathB.size() && j < pathC.size()) {
            if (pathB.get(i).equals(pathC.get(j))) {
                ans = pathB.get(i);
                i++;
                j++;
            } else {
                break;
            }
        }

        return ans;
    }

    private static boolean findPath(TreeNode node, int val, List<Integer> path) {
        if (node == null) {
            return false;
        }

        if (node.val == val) {
            path.add(node.val);
            return true;
        }

        boolean foundOnLeft = findPath(node.left, val, path);
        boolean foundOnRight = findPath(node.right, val, path);
        if (foundOnLeft || foundOnRight) {
            path.add(node.val);
            return true;
        }
        return false;
    }
}
