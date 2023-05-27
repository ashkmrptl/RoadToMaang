package companies.cisco;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.next = two;
        one.random = three;

        two.next = three;
        two.random = one;

        three.next = four;
        three.random = three;

        four.random = two;

        Node ans = copyRandomList(one);
    }

    private static Node copyRandomList(Node head) {
        //Create new nodes
        Node curr = head;

        while (curr != null) {
            final Node temp = curr.next;
            final Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }

        //SetRandomPointers
        curr = head;

        while (curr != null && curr.next != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }

        final Node ans = head.next;

        //Separate links
        curr = head;

        while (curr.next != null) {
            Node temp = curr.next;
            curr.next = curr.next.next;
            curr = temp;
        }

        return ans;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
