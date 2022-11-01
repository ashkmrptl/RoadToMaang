package scaler.linkedList;

/**
 * Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Ex:
 * A = [1, 4, 3, 2, 5, 2]
 * B = 3
 * <p>
 * ans : [1, 2, 2, 4, 3, 5]
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode.print(solve(A, 3));
    }

    private static ListNode solve(ListNode A, int B) {
        ListNode small = new ListNode(-1, null);
        ListNode large = new ListNode(-1, null);

        ListNode smallTail = small;
        ListNode largeTail = large;

        while (A != null) {
            if (A.val < B) {
                smallTail.next = A;
                smallTail = smallTail.next;
            } else {
                largeTail.next = A;
                largeTail = largeTail.next;
            }
            ListNode temp = A.next;
            A.next = null;
            A = temp;
        }

        if (small.next == null) {
            return large.next;
        }
        if (large.next == null) {
            return small.next;
        }

        smallTail.next = large.next;

        return small.next;
    }
}
