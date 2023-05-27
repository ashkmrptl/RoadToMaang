package companies.cisco;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
    public static void main(String[] args) {
        final LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print(cache.tail);

        cache.get(1);
        cache.print(cache.tail);

        cache.put(3, 3);
        cache.print(cache.tail);

        cache.get(2);
        cache.print(cache.tail);

        cache.put(4, 4);
        cache.print(cache.tail);

        cache.get(1);
        cache.print(cache.tail);

        cache.get(3);
        cache.print(cache.tail);

        cache.get(4);
        cache.print(cache.tail);

    }

    Node head;
    Node tail;
    final int capacity;
    final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        head.prev = tail;
        tail.next = head;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            final Node node = map.get(key);

            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;

            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        final Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;

            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;
        } else {
            if (map.size() == capacity) {
                final int keyToRemove = tail.next.key;
                tail.next = tail.next.next;
                tail.next.prev = tail;

                map.remove(keyToRemove);
            }
            node = new Node(key, value);

            node.next = head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;

            map.put(key, node);
        }
    }

    public void print(Node A) {
        Node temp = A;

        while (temp != null) {
            System.out.print((Objects.isNull(temp.val) ? "Dummy" : temp.val) + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class Node {
        Integer key;
        Integer val;
        Node next;
        Node prev;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
