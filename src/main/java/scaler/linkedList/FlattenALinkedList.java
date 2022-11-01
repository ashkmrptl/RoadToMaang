package scaler.linkedList;

/**
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 * <p>
 * Pointer to next node in the main list (right pointer)
 * Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
 * You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
 */
public class FlattenALinkedList {
    static class ListNode {
        int val;
        ListNode right, down;

        ListNode(int x) {
            val = x;
            right = down = null;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    //Approach is to use merge sort. Consider each element as a separate LL
    private static ListNode solve(ListNode root) {
        if (root == null || root.right == null)
            return root;
        ListNode temp = null, fast = root, slow = root;

        while (fast != null && fast.right != null) {
            temp = slow;
            fast = fast.right.right;
            slow = slow.right;
        }

        temp.right = null;
        ListNode temp1 = solve(root);
        ListNode temp2 = solve(slow);
        return sortedMerge(temp1, temp2);
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
            A = A.down;
        } else {
            result = B;
            tail = B;
            B = B.down;
        }

        while (A != null && B != null) {
            if (A.val <= B.val) {
                tail.down = A;
                A = A.down;
            } else {
                tail.down = B;
                B = B.down;
            }
            tail = tail.down;
        }

        if (A != null) {
            tail.down = A;
        }

        if (B != null) {
            tail.down = B;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode seven1 = new ListNode(7);
        ListNode seven2 = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode four = new ListNode(2);
        ListNode eleven = new ListNode(11);
        ListNode twenty1 = new ListNode(20);
        ListNode twentyTwo = new ListNode(22);
        ListNode twenty2 = new ListNode(8);
        ListNode twenty3 = new ListNode(20);
        ListNode twentyEight = new ListNode(28);
        ListNode thirtyNine1 = new ListNode(39);
        ListNode thirty = new ListNode(1);
        ListNode thirtyOne = new ListNode(31);
        ListNode thirtyNine2 = new ListNode(39);

        three.right = four;
        four.right = twenty1;
        twenty1.right = twenty2;
        twenty2.right = thirty;

        three.down = seven1;
        seven1.down = seven2;
        seven2.down = eight;

        four.down = eleven;

        twenty1.down = twentyTwo;

        twenty2.down = twenty3;
        twenty3.down = twentyEight;
        twentyEight.down = thirtyNine1;

        thirty.down = thirtyOne;
        thirtyOne.down = thirtyNine2;

        System.out.println(solve(three));
    }
}
