package companies.intuit;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Approach: This can be solved using two stacks. The first one contains the elements
 * and the second one is used for finding the min element at any given moment in O(1) TC
 */
public class MinStack {
    public static void main(String[] args) {
        String[] arr = new String[] {"MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"};
        int[][] inputs = new int[][] {{},{2},{0},{3},{0},{},{},{},{},{},{},{}};

        MinStack minStack = null;
        for (int i = 0; i < arr.length; i++) {
            String operation = arr[i];

            if (operation.equals("MinStack")) {
                minStack = new MinStack();
            } else if (operation.equals("push")) {
                int[] input = inputs[i];
                for (int j = 0; j < input.length; j++) {
                    minStack.push(input[j]);
                }
            } else if (operation.equals("getMin")) {
                System.out.println(minStack.getMin());
            } else if (operation.equals("pop")) {
                minStack.pop();
            } else if (operation.equals("top")) {
                System.out.println(minStack.top());
            }
        }
    }

    final Stack<Integer> min;
    final Stack<Integer> stack;

    public MinStack() {
        min = new Stack<>();
        stack = new Stack<>();
    }

    private void push(int val) {
        stack.push(val);

        if (min.isEmpty() || (val <= min.peek())) {
            min.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (popped == min.peek()) {
                min.pop();
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }

        return stack.peek();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return 0;
        }

        return min.peek();
    }
}
