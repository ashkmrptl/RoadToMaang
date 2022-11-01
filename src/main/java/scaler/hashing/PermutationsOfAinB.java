package scaler.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationsOfAinB {
    public static void main(String[] args) {
        System.out.println(solve("abc", "abcbacabc"));
        System.out.println(solveOptimized("abc", "abcbacabc"));

        System.out.println(solve("aca", "acaa"));
        System.out.println(solveOptimized("aca", "acaa"));
    }

    private static int solveOptimized(final String A, final String B) {
        int count = 0;
        int neededCount = A.length();

        Map<Character, Integer> requiredFrequency = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (requiredFrequency.containsKey(c)) {
                requiredFrequency.put(c, requiredFrequency.get(c) + 1);
            } else {
                requiredFrequency.put(c, 1);
            }
        }

        //Frequency Array for 1st window
        Map<Character, Integer> currentFrequency = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char c = B.charAt(i);

            int curFreq = currentFrequency.containsKey(c) ? currentFrequency.get(c) : 0;
            int reqFreq = requiredFrequency.containsKey(c) ? requiredFrequency.get(c) : 0;

            if (curFreq < reqFreq) {
                neededCount--;
            }

            if (currentFrequency.containsKey(c)) {
                currentFrequency.put(c, currentFrequency.get(c) + 1);
            } else {
                currentFrequency.put(c, 1);
            }
        }

        if (neededCount == 0) {
            count++;
        }

        int start = 1;
        int end = A.length();

        while (end < B.length()) {
            char inComing = B.charAt(end);
            char outGoing = B.charAt(start - 1);
            if (inComing != outGoing) {
                int curFreqIncoming = currentFrequency.containsKey(inComing) ? currentFrequency.get(inComing) : 0;
                int reqFreqInComing = requiredFrequency.containsKey(inComing) ? requiredFrequency.get(inComing) : 0;

                if (curFreqIncoming < reqFreqInComing) {
                    neededCount--;
                }

                int curFreqOutGoing = currentFrequency.containsKey(outGoing) ? currentFrequency.get(outGoing) : 0;
                int reqFreqOutGoing = requiredFrequency.containsKey(outGoing) ? requiredFrequency.get(outGoing) : 0;

                if (curFreqOutGoing <= reqFreqOutGoing) {
                    neededCount++;
                }

                if (currentFrequency.containsKey(inComing)) {
                    currentFrequency.put(inComing, currentFrequency.get(inComing) + 1);
                } else {
                    currentFrequency.put(inComing, 1);
                }

                if (currentFrequency.containsKey(outGoing)) {
                    if (currentFrequency.get(outGoing) == 1) {
                        currentFrequency.remove(outGoing);
                    } else {
                        currentFrequency.put(outGoing, currentFrequency.get(outGoing) - 1);
                    }
                }
            }

            if (neededCount == 0) {
                count++;
            }

            start++;
            end++;
        }

        return count;
    }

    private static int solve(String A, String B) {
        int count = 0;

        int n = A.length();
        int m = B.length();

        final Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                frequencyMap.put(c, 1);
            }
        }

        //For the first window
        final Map<Character, Integer> currentFrequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = B.charAt(i);

            if (currentFrequencyMap.containsKey(c)) {
                currentFrequencyMap.put(c, currentFrequencyMap.get(c) + 1);
            } else {
                currentFrequencyMap.put(c, 1);
            }
        }

        if (isPermutation(frequencyMap, currentFrequencyMap)) {
            count++;
        }

        //For subsequent windows
        int i = 1;
        int k = n;

        while (k < m) {
            char outChar = B.charAt(i - 1);
            char inChar = B.charAt(k);

            //out character
            if (currentFrequencyMap.containsKey(outChar)) {
                if (1 == currentFrequencyMap.get(outChar)) {
                    currentFrequencyMap.remove(outChar);
                } else {
                    currentFrequencyMap.put(outChar, currentFrequencyMap.get(outChar) - 1);
                }
            }

            //in character
            if (currentFrequencyMap.containsKey(inChar)) {
                currentFrequencyMap.put(inChar, currentFrequencyMap.get(inChar) + 1);
            } else {
                currentFrequencyMap.put(inChar, 1);
            }

            if (isPermutation(frequencyMap, currentFrequencyMap)) {
                count++;
            }

            i++;
            k++;
        }

        return count;
    }

    private static boolean isPermutation(Map<Character, Integer> requiredFrequencyMap, Map<Character, Integer> currentFrequencyMap) {
        for (Map.Entry<Character, Integer> entry : currentFrequencyMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (requiredFrequencyMap.containsKey(key) && requiredFrequencyMap.get(key) != value) {
                return false;
            }
        }

        return true;
    }
}
