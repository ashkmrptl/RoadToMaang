package companies.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Input
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * Output
 * [null, 1, 1, 1, 2, 1, 4, 6]
 */
public class StockSpanner {
    List<Integer> stocks;
    Stack<Pair> stack;

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.print(stockSpanner.next(price) + " ");
        }
    }

    public StockSpanner() {
        stocks = new ArrayList<>();
        stocks.add(Integer.MAX_VALUE);

        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().val <= price) {
            span += stack.pop().span;
        }

        stack.push(new Pair(price, span));

        return span;
    }

    public int next_brute_force(int price) {
        int i = stocks.size() - 1;

        while (i >= 0) {
            if (stocks.get(i) > price) {
                break;
            }
            i--;
        }
        stocks.add(price);

        return stocks.size() - i - 1;
    }

    private static class Pair {
        int val;
        int span;

        public Pair(int val, int span) {
            this.val = val;
            this.span = span;
        }

        @Override
        public String toString() {
            return "(" + val + ", " + span + ")";
        }
    }
}
