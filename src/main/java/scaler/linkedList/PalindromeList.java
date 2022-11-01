package scaler.linkedList;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1, null))))))));
        //System.out.println(solve(A));

        A = new ListNode(3, new ListNode(3, null));
        //System.out.println(solve(A));

        A = new ListNode(8, new ListNode(1, null));
        System.out.println(solve(A));
    }

    /**
     * Approach:
     * Find the mid of the linked list.
     * Break it from mid.
     * Reverse the second half.
     * take two pointer and iterate from head of each LL
     */
    private static int solve(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }

        final ListNode mid = findMid(A);
        ListNode left = A;
        ListNode right = mid.next;

        //Break from middle
        mid.next = null;

        //Reverse the second half
        right = reverse(right);

        while (left != null && right != null) {
            if (left.val != right.val) {
                return 0;
            }
            left = left.next;
            right = right.next;
        }

        return 1;
    }

    private static ListNode findMid(ListNode A) {
        ListNode slow = A;
        ListNode fast = A.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }

    private static ListNode reverse(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode temp;
        ListNode prev = null;

        while (A != null) {
            temp = A.next;
            A.next = prev;
            prev = A;
            A = temp;
        }
        return prev;
    }
}
