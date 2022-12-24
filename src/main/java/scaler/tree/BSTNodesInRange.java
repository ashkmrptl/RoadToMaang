package scaler.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree of integers. You are given a range B and C.
 * <p>
 * Return the count of the number of nodes that lie in the given range.
 */
public class BSTNodesInRange {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(32, 25, 46, 17, 27, 40, 49, 9, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A, 11, 26));
    }

    private static int solve(TreeNode A, int B, int C) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(A, inOrder, B, C);

        return inOrder.size();
    }

    private static void inOrder(TreeNode node, List<Integer> list, int B, int C) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list, B, C);
        if (B <= node.val && C >= node.val) {
            list.add(node.val);
        }
        inOrder(node.right, list, B, C);
    }
}
