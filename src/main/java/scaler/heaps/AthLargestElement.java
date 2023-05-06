package scaler.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array B of size N.
 * You need to find the Ath largest element in the sub-array [1 to i], where i varies from 1 to N.
 * In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
 * NOTE: If any sub-array [1 : i] has less than A elements, then the output should be -1 at the ith index.
 */
public class AthLargestElement {
    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        B.add(5);
        B.add(6);
        System.out.println(solve(4, B));

        B = new ArrayList<>();
        B.add(15);
        B.add(20);
        B.add(99);
        B.add(1);
        System.out.println(solve(2, B));
    }

    private static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        final ArrayList<Integer> answer = new ArrayList<>();

        final Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < B.size(); i++) {
            if (i < A - 1) {
                answer.add(-1);
                minHeap.add(B.get(i));
            } else {
                if (minHeap.size() == A) {
                    if (B.get(i) > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.add(B.get(i));
                    }
                } else {
                    minHeap.add(B.get(i));
                }
                answer.add(minHeap.peek());
            }
        }

        return answer;
    }
}
