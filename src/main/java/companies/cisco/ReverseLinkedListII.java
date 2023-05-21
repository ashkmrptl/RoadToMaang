package companies.cisco;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int left = 2;
        int right = 4;

        ListNode node = reverseBetween(head, left, right);

        head = new ListNode(5);
        left = 1;
        right = 1;

        node = reverseBetween(head, left, right);
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode start = null;
        ListNode prevStart = null;

        ListNode end = null;
        ListNode nextEnd = null;

        ListNode curr = head;
        ListNode prev = null;

        int count = 1;

        while (curr != null) {
            if (count == left) {
                start = curr;
                prevStart = prev;
            } else if (count == right) {
                end = curr;
                nextEnd = curr.next;
            }

            prev = curr;
            curr = curr.next;

            count++;
        }

        reverse(start, end);

        if (prevStart != null) {
            prevStart.next = end;
        }

        start.next = nextEnd;

        return prevStart == null ? end : head;
    }

    private static void reverse(ListNode start, ListNode end) {
        ListNode current = start;
        ListNode previous = null;

        while (current != end) {
            ListNode temp = current.next;

            current.next = previous;
            previous = current;
            current = temp;
        }

        //Handle last node
        if (current != null) {
            current.next = previous;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
