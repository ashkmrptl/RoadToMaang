package scaler.linkedList;

/**
 * 0 x -1:     Add a node of value x before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * 1 x -1:     Append a node of value x to the last element of the linked list.
 * 2 x index:  Add a node of value x before the index node in the linked list. If index equals to the length of linked list,
 *             the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * 3 index -1: Delete the index node in the linked list, if the index is valid.
 *
 * A[i][0] represents the type of operation.
 */
public class DesignLinkedList {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {3, 1, -1},
                {3, 1, -1},
                {1, 18, -1},
                {2, 12, 1},
                {1, 17, -1},
                {2, 11, 3},
                {1, 19, -1},
                {3, 0, -1},
                {0, 12, -1}
        };

        ListNode node = solve(A);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    private static int length = 0;
    private static ListNode head = null;
    private static ListNode tail = null;

    public static ListNode solve(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int opern = A[i][0];
            int value = A[i][1];
            int index = A[i][2];

            if (opern == 0) {
                insert(0, value);
            } else if (opern == 1) {
                insert(length, value);
            } else if (opern == 2) {
                insert(length == index ? length : index, value);
            } else if (opern == 3) {
                index = A[i][1];
                delete(index);
            }
        }
        return head;
    }

    private static void insert(int position, int value) {
        final ListNode newNode = new ListNode(value);

        if (position == 0) {//Insert at beginning
            if (length == 0) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            length++;
        } else if (position == length) {//Insert at end
            tail.next = newNode;
            tail = newNode;
            length++;
        } else if (position < length) {//Insert in the middle
            ListNode temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
    }

    private static void delete(int position) {
        if (position < 0 || position >= length) {
            return;
        }

        if (position == 0) {//delete from head
            head = head.next;
            length--;
        } else if (position == length - 1) {//delete from tail
            ListNode temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            length--;
        } else if (position < length - 1) {//delete from the middle
            ListNode temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            length--;
        }

    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
