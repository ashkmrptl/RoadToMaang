package companies.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
        System.out.println(grayCode(3));
        System.out.println(grayCode(4));
    }

    private static List<Integer> grayCode(int n) {
        final List<Integer> ans = new ArrayList<>();
        ans.add(0);

        if (n == 0) {
            return ans;
        }

        for (int i = 1; i <= n; i++) {
            int size = ans.size();
            int numberToAdd = 1 << (i - 1);//Math.pow(2, i - 1)
            for (int j = size - 1; j>= 0; j--) {
                ans.add(numberToAdd + ans.get(j));
            }
        }

        return ans;
    }

    private static List<Integer> grayCode_chatgpt(int n) {
        List<Integer> sequence = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        sequence.add(0);
        visited.add(0);

        backtrack(sequence, visited, n);

        return sequence;
    }

    private static boolean backtrack(List<Integer> sequence, Set<Integer> visited, int n) {
        if (sequence.size() == (1 << n))
            return true;

        int prev = sequence.get(sequence.size() - 1);

        for (int i = 0; i < n; i++) {
            int candidate = prev ^ (1 << i);
            if (!visited.contains(candidate)) {
                visited.add(candidate);
                sequence.add(candidate);

                if (backtrack(sequence, visited, n))
                    return true;

                visited.remove(candidate);
                sequence.remove(sequence.size() - 1);
            }
        }

        return false;
    }
}
