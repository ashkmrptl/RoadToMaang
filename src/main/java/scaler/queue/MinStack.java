package scaler.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * NOTE:
 * All the operations have to be constant time operations.
 * getMin() should return -1 if the stack is empty.
 * pop() should return nothing if the stack is empty.
 * top() should return -1 if the stack is empty.
 */
public class MinStack {
    public static void main(String[] args) {
        System.out.println(getMin());
        System.out.println(top());
        System.out.println(top());
        push(593848644);
        System.out.println(top());
        pop();
        System.out.println(top());
        System.out.println(top());
        System.out.println(top());
        System.out.println(top());
        pop();
        push(680232627);
        push(383101258);
        push(240914318);
        System.out.println(getMin());
        System.out.println(top());
        System.out.println(top());
        System.out.println(getMin());
        System.out.println(getMin());
        System.out.println(getMin());
        pop();
        System.out.println(top());
        push(213391515);
        pop();
        System.out.println(getMin());
        pop();
    }

    //Following is from mine, while running is scaler console, remove static from class level variables
    final static Stack<Integer> stack = new Stack<>();
    final static Deque<Integer> deque = new LinkedList<>();

    public static void push(int x) {
        stack.add(x);
        if (deque.isEmpty()) {
            deque.add(x);
        } else if (x < deque.peekLast()) {
            deque.add(x);
        }
    }

    public static void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int x = stack.pop();
        if (!deque.isEmpty() && deque.peekLast() == x) {
            deque.removeLast();
        }
    }

    public static int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public static int getMin() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    //Following is using two stacks, copied from discussions
    /*final static Stack<Integer> stack = new Stack<>();
    final static Stack<Integer> minStack = new Stack<>();

    public static void push(int x) {
        if (stack.isEmpty() || x < minStack.peek())
            minStack.push(x);
        else
            minStack.push(minStack.peek());

        stack.push(x);
    }

    public static void pop() {
        if (stack.isEmpty())
            return;
        stack.pop();
        minStack.pop();
    }

    public static int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public static int getMin() {
        if (stack.isEmpty())
            return -1;
        return minStack.peek();
    }*/
}
