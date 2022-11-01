package scaler.linkedList;

/**
 * Given a linked list A, remove the B-th node from the end of the list and return its head.
 * For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.
 * NOTE: If B is greater than the size of the list, remove the first node of the list.
 * NOTE: Try doing it using constant additional space.
 */
public class RemoveNthNodeFromListEnd {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode.print(solve(A, 2));
    }

    private static ListNode solve(ListNode A, int B) {
        if (A == null || (A.next == null && B > 0)) {
            return null;
        }

        int n = 1;
        ListNode current = A;
        while (current.next != null) {
            current = current.next;
            n++;
        }

        int k = n - B + 1;

        if (k == 1 || k < 1) {
            A = A.next;
        } else {
            current = A;
            ListNode prevoius = null;

            while (k > 1) {
                prevoius = current;
                current = current.next;
                k--;
            }

            prevoius.next = current.next;
        }

        return A;
    }
}
