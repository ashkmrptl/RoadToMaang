package scaler.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode A = DeserializeBinaryTree.solve(List.of(1, 2, 3));
        //System.out.println(Arrays.toString(solve(A)));

        A = DeserializeBinaryTree.solve(List.of(2, 3, 1));
        //System.out.println(Arrays.toString(solve(A)));

        A = DeserializeBinaryTree.solve(List.of(9, 5, 10, 12, 6, -1, 14, -1, -1, -1, 7, 2, 15));
        System.out.println(Arrays.toString(solve(A)));

        A = DeserializeBinaryTree.solve(List.of(344, 162, 345, 152, 181, -1, -1, 106, 161, 173, 261, 92, 133, 157, -1, 165, 178, 256, 329, 86, 104, 108, 137, 154, 160, 163, 171, 174, 179, 210, 258, 265, 335, 83, 87, 102, 105, 107, 114, 134, 147, 153, 155, 159, -1, -1, 164, 170, 172, -1, 176, -1, 180, 182, 221, 257, 259, 264, 311, 334, 337, 80, 85, -1, 90, 96, 103, -1, -1, -1, -1, 109, 132, -1, 135, 144, 148, -1, -1, -1, 156, 158, -1, -1, -1, 167, -1, -1, -1, 175, 177, -1, -1, -1, 202, 219, 223, -1, -1, -1, 260, 262, -1, 278, 314, 331, -1, 336, 339, 79, 82, 84, -1, 88, 91, 93, 97, -1, -1, -1, 113, 117, -1, -1, 136, 139, 145, -1, 150, -1, -1, -1, -1, 166, 168, -1, -1, -1, -1, 186, 208, 214, 220, 222, 245, -1, -1, -1, 263, 269, 304, 313, 319, 330, 333, -1, -1, 338, 341, -1, -1, 81, -1, -1, -1, -1, 89, -1, -1, -1, 95, -1, 98, 110, -1, 115, 125, -1, -1, 138, 141, -1, 146, 149, 151, -1, -1, -1, 169, 185, 193, 203, 209, 213, 218, -1, -1, -1, -1, 241, 247, -1, -1, 268, 276, 297, 307, 312, -1, 317, 328, -1, -1, 332, -1, -1, -1, 340, 343, -1, -1, -1, -1, 94, -1, -1, 99, -1, 111, 116, -1, 120, 128, -1, -1, 140, 142, -1, -1, -1, -1, -1, -1, -1, -1, 184, -1, 192, 198, -1, 206, -1, -1, 211, -1, 215, -1, 224, 244, 246, 250, 267, -1, 275, 277, 291, 299, 306, 308, -1, -1, 316, 318, 320, -1, -1, -1, -1, -1, 342, -1, -1, -1, -1, 101, -1, 112, -1, -1, 118, 122, 126, 130, -1, -1, -1, 143, 183, -1, 189, -1, 195, 200, 205, 207, -1, 212, -1, 217, -1, 227, 243, -1, -1, -1, 248, 251, 266, -1, 274, -1, -1, -1, 281, 295, 298, 301, 305, -1, -1, 309, 315, -1, -1, -1, -1, 323, -1, -1, 100, -1, -1, -1, -1, 119, 121, 124, -1, 127, 129, 131, -1, -1, -1, -1, 187, 190, 194, 196, 199, 201, 204, -1, -1, -1, -1, -1, 216, -1, 226, 239, 242, -1, -1, 249, -1, 253, -1, -1, 270, -1, 280, 290, 294, 296, -1, -1, 300, 302, -1, -1, -1, 310, -1, -1, 321, 325, -1, -1, -1, -1, -1, -1, 123, -1, -1, -1, -1, -1, -1, -1, -1, 188, -1, 191, -1, -1, -1, 197, -1, -1, -1, -1, -1, -1, -1, -1, 225, -1, 231, 240, -1, -1, -1, -1, 252, 254, -1, 272, 279, -1, 283, -1, 292, -1, -1, -1, -1, -1, -1, 303, -1, -1, -1, 322, 324, 327, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 228, 232, -1, -1, -1, -1, -1, 255, 271, 273, -1, -1, 282, 284, -1, 293, -1, -1, -1, -1, -1, -1, 326, -1, -1, 229, -1, 238, -1, -1, -1, -1, -1, -1, -1, -1, -1, 285, -1, -1, -1, -1, -1, 230, 237, -1, -1, 287, -1, -1, 235, -1, 286, 288, 233, 236, -1, -1, -1, 289, -1, 234, -1, -1, -1, -1, -1, -1));
        System.out.println(Arrays.toString(solve(A)));
    }

    /**
     * This can be solved using inorder traversal. Using the recursion method will have the SC O(H).
     * Can be solved with constant space using morris traversal
     */
    private static int[] solve(TreeNode A) {
        final List<Integer> res = new ArrayList<>();
        solveUsingRecursion(A, res);

        final int[] arr = new int[2];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        final List<Integer> resultByMorrisTraversal = solveUsingMorrisInOrderTraversal(A);
        Collections.sort(resultByMorrisTraversal);
        final int[] arr1 = new int[2];
        for (int i = 1; i >= 0; i--) {
            arr1[i] = resultByMorrisTraversal.get(i);
        }

        System.out.println(Arrays.toString(arr1));

        return arr;
    }

    private static List<Integer> solveUsingMorrisInOrderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();

        TreeNode current = A;
        TreeNode previous = null;

        while (current != null) {
            if (current.left == null) {
                if (previous != null && previous.val > current.val) {
                    if (list.isEmpty()) {
                        list.add(previous.val);
                    } else {
                        list.remove(1);
                    }
                    list.add(current.val);
                }
                previous = current;
                current = current.right;
            } else {
                //Find the inorder predecessor
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = current;
                    //previous = current;
                    current = current.left;
                } else {
                    temp.right = null;
                    if (previous != null && previous.val > current.val) {
                        if (list.isEmpty()) {
                            list.add(previous.val);
                        } else {
                            list.remove(1);
                        }
                        list.add(current.val);
                    }
                    previous = current;
                    current = current.right;
                }
            }
        }

        return list;
    }

    static TreeNode previous = null;

    private static void solveUsingRecursion(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        solveUsingRecursion(node.left, res);

        if (previous != null && previous.val > node.val) {
            if (res.isEmpty()) {
                res.add(previous.val);
                res.add(node.val);
            } else {
                res.remove(1);
                res.add(node.val);
            }
        }
        previous = node;

        solveUsingRecursion(node.right, res);
    }
}
