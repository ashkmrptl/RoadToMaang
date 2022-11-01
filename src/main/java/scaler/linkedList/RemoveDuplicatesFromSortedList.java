package scaler.linkedList;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(2, new ListNode(2, new ListNode(5, new ListNode(5, new ListNode(5, null)))));
        ListNode.print(solve(A));
    }

    private static ListNode solve(ListNode A) {
        ListNode current = A;
        ListNode currentNext;

        while (current != null) {
            currentNext = current.next;

            while (currentNext != null && current.val == currentNext.val) {
                current.next = currentNext.next;
                currentNext = currentNext.next;
            }
            current = current.next;
        }

        return A;
    }
}
