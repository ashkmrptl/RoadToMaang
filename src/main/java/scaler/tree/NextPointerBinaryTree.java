package scaler.tree;

/**
 * Given a binary tree,
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * *NOTE: Assume perfect binary tree and try to solve this in constant extra space.
 * If not a perfect binary tree then the optimal way to make this is using level order traversal using extra space.
 */
public class NextPointerBinaryTree {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode A = new TreeLinkNode(1);
        A.left = new TreeLinkNode(2);
        A.right = new TreeLinkNode(3);
        solve(A);
    }

    /**
     * Approach 1: This can be solved by using a queue(extra space) with SC O(H) and TC O(n) like a level order traversal.
     * Approach 2: This can be solved without using extra space like the linked list program with random link.
     * We have to use the existing link to store the next level nodes.
     */
    private static void solve(TreeLinkNode A) {
        TreeLinkNode current = A;

        while (current != null && current.left != null) {
            TreeLinkNode temp = current;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            current = current.left;
        }

    }
}
