package scaler.linkedList;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        printLinkedList(solve(A));

        System.out.println("\n------");

        A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        printLinkedList(solve(A));
    }

    private static ListNode solve(ListNode A) {
        if (A.next == null) {
            return null;
        }
        ListNode prev = null;
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        if (prev != null) {
            prev.next = slow.next;
        }

        return A;
    }

    private static void printLinkedList(ListNode A) {
        ListNode temp = A;

        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
