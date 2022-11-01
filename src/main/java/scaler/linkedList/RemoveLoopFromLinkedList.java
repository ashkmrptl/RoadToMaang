package scaler.linkedList;

public class RemoveLoopFromLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1, null);
        ListNode two = new ListNode(2, null);
        ListNode three = new ListNode(3, null);
        ListNode four = new ListNode(4, null);
        ListNode five = new ListNode(5, null);
        ListNode six = new ListNode(6, null);
        ListNode seven = new ListNode(7, null);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = five;

        ListNode.print(solve(one));
    }

    private static ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            ListNode prev = null;
            slow = A;

            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            if (prev != null) {
                prev.next = null;
            }

        }
        return A;
    }
}
