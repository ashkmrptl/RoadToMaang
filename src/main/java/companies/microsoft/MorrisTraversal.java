package companies.microsoft;

public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(-2, null, new TreeNode(2, new TreeNode(-1), null)), new TreeNode(6, null, new TreeNode(8))),
                new TreeNode(30, null, new TreeNode(40)));
        inorder(root);
        System.out.println();
        preOrder(root);
    }

    private static void inorder(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            //Print the node if current.left is null and go right
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                //Find the inorder predecessor
                TreeNode inorderPredecessor = current.left;
                //Keep going right till predecessor.right is null
                while (inorderPredecessor.right != current && inorderPredecessor.right != null) {
                    inorderPredecessor = inorderPredecessor.right;
                }

                //If right is null, create a temporary link
                if (inorderPredecessor.right == null) {
                    inorderPredecessor.right = current;
                    current = current.left;
                } else {//It signifies the left tree is visited, and we break the temporary link created
                    inorderPredecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    private static void preOrder(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            //Print the node if current.left is null and go right
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                //Find the inorder predecessor
                TreeNode inorderPredecessor = current.left;
                //Keep going right till predecessor.right is null
                while (inorderPredecessor.right != current && inorderPredecessor.right != null) {
                    inorderPredecessor = inorderPredecessor.right;
                }

                //If right is null, create a temporary link
                if (inorderPredecessor.right == null) {
                    inorderPredecessor.right = current;
                    System.out.print(current.val + " ");
                    current = current.left;
                } else {//It signifies the left tree is visited, and we break the temporary link created
                    inorderPredecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
