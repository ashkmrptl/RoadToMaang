package scaler.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an array A of integers that represent the lengths of ropes.
 * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
 * Find and return the minimum cost to connect these ropes into one rope.
 */
public class ConnectRopes {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        System.out.println(solve(A));

        A = new ArrayList<>();
        A.add(5);
        A.add(17);
        A.add(100);
        A.add(11);
        System.out.println(solve(A));
    }

    private static int solve(ArrayList<Integer> A) {
        //We can do it manually by calling heapify function from first non-leaf node till root.
        final Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            minHeap.add(A.get(i));
        }

        int sum = 0;

        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = 0;
            if (!minHeap.isEmpty()) {
                b = minHeap.poll();
            }

            minHeap.add(a + b);

            sum += (a + b);
        }

        return sum;
    }
}
