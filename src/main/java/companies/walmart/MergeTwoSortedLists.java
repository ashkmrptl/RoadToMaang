package companies.walmart;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode ans = mergeTwoLists(list1, list2);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode next1 = list1;
        ListNode next2 = list2;

        ListNode ans;
        if (next1.val < next2.val) {
            ans = next1;
            next1 = next1.next;
        } else {
            ans = next2;
            next2 = next2.next;
        }

        ListNode curr = ans;
        while (next1 != null && next2 != null) {
            if (next1.val < next2.val) {
                curr.next = next1;
                next1 = next1.next;
            } else {
                curr.next = next2;
                next2 = next2.next;
            }
            curr = curr.next;
        }

        while (next1 != null) {
            curr.next = next1;
            next1 = next1.next;
            curr = curr.next;
        }

        while (next2 != null) {
            curr.next = next2;
            next2 = next2.next;
            curr = curr.next;
        }

        curr.next = null;
        return ans;
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
            return "[" + val + "]";
        }
    }
}
