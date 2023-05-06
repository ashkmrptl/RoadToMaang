package scaler.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BthSmallestPrimeFraction {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(5);
        System.out.println(solve(A, 3));

        A = new ArrayList<>();
        A.add(1);
        A.add(7);
        System.out.println(solve(A, 1));
    }

    //Optimization would be to limit the size of ths Heap.
    private static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        final Queue<Fraction> minHeap = new PriorityQueue<>(Comparator.comparingDouble(value -> value.fraction));

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                float p = A.get(i);
                float q = A.get(j);

                minHeap.add(new Fraction(A.get(i), A.get(j), p / q));
            }
        }

        Fraction ans = null;

        for (int i = 0; i < B; i++) {
            ans = minHeap.poll();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        if (ans != null) {
            answer.add(ans.p);
            answer.add(ans.q);
        }

        return answer;
    }

    private static class Fraction {
        int p;
        int q;
        float fraction;

        public Fraction(int p, int q, float fraction) {
            this.p = p;
            this.q = q;
            this.fraction = fraction;
        }

        @Override
        public String toString() {
            return "(" + p + "," + q + "," + fraction + ")";
        }
    }
}
