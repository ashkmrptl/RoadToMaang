package scaler.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
 * You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
 */
public class MaximumArraySumAfterBNegations {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(24);
        A.add(-68);
        A.add(-29);
        A.add(-9);
        A.add(84);
        System.out.println(solve(A, 4));

        A = new ArrayList<>();
        A.add(57);
        A.add(3);
        A.add(-14);
        A.add(-87);
        A.add(42);
        A.add(38);
        A.add(31);
        A.add(-7);
        A.add(-28);
        A.add(-61);
        System.out.println(solve(A, 10));
    }

    private static int solve(ArrayList<Integer> A, int B) {
        final Queue<Integer> minHeap = new PriorityQueue<>(A);

        for (int i = 1; i <= B; i++) {
            minHeap.add(-minHeap.poll());
        }

        int sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }

        return sum;
    }
}
