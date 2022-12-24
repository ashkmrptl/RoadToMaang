package scaler.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an integer A, you have to find the Ath Perfect Number.
 * A Perfect Number has the following properties:
 * It comprises only 1 and 2.
 * The number of digits in a Perfect number is even.
 * It is a palindrome number.
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 */
public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println(solve(4));
        System.out.println(solve(10));

        System.out.println("-----------------------");

        System.out.println(solve_copiedFromDiscussion(4));
        System.out.println(solve_copiedFromDiscussion(10));
    }

    private static String solve(int A) {
        List<String> series = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");

        while (series.size() < A) {
            final String num = queue.poll();
            final String nextNum = num + reverse(num);

            series.add(nextNum);

            //Append 1 and 2 respectively to the number polled and add it to the queue
            queue.add(num + "1");
            queue.add(num + "2");
        }

        return series.get(A - 1);
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private static String solve_copiedFromDiscussion(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("11");
        q.add("22");

        while (A - 1 != 0) {
            String var = q.peek();
            int size = var.length();
            String s1 = var.substring(0, size / 2);
            String s2 = var.substring(size / 2, size);

            q.add(s1 + "11" + s2);
            q.add(s1 + "22" + s2);

            q.remove();
            A--;

        }
        return q.peek();
    }
}
