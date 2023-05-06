package scaler.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
 * Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
 * Find and return the array C.
 *
 * NOTE:
 * If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
 * If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
 */
public class RunningMedian {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(4);
        A.add(3);
        System.out.println(solve(A));

        A = new ArrayList<>();
        A.add(5);
        A.add(17);
        A.add(100);
        A.add(11);
        System.out.println(solve(A));
    }

    //We will use two Heaps, one min heap and another max heap.
    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        final ArrayList<Integer> B = new ArrayList<>();
        final ArrayList<Integer> C = new ArrayList<>();

        if (A.size() == 1) {
            C.add(A.get(0));
            return C;
        }

        final Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        final Queue<Integer> minHeap = new PriorityQueue<>();

        if (A.get(0) > A.get(1)) {
            minHeap.add(A.get(0));
            maxHeap.add(A.get(1));
        } else {
            maxHeap.add(A.get(0));
            minHeap.add(A.get(1));
        }

        B.add(A.get(0));
        B.add(A.get(1));

        C.add(A.get(0));
        C.add(A.get(0) < A.get(1) ? A.get(0) : A.get(1));

        //For even no of elements the median will be ((maxHeap.poll() + minHeap.poll()) / 2) and for odd maxHeap.poll() is the median
        for (int i = 2; i < A.size(); i++) {
            final int element = A.get(i);
            B.add(element);

            if (element < maxHeap.peek()) {
                maxHeap.add(element);

                if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(element);

                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }

            if (B.size() % 2 == 0) {
                C.add(maxHeap.peek());//C.add(((maxHeap.peek() + minHeap.peek()) / 2));
            } else {
                C.add(maxHeap.peek());
            }
        }


        return C;
    }
}
