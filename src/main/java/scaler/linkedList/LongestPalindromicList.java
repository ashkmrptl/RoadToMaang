package scaler.linkedList;

public class LongestPalindromicList {
    public static void main(String[] args) {
        ListNode A = new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(2, null))))))))));
        System.out.println(solve(A));
    }

    /**
     * Approach :
     *    Approach is to fix each element as mid, then traverse both forward and backward while comparing.
     *    While traversing for each element also reverse the array, so that after fixing mid we can traverse both forward and backward direction.
     *    Do it for both odd and even length LL
     */
    private static int solve(ListNode A) {
        ListNode prev = null, curr = A;
        int result = 0;
        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            result = Math.max(result, 2 * count(prev, currNext) + 1);
            result = Math.max(result, 2 * count(curr, currNext));
            prev = curr;
            curr = currNext;
        }
        return result;
    }

    private static int count(ListNode backward, ListNode forward) {
        int count = 0;
        while (backward != null && forward != null) {
            if (backward.val == forward.val) {
                count++;
            } else {
                break;
            }
            backward = backward.next;
            forward = forward.next;
        }
        return count;
    }

}
