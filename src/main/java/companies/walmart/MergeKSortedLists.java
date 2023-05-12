package companies.walmart;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode ans = mergeKLists(new ListNode[]{l1, l2, l3});
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length - 1);
    }

    private static ListNode divide(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[end];
        }

        int mid = (start + end) / 2;

        final ListNode left = divide(lists, start, mid);
        final ListNode right = divide(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        final ListNode merged = new ListNode(-1);
        ListNode curr = merged;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr.next = new ListNode(curr1.val);
                curr1 = curr1.next;
            } else {
                curr.next = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            curr = curr.next;
        }

        while (curr1 != null) {
            curr.next = new ListNode(curr1.val);
            curr1 = curr1.next;
            curr = curr.next;
        }

        while (curr2 != null) {
            curr.next = new ListNode(curr2.val);
            curr2 = curr2.next;
            curr = curr.next;
        }

        return merged.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
