package companies.cisco;

public class AddTwoNumbers {
    public static void main(String[] args) {

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
