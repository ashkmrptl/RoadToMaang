package companies.walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));

        digits = "";
        System.out.println(letterCombinations(digits));

        digits = "2";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        final Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        final List<String> answer = new ArrayList<>();

        backtracking(digits, 0, answer, new StringBuilder(), map);

        return answer;
    }

    private static void backtracking(String digits, int index, List<String> answer, StringBuilder current, Map<String, String> map) {
        if (index == digits.length()) {
            answer.add(current.toString());
            return;
        }

        String str = map.get(String.valueOf(digits.charAt(index)));

        for (int i = 0; i < str.length(); i++) {
            current.append(str.charAt(i));
            backtracking(digits, index + 1, answer, current, map);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
