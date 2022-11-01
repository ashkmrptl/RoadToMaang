package scaler.linkedList;

public class SortLinkedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(14, new ListNode(42, new ListNode(98, new ListNode(26, new ListNode(36, new ListNode(28, new ListNode(57, new ListNode(93, null))))))));

        ListNode.print(mergeSort(A));
    }

    //Merge sort algo
    private static ListNode mergeSort(ListNode h) {
        if (h == null || h.next == null) {
            return h;
        }

        ListNode middle = getMiddle(h);
        ListNode nextOfMiddle = middle.next;

        middle.next = null;

        ListNode left = mergeSort(h);
        ListNode right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private static ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;


        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }

    private static ListNode sortedMerge(ListNode A, ListNode B) {
        ListNode result;
        ListNode tail;

        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        if (A.val <= B.val) {
            result = A;
            tail = A;
            A = A.next;
        } else {
            result = B;
            tail = B;
            B = B.next;
        }

        while (A != null && B != null) {
            if (A.val <= B.val) {
                tail.next = A;
                A = A.next;
            } else {
                tail.next = B;
                B = B.next;
            }
            tail = tail.next;
        }

        if (A != null) {
            tail.next = A;
        }

        if (B != null) {
            tail.next = B;
        }

        return result;
    }
}
