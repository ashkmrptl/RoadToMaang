package scaler.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * You are given a matrix A of size N x 2 which represents different operations.
 * Assume initially you have a stack-like data structure you have to perform operations on it.
 * <p>
 * Operations are of two types:
 * <p>
 * 1 x: push an integer x onto the stack and return -1.
 * <p>
 * 2 0: remove and return the most frequent element in the stack.
 * <p>
 * If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
 */
public class MaximumFrequencyStack {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 5}, {1, 7}, {1, 5}, {1, 7}, {1, 4}, {1, 5}, {2, 0}, {2, 0}, {2, 0}, {2, 0}};
        System.out.println(Arrays.toString(new MaximumFrequencyStack().solve(A)));
    }

    private final HashMap<Integer, Integer> freqMap = new HashMap<>();
    private final HashMap<Integer, Deque<Integer>> freqQueueMap = new HashMap<>();
    int maxFreq = Integer.MIN_VALUE;

    public int[] solve(int[][] A) {
        int n = A.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (A[i][0] == 1) {
                result[i] = push(A[i][1]);
            } else {
                result[i] = pop();
            }
        }
        return result;
    }

    private int push(int x) {
        Deque<Integer> deque = new ArrayDeque<>();

        int freq = (freqMap.containsKey(x) ? freqMap.get(x) : 0) + 1;
        freqMap.put(x, freq);

        maxFreq = Math.max(maxFreq, freq);

        if (freqQueueMap.containsKey(freq)) {
            deque = freqQueueMap.get(freq);
        }
        deque.push(x);
        freqQueueMap.put(freq, deque);
        return -1;
    }

    private int pop() {
        final Deque<Integer> deque = freqQueueMap.get(maxFreq);
        int out = deque.pop();
        freqMap.put(out, (freqMap.containsKey(out) ? freqMap.get(out) : 0) - 1);

        if (deque.isEmpty()) {
            maxFreq--;
        }
        return out;
    }

}
