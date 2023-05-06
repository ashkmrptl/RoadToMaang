package scaler.heaps;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the
 * N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
 * Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
 * Find the minimum possible largest element after B operations.
 */
public class MinimumLargestElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(solve(A, 3));

        A = new ArrayList<>();
        A.add(5);
        A.add(1);
        A.add(4);
        A.add(2);
        System.out.println(solve(A, 5));

        A = new ArrayList<>();
        A.add(5);
        A.add(7);
        A.add(8);
        System.out.println(solve(A, 9));

        A = new ArrayList<>();
        A.add(8);
        A.add(6);
        A.add(4);
        A.add(2);
        System.out.println(solve(A, 8));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int maxVal = Integer.MIN_VALUE;

        final Queue<Pair> minHeap = new PriorityQueue<>(new CustomComparator());
        for (int index = 0; index < A.size(); index++) {
            maxVal = Math.max(maxVal, A.get(index));
            Pair pair = new Pair(A.get(index));
            minHeap.add(pair);
        }

        for (int index = 0; index < B; index++) {
            Pair pair = minHeap.poll();
            maxVal = Math.max(maxVal, pair.nextSum);
            pair.curSum = pair.nextSum;
            pair.nextSum = pair.nextSum + pair.val;
            minHeap.add(pair);
        }

        return maxVal;
    }

    private static class CustomComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.nextSum - p2.nextSum;
        }
    }

    private static class Pair {
        int val;
        int curSum;
        int nextSum;

        public Pair(int val) {
            this.val = val;
            this.curSum = val;
            this.nextSum = val + val;
        }
    }
}
