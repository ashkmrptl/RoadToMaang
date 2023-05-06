package scaler.heaps;

import java.util.*;

/**
 * Misha loves eating candies. She has been given N boxes of Candies.
 * She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the
 * other box that has the minimum number of candies.
 * Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
 * NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
 * NOTE 2: The same box will not be chosen again.
 */
public class MishaAndCandies {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(3);
        System.out.println(solve(A, 4));

        A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        System.out.println(solve(A, 2));
    }

    private static int solve(ArrayList<Integer> A, int B) {
        final Queue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.noOfCandies));

        for (int i = 0; i < A.size(); i++) {
            minHeap.add(new Pair(i, A.get(i)));
        }

        boolean[] visited = new boolean[A.size()];

        int sum = 0;

        while (!minHeap.isEmpty()) {
            final Pair pair = minHeap.poll();
            if (!visited[pair.index]) {
                if (pair.noOfCandies > B) {
                    continue;
                }
                //Mark the box as visited
                visited[pair.index] = true;

                //Eat half
                int eat = (int) Math.floor(pair.noOfCandies / 2);

                sum += eat;

                if (minHeap.isEmpty()) {
                    break;
                }

                //Add remaining to min candy box
                final Pair nextMin = minHeap.poll();
                nextMin.noOfCandies = nextMin.noOfCandies + (pair.noOfCandies - eat);

                //Add to heap again
                minHeap.add(nextMin);
            }
        }

        return sum;
    }

    private static class Pair {
        int index;
        int noOfCandies;

        public Pair(int index, int noOfCandies) {
            this.index = index;
            this.noOfCandies = noOfCandies;
        }

        @Override
        public String toString() {
            return "(" + index + ", " + noOfCandies + ")";
        }
    }
}
