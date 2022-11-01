package scaler.linkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static void print(ListNode A) {
        ListNode temp = A;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}