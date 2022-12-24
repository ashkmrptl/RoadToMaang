package scaler.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInOrderAndPreOrder {
    public static void main(String[] args) {
        int[] B = new int[]{1, 2, 3, 4, 5};
        int[] A = new int[]{3, 2, 4, 1, 5};
        solve(A, B);
    }

    private static TreeNode solve(int[] A, int[] B) {//A is preorder, B is inorder
        int preOrderStart = 0, preOrderEnd = A.length - 1; //preorder -> Root Left Right
        int inOrderStart = 0, inOrderEnd = B.length - 1; //inorder -> Left Root Right

        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            map.put(A[i], i);
        }

        return construct(A, preOrderStart, preOrderEnd, B, inOrderStart, inOrderEnd, map);
    }

    private static TreeNode construct(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd, Map<Integer, Integer> map) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }

        int rootVal = preOrder[preOrderStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = map.get(rootVal); //get inorder index of the root
        int length = rootIndex - inOrderStart;

        //calculating the start and end index for preorder & inorder
        root.left = construct(preOrder, preOrderStart + 1, preOrderStart + length, inOrder, inOrderStart, rootIndex - 1, map);
        root.right = construct(preOrder, preOrderStart + length + 1, preOrderEnd, inOrder, rootIndex + 1, inOrderEnd, map);

        return root;
    }
}
