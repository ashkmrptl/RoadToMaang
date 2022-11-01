package scaler.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode.print(solve(A));
    }

    private static ListNode solve(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
