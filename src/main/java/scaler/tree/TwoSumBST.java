package scaler.tree;

import java.util.HashSet;
import java.util.List;

/**
 * Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 */
public class TwoSumBST {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(7, 5, 9, 4, 6, 8, 10, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A, 15));

        System.out.println(solve(A, 5));
    }

    private static int solve(TreeNode A, int B) {
        return findTwoSum(A, B, new HashSet<>());
    }

    private static int findTwoSum(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) return 0;
        if (set.contains(k - root.val)) return 1;
        else set.add(root.val);
        return (findTwoSum(root.left, k, set) | findTwoSum(root.right, k, set));
    }
}
