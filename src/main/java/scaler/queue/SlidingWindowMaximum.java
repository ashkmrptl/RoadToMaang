package scaler.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right.
 * You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
 * Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
 * Refer to the given example for clarity.
 * NOTE: If B > length of the array, return 1 element with the max of the array.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(solve(A, 3)));
        A = new int[]{1, 2, 3, 4, 2, 7, 1, 3, 6};
        System.out.println(Arrays.toString(solve(A, 6)));

    }

    private static int[] solve(final int[] A, int B) {
        int n = A.length;
        int resultLength = n - B + 1;
        int[] result = new int[resultLength];

        final Deque<Integer> deque = new LinkedList<>();

        //For first window
        for (int i = 0; i < B; i++) {
            while (!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.removeLast();
            }

            deque.add(A[i]);
        }

        result[0] = deque.peekFirst();

        int left = 1;
        int right = B;

        int index = 1;

        while (right < n) {
            int out = A[left - 1];
            int in = A[right];

            //Handle out
            if (deque.peekFirst() == out) {
                deque.removeFirst();
            }

            //Handle in
            while (!deque.isEmpty() && deque.peekLast() < in) {
                deque.removeLast();
            }

            deque.add(in);

            result[index] = deque.peekFirst();
            index++;
            left++;
            right++;
        }

        return result;
    }
}
