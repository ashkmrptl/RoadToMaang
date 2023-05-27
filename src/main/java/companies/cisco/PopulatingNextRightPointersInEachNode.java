package companies.cisco;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null);
        connect(root);
    }

    private static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Node prev = null;
        while (queue.size() > 1) {
            final Node node = queue.poll();
            if (prev != null) {
                prev.next = node;
            }

            if (node == null) {
                prev = null;
                queue.add(null);
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                prev = node;
            }
        }

        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
