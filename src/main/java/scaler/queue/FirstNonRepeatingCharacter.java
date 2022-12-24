package scaler.queue;

import java.util.*;

/**
 * Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
 * B is formed such that we have to find the first non-repeating character each time a character
 * is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.
 * A = "abadbc"
 * "aabbdd"
 */
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(solve("abadbc"));
        System.out.println(solve("abcabc"));
    }

    private static String solve(String A) {
        final Deque<Character> dq = new ArrayDeque<>();
        final HashMap<Character, Integer> map = new HashMap<>();

        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

            if (map.get(ch) > 1) {
                while (!dq.isEmpty() && map.get(dq.peekFirst()) > 1) {
                    dq.removeFirst();
                }
            } else {
                dq.addLast(ch);
            }

            sb.append(dq.isEmpty() ? "#" : dq.peekFirst());
        }
        return sb.toString();
    }
}
