package scaler.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST),
 * where each internal node (non-leaf nodes) have exactly one child.
 */
public class CheckBSTWithOneChild {
    public static void main(String[] args) {
        int[] A = new int[]{4, 10, 5, 8};
        System.out.println(solve(A));
        System.out.println(solveOptimized(A));

        A = new int[]{1, 5, 6, 4};
        System.out.println(solve(A));
        System.out.println(solveOptimized(A));
    }

    private static String solveOptimized(int[] A) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;

        int root = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > root) {
                left = root;
            } else {
                right = root;
            }

            if (A[i] < left || A[i] > right) {
                return "NO";
            }

            root = A[i];
        }
        return "YES";
    }

    private static String solve(int[] A) {
        //Create one child tree
        final TreeNode node = new TreeNode(A[0]);
        TreeNode curr = node;
        for (int i = 1; i < A.length; i++) {
            final TreeNode temp = new TreeNode(A[i]);
            if (A[i] < curr.val) {
                curr.left = temp;
            } else {
                curr.right = temp;
            }
            curr = temp;
        }

        boolean isBST = isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

        if (!isBST) {
            return "NO";
        }

        //Check pre-order of BSt with the array
        List<Integer> preOder = new ArrayList<>();
        getPreOrder(node, preOder);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != preOder.get(i)) {
                return "NO";
            }
        }

        return "YES";
    }

    //Checking BST using pre-order traversal
    private static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (min > node.val || max < node.val) {
            return false;
        }

        boolean isLeftBST = isBST(node.left, min, node.val - 1);
        boolean isRightBST = isBST(node.right, node.val + 1, max);

        return isLeftBST && isRightBST;
    }

    private static void getPreOrder(TreeNode node, List<Integer> preOrder) {
        if (node == null) {
            return;
        }

        preOrder.add(node.val);
        getPreOrder(node.left, preOrder);
        getPreOrder(node.right, preOrder);
    }
}
