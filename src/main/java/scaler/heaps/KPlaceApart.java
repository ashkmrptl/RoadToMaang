package scaler.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * N people having different priorities are standing in a queue.
 * The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
 * Your task is to sort the queue in the increasing order of priorities.
 * NOTE:
 * No two persons can have the same priority.
 * Use the property of the queue to sort the queue with complexity O(NlogB).
 */
public class KPlaceApart {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(40);
        A.add(2);
        A.add(3);
        System.out.println(solve(A, 2));

        A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(17);
        A.add(10);
        A.add(21);
        A.add(95);
        System.out.println(solve(A, 1));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        final ArrayList<Integer> answer = new ArrayList<>();

        final Queue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        while (i < B) {
            minHeap.add(A.get(i));
            i++;
        }

        for (int j = i; j < A.size(); j++) {
            //Add next elem to the Heap
            minHeap.add(A.get(j));

            //Extract min and add to answer
            answer.add(minHeap.poll());
        }

        while (!minHeap.isEmpty()) {
            answer.add(minHeap.poll());
        }

        return answer;
    }
}
