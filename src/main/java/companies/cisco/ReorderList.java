package companies.cisco;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(head);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);
    }

    private static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //Find mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = slow.next;

        //Detach from mid
        slow.next = null;

        //Reverse the second half
        ListNode reversedSecond = reverse(second);

        while (first != null && reversedSecond != null) {
            final ListNode temp1 = first.next;
            final ListNode temp2 = reversedSecond.next;

            first.next = reversedSecond;
            reversedSecond.next = temp1;

            first = temp1;
            reversedSecond = temp2;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            final ListNode temp = current.next;

            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
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
