package leetCode.linkedList;

import java.util.List;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLinkedList {
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
    }

    public static void main(String[] args) {
        final ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        final ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        final ListNode result = mergeTwoLists(list1, list2);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        final ListNode resultList = new ListNode();
        ListNode curr1;
        ListNode curr2;

        if (list1.val < list2.val) {
            resultList.val = list1.val;
            curr1 = list1.next;
            curr2 = list2;
        } else {
            resultList.val = list2.val;
            curr1 = list1;
            curr2 = list2.next;
        }

        ListNode currResult = resultList;

        while (curr1 != null && curr2 != null) {

            if (curr1.val < curr2.val) {
                currResult.next = curr1;
                curr1 = curr1.next;
            } else {
                currResult.next = curr2;
                curr2 = curr2.next;
            }
            currResult = currResult.next;
        }

        if (curr1 != null) {
            currResult.next = curr1;
        }

        if (curr2 != null) {
            currResult.next = curr2;
        }

        return resultList;
    }
}
