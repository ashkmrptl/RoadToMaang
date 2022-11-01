package scaler.linkedList;

/**
 * Given a singly linked list A
 * <p>
 * A: A0 → A1 → … → An-1 → An
 * reorder it to:
 * <p>
 * A0 → An → A1 → An-1 → A2 → An-2 → …
 * You must do this in-place without altering the nodes' values.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode.print(solve(A));

        System.out.println();

        A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode.print(solve(A));
    }

    private static ListNode solve(ListNode A) {
        //Find mid
        ListNode slow = A;
        ListNode fast = A;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode B = mid.next;

        //Detach linked list from mid
        mid.next = null;

        //Reverse the second linked list
        ListNode curr = B;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        B = prev;

        //merge the linked list
        ListNode currA = A;
        ListNode currB = B;

        while (currA != null && currB != null) {
            ListNode tempA = currA.next;
            ListNode tempB = currB.next;

            currA.next = currB;
            currB.next = tempA;

            currA = tempA;
            currB = tempB;
        }

        return A;
    }
}
