package scaler.heaps;

import java.util.*;

/**
 * You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:
 * There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
 * There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
 * The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.
 * Return 1 if the array is special else return 0.
 * <p>
 * NOTE:
 * Do not neglect decimal point while calculating the median
 * For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
 * For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]
 */
public class SpecialMedian {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(6);
        A.add(8);
        A.add(4);
        System.out.println(solve(A));

        A = new ArrayList<>();
        A.add(2);
        A.add(7);
        A.add(3);
        A.add(1);
        System.out.println(solve(A));
    }

    private static int solve(ArrayList<Integer> A) {
        if (median(A)) {
            return 1;
        }

        //Reverse the list and do the same
        Collections.reverse(A);
        if (median(A)) {
            return 1;
        }

        return 0;
    }

    private static boolean median(ArrayList<Integer> A) {
        final Queue<Integer> minHeap = new PriorityQueue<>();
        final Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        //Add dummy values to avoid null check
        maxHeap.add(Integer.MIN_VALUE);
        minHeap.add(Integer.MAX_VALUE);

        //Left sorted will be stored in max heap and right sorted will be stored in min heap
        for (int i = 0; i < A.size() - 1; i++) {
            int num = A.get(i);

            if (num < maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            //Maintain the size of the heaps(left will contain one element in case of odd no of elements else both will contain same no of elements)
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            double currMedian = minHeap.size() == maxHeap.size() ? (Double.valueOf(maxHeap.peek()) + Double.valueOf(minHeap.peek())) / 2D : maxHeap.peek();
            if (currMedian == Double.valueOf(A.get(i + 1))) {
                return true;
            }
        }

        return false;
    }
}
