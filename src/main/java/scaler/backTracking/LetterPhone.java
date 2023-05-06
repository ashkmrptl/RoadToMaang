package scaler.backTracking;

import java.util.*;

public class LetterPhone {
    public static void main(String[] args) {
        String A = "23";
        System.out.println(Arrays.toString(solve(A)));

        A = "012";
        System.out.println(Arrays.toString(solve(A)));
    }

    private static String[] solve(String A) {
        final Map<Character, String> map = new HashMap<>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        final List<String> ans = new ArrayList<>();

        findCombinations(0, A.length(), ans, new StringBuilder(), A, map);

        final String[] res = new String[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private static void findCombinations(int i, int n, List<String> result, StringBuilder currentString, String A, Map<Character, String> map) {
        if (i == n) {
            result.add(currentString.toString());
            return;
        }

        final String str = map.get(A.charAt(i));
        for (int j = 0; j < str.length(); j++) {
            currentString.append(str.charAt(j));
            findCombinations(i + 1, n, result, currentString, A, map);
            currentString.deleteCharAt(currentString.length() - 1);
        }

    }
}
