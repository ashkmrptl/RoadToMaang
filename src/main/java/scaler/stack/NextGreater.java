package scaler.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array A, find the next greater element G[i] for every element A[i] in the array.
 * The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
 */
public class NextGreater {
    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 2, 10};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = -1;
        }

        final Stack<Integer> stack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.add(A[i]);
        }

        return result;
    }
}
