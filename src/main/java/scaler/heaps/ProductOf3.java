package scaler.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array A of size N.
 * You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
 * Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
 *
 * Input 1:
 *  A = [1, 2, 3, 4, 5]
 *
 *  Output 1:
 *  [-1, -1, 6, 24, 60]
 *
 *  Explanation 1:
 *  For i = 1, ans = -1
 *  For i = 2, ans = -1
 *  For i = 3, ans = 1 * 2 * 3 = 6
 *  For i = 4, ans = 2 * 3 * 4 = 24
 *  For i = 5, ans = 3 * 4 * 5 = 60
 *
 *  So, the output is [-1, -1, 6, 24, 60].
 */
public class ProductOf3 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        System.out.println(solve(A));

        A = new ArrayList<>();
        A.add(10);
        A.add(2);
        A.add(13);
        A.add(4);
        System.out.println(solve(A));
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        final ArrayList<Integer> answer = new ArrayList<>();
        if (A.size() < 3) {
            for (int i = 0; i < A.size(); i++) {
                answer.add(-1);
            }
            return answer;
        }

        answer.add(-1);
        answer.add(-1);

        final Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxHeap.add(A.get(0));
        maxHeap.add(A.get(1));

        for (int i = 2; i < A.size(); i++) {
            maxHeap.add(A.get(i));

            //Peek first 3, take sum and add to answer
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            int c = maxHeap.poll();

            maxHeap.add(a);
            maxHeap.add(b);
            maxHeap.add(c);

            answer.add(a * b * c);
        }

        return answer;
    }
}
