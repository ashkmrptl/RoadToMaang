package algoexpert.linkedlist;

//https://www.algoexpert.io/questions/remove-duplicates-from-linked-list
public class RemoveDuplicatesFromLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList curr = linkedList;

        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return linkedList;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 3, 4, 4, 4, 5, 6, 6};

        LinkedList ll = new LinkedList(A[0]);
        LinkedList curr = ll;

        for (int i = 1; i < A.length; i++) {
            curr.next = new LinkedList(A[i]);
            curr = curr.next;
        }

        LinkedList res = removeDuplicatesFromLinkedList(ll);

        while (res != null) {
            System.out.print(res.value + "->");
            res = res.next;
        }
    }
}
