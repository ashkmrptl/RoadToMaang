package companies.microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] deck = new int[]{17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    private static int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length <= 1) {
            return deck;
        }

        Arrays.sort(deck);
        final int[] ans = new int[deck.length];

        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        for (int i = 0; i < deck.length; i++) {
            ans[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }

        return ans;
    }

    private static int[] deckRevealedIncreasing_slower(int[] deck) {
        Arrays.sort(deck);

        if (deck.length <= 2) {
            return deck;
        }

        final Queue<Integer> queue = new LinkedList<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
            queue.add(deck[i]);
        }

        int i = deck.length - 1;
        final int[] ans = new int[deck.length];
        while (!queue.isEmpty()) {
            ans[i] = queue.poll();
            i--;
        }

        return ans;
    }
}
