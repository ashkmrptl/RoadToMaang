package scaler.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
    static class ListNode {
        Integer key;
        Integer value;

        ListNode next;
        ListNode prev;

        ListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    int size;
    final int capacity;

    ListNode head;
    ListNode tail;
    final Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        final ListNode dummyHead = new ListNode(null, null);
        final ListNode dummyTail = new ListNode(null, null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        head = dummyHead;
        tail = dummyTail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //Move the node to the tail of the LL
            ListNode node = map.get(key);

            //Detach the node from LL
            node.prev.next = node.next;
            node.next.prev = node.prev;

            //Add node to tail
            node.next = tail;
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;

            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            //Move node to tail
            final ListNode node = map.get(key);
            node.value = value;

            //Detach the node from LL
            node.prev.next = node.next;
            node.next.prev = node.prev;

            //Add node to tail
            node.next = tail;
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
        } else {
            final ListNode newNode = new ListNode(key, value);
            //Check the size
            if (size == capacity) {//Remove from head and map
                int keyToRemove = head.next.key;
                head.next = head.next.next;
                head.next.prev = head;

                map.remove(keyToRemove);
                size--;
            }
            //Add to tail
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev = newNode;
            newNode.prev.next = newNode;

            map.put(key, newNode);
            size++;
        }
    }

    public static void main(String[] args) {
        final LRUCache lruCache = new LRUCache(1);

        lruCache.set(2, 1);

        System.out.println(lruCache.get(2));

        lruCache.set(3, 2);

        System.out.println(lruCache.get(2));

        System.out.println(lruCache.get(3));
    }

    public void print(ListNode A) {
        ListNode temp = A;

        while (temp != null) {
            System.out.print((Objects.isNull(temp.value) ? "Dummy" : temp.value) + " ");
            temp = temp.next;
        }
    }
}
