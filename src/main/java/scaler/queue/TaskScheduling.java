package scaler.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduling {
    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 1, 5, 4};
        int[] B = new int[]{1, 3, 5, 4, 2};

        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int[] B) {
        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            queue.add(A[i]);
        }

        int cycle = 0;

        for (int i = 0; i < B.length; i++) {
            int task = B[i];

            while (task != queue.peek()) {
                queue.add(queue.poll());
                cycle++;
            }

            if (task == queue.peek()) {
                queue.poll();
                cycle++;
            }
        }

        return cycle;
    }
}
