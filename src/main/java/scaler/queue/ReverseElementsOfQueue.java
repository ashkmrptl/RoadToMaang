package scaler.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.
 * NOTE: You are required to first insert the elements into an auxiliary queue then perform Reversal of first B elements.
 */
public class ReverseElementsOfQueue {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solve(A, 3)));

        A = new int[]{5, 17, 100, 11};
        System.out.println(Arrays.toString(solve(A, 1)));

        A = new int[]{5, 17, 100, 11};
        System.out.println(Arrays.toString(solve(A, 2)));

        A = new int[]{5, 17, 100, 11};
        System.out.println(Arrays.toString(solve(A, 3)));

        A = new int[]{5, 17, 100, 11};
        System.out.println(Arrays.toString(solve(A, 4)));
    }

    private static int[] solve(int[] A, int B) {
        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            queue.add(A[i]);
        }

        //Using stack to put first B elements to a stack
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < B; i++) {
            stack.push(queue.poll());
        }

        //Add elements from stack to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        //Poll elements from queue n - B times and enqueue them again to get the resultant queue
        for (int i = 0; i < A.length - B; i++) {
            queue.add(queue.poll());
        }

        int i = 0;
        while (!queue.isEmpty()) {
            A[i] = queue.poll();
            i++;
        }

        return A;
    }
}
