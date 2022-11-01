package scaler.linkedList;

import java.util.Objects;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Try solving it using constant additional space.
 */
public class ListCycle {
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

        System.out.println(solve(one) != null ? Objects.requireNonNull(solve(one)).val : null);
    }

    /**
     * There are three steps to it.
     * 1st: Check if cycle exists.
     * 1st: Take two pointers, slow and fast and check if they meet.
     * 2nd: Find their meeting point.
     * 3rd: Once meeting point is found, move slow to head of the LL and run both the pointer with slow speed, the node where they meet is the node where cycle begins.
     */
    private static ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        boolean isCycleFound = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycleFound = true;
                break;
            }
        }

        if (isCycleFound) {
            slow = A;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        } else {
            return null;
        }
    }
}
