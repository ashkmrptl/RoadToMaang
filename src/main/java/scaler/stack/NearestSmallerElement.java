package scaler.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 * More formally,
 * G[i] for an element A[i] = an element A[j] such that
 * j is maximum possible AND
 * j < i AND
 * A[j] < A[i]
 * Elements for which no smaller element exist, consider the next smaller element as -1.
 */
public class NearestSmallerElement {
    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(solve(A)));
        System.out.println(Arrays.toString(solveUsingIndex(A)));
    }

    private static int[] solve(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = -1;
        }

        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.add(A[i]);
        }

        return result;
    }

    private static int[] solveUsingIndex(int[] A) {
        int[] resultIndex = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            resultIndex[i] = -1;
        }

        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                resultIndex[i] = stack.peek();
            }
            stack.add(i);
        }

        return resultIndex;
    }
}
