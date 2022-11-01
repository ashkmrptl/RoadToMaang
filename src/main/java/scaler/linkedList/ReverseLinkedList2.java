package scaler.linkedList;

/**
 * Reverse a linked list A from position B to C.
 * NOTE: Do it in-place and in one-pass.
 * Example:
 * A = 1 -> 2 -> 3 -> 4 -> 5
 * B = 2
 * C = 4
 * <p>
 * Ans:
 * 1 -> 4 -> 3 -> 2 -> 5
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode.print(solve(A, 1, 2));
        System.out.println();
        A = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode.print(solve(A, 2, 3));
    }

    private static ListNode solve(ListNode A, int B, int C) {
        ListNode prev = null;
        ListNode curr = A;

        int index = 1;

        ListNode revStart = null;
        ListNode revStartPrev = null;

        ListNode revEnd = null;
        ListNode revEndNext = null;

        while (curr != null) {
            if (index + 1 == B) {
                revStartPrev = curr;
            }
            if (index == B) {
                revStart = curr;
            }

            if (index == C + 1) {
                revEndNext = curr;
            }
            if (index == C) {
                revEnd = curr;
            }

            if (index < B || index > C) {//Normal traversal
                curr = curr.next;
            } else {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            index++;
        }

        revStart.next = revEndNext;
        if (revStartPrev != null) {
            revStartPrev.next = revEnd;
        }

        return B == 1 ? revEnd : A;
    }
}
