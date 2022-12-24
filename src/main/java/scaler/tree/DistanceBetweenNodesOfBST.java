package scaler.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistanceBetweenNodesOfBST {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3, 4, 5, 7, 9, -1, -1, 6, -1, -1, 8, -1, -1));
        System.out.println(solve(A, 2, 9));

        A = DeserializeBinaryTree.solve(List.of(27, 19, 44, 10, 24, 36, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A, 27, 36));

        A = DeserializeBinaryTree.solve(List.of(27, 19, 44, 10, 24, 36, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A, 27, 27));
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

        while (i < pathB.size() && j < pathC.size()) {
            if (pathB.get(i).equals(pathC.get(j))) {
                i++;
                j++;
            } else {
                break;
            }
        }

        return (pathB.size() - i) + (pathC.size() - j);
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
