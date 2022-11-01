package scaler.linkedList;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode A = new ListNode(14, new ListNode(42, new ListNode(98, new ListNode(26, new ListNode(36, new ListNode(28, new ListNode(57, new ListNode(93, null))))))));

        System.out.println(solve(A));
    }

    private static int solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        return slow.val;
    }
}
