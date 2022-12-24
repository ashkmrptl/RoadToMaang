package scaler.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array A of both positive and negative integers.
 * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
 * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 */
public class SumOfMinAndMax {
    public static void main(String[] args) {
        int[] A = new int[]{2, 5, -1, 7, -3, -1, -2};
        System.out.println(solve(A, 4));

        A = new int[]{2, -1, 3};
        System.out.println(solve(A, 2));
    }

    /**
     * This approach is similar to the problem of finding max in all sub-arrays of given size.
     * Here in this, we have to find the min and max of all sub-arrays of given size.
     * We will use two Deque
     */
    private static int solve(int[] A, int B) {
        final int mod = 1000 * 1000 * 1000 + 7;
        final Deque<Integer> maxDeque = new LinkedList<>();
        final Deque<Integer> minDeque = new LinkedList<>();

        //For first window
        for (int i = 0; i < B; i++) {
            while (!maxDeque.isEmpty() && A[i] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.add(A[i]);

            while (!minDeque.isEmpty() && A[i] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.add(A[i]);
        }

        long result = maxDeque.getFirst() + minDeque.getFirst();

        int left = 1;
        int right = B;

        while (right < A.length) {
            int in = right;
            int out = left - 1;

            //Handle out
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() == A[out]) {
                maxDeque.pollFirst();
            }
            if (!minDeque.isEmpty() && minDeque.peekFirst() == A[out]) {
                minDeque.pollFirst();
            }

            //Handle in
            while (!maxDeque.isEmpty() && A[in] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.add(A[in]);

            while (!minDeque.isEmpty() && A[in] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.add(A[in]);

            result = (result % mod + (long) maxDeque.peekFirst() % mod + (long) minDeque.peekFirst() % mod) % mod;

            left++;
            right++;
        }

        return (int) result;
    }
}
