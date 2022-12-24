package scaler.tree;

import java.util.List;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1));
        System.out.println(solve(A, 22));

        A = DeserializeBinaryTree.solve(List.of(1000, 200, -1, -1, -1));
        System.out.println(solve(A, 1000));
    }

    private static int solve(TreeNode A, int B) {
        boolean ans = pathSum(A, B, 0);
        return ans ? 1 : 0;
    }

    private static boolean pathSum(TreeNode A, int B, int sum) {
        if (A == null) {
            return false;
        }

        if (sum + A.val == B  && A.left == null && A.right == null) {
            return true;
        }
        boolean x = pathSum(A.left, B, sum + A.val);
        boolean y = pathSum(A.right, B, sum + A.val);

        return x || y;
    }
}
