package companies.walmart;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode answer;

        ListNode l1 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l2 = new ListNode(7, new ListNode(0, new ListNode(8)));

        //answer = addTwoNumbers(l1, l2);

        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        //answer = addTwoNumbers(l1, l2);

        l1 = new ListNode(3, new ListNode(7));
        l2 = new ListNode(9, new ListNode(2));

        answer = addTwoNumbers(l1, l2);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        int carry = 0;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            carry = sum / 10;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int sum = curr1.val + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int sum = curr2.val + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            curr2 = curr2.next;
        }

        while (carry > 0) {
            curr.next = new ListNode(carry % 10);
            curr = curr.next;

            carry = carry / 10;
        }

        return ans.next;
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
    }
}
