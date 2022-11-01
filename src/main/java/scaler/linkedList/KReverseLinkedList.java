package scaler.linkedList;

/**
 * Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
 * B always divides A
 * <p>
 * Ex :
 * A = [1, 2, 3, 4, 5, 6]
 * B = 2
 * <p>
 * For the first example, the list can be reversed in groups of 2.
 * [[1, 2], [3, 4], [5, 6]]
 * After reversing the K-linked list
 * [[2, 1], [4, 3], [6, 5]]
 */
public class KReverseLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode.print(solve(A, 2));
    }

    private static ListNode solve(ListNode A, int B) {
        ListNode prev = null;
        ListNode curr = A;

        ListNode temp;

        int count = B;

        while (curr != null && count > 0) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;
        }

        if (curr != null) {
            A.next = solve(curr, B);
        }
        return prev;
    }
}
