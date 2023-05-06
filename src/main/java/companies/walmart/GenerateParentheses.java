package companies.walmart;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    private static List<String> generateParenthesis(int n) {
        final List<String> ans = new ArrayList<>();
        recursive(0, 0, n, "", ans);
        return ans;
    }

    private static void recursive(int openCount, int closedCount, int n, String combination, List<String> ans) {
        if (openCount == closedCount && closedCount == n) {
            ans.add(combination);
        }

        if (openCount < n) {
            combination += "(";
            openCount++;
            recursive(openCount, closedCount, n, combination, ans);
            combination = combination.substring(0, combination.length() - 1);
            openCount--;
        }

        if (closedCount < openCount) {
            combination += ")";
            closedCount++;
            recursive(openCount, closedCount, n, combination, ans);
            combination = combination.substring(0, combination.length() - 1);
            closedCount--;
        }
    }
}
