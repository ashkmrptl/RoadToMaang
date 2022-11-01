package scaler.linkedList;

import java.util.Scanner;

public class LinkedListProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {
            String operation = s.next();

            if (operation.equals("i")) {
                int position = s.nextInt();
                int value = s.nextInt();
                insert_node(position, value);
            } else if (operation.equals("p")) {
                System.out.println();
                print_ll();
            } else {
                int position = s.nextInt();
                delete_node(position);
            }
        }

    }

    public static void insert_node(int position, int value) {
        position--;
        final Node newNode = new Node(value);

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
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
    }

    public static void delete_node(int position) {
        position--;
        if (position < 0 || position >= length) {
            return;
        }

        if (position == 0) {//delete from head
            head = head.next;
            length--;
        } else if (position == length - 1) {//delete from tail
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            length--;
        } else if (position < length - 1) {//delete from the middle
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            length--;
        }
    }

    public static void print_ll() {
        if (length < 1) {
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    private static int length = 0;
    private static Node head = null;
    private static Node tail = null;
}
