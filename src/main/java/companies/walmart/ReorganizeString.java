package companies.walmart;

import java.util.*;

/**
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));

        System.out.println(reorganizeString("aaab"));

        System.out.println(reorganizeString("abbabbaaab"));

        System.out.println(reorganizeString("ogccckcwmbmxtsbmozli"));
    }

    public static String reorganizeString(String s) {
        final Map<Character, Integer> frequencyMap = new HashMap<>();

        for (final char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        final PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        final StringBuilder result = new StringBuilder();

        while (maxHeap.size() > 1) {
            char curr = maxHeap.poll();
            char next = maxHeap.poll();

            result.append(curr);
            result.append(next);

            frequencyMap.put(curr, frequencyMap.get(curr) - 1);
            frequencyMap.put(next, frequencyMap.get(next) - 1);

            //Add remaining chars back to heap
            if (frequencyMap.get(curr) > 0) {
                maxHeap.offer(curr);
            }

            if (frequencyMap.get(next) > 0) {
                maxHeap.offer(next);
            }
        }

        //For last char
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();

            if (frequencyMap.get(last) > 1) {
                return "";
            }
            result.append(last);

        }

        return result.toString();
    }
}