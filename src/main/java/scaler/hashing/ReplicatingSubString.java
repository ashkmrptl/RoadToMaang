package scaler.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
 * Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
 * If it is possible, return 1, else return -1.
 */
public class ReplicatingSubString {
    public static void main(String[] args) {
        int A = 2;
        String B = "bbaabb";

        System.out.println(solve(A, B));

        A = 1;
        B = "bc";

        System.out.println(solve(A, B));
    }

    private static int solve(int A, String B) {
        final Map<Character, Integer> frequencyMap = new HashMap<>();

        for (Character c : B.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                frequencyMap.put(c, 1);
            }
        }

        int possible = 1;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() % A != 0) {
                possible = -1;
                break;
            }
        }

        return possible;
    }
}
