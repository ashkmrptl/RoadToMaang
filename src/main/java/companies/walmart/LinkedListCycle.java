package companies.walmart;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}