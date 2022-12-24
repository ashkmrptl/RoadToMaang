package scaler.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
 * <p>
 * NOTE: All the A integers will fit in 32-bit integers.
 */
public class NIntegersContainingOnly123 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(3)));
        System.out.println(Arrays.toString(solve(7)));
        System.out.println(Arrays.toString(solve(15)));
    }

    private static int[] solve(int A) {
        int[] result = new int[A];

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        for (int i = 0; i < A; i++) {
            int num = queue.poll();
            queue.add(num * 10 + 1);
            queue.add(num * 10 + 2);
            queue.add(num * 10 + 3);

            result[i] = num;
        }

        return result;
    }
}
