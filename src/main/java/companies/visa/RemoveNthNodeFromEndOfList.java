package companies.visa;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode ans = remove(head, 2);

        head = new ListNode(1);

        ans = remove(head, 1);
    }

    //Brute force is to reverse, remove and reverse again.
    private static ListNode remove(ListNode head, int n) {
        final ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        if (left != null && left.next != null) {
            left.next = left.next.next;
        }

        return dummy.next;
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
