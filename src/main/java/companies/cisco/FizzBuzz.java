package companies.cisco;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 * <p>
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class FizzBuzz {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fizzBuzz(n));

        n = 5;
        System.out.println(fizzBuzz(n));

        n = 15;
        System.out.println(fizzBuzz(n));
    }

    public static List<String> fizzBuzz(int n) {
        final List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            final int modThree = i % 3;
            final int modFive = i % 5;
            if (modThree == 0 && modFive == 0) {
                ans.add("FizzBuzz");
            } else if (modThree == 0) {
                ans.add("Fizz");
            } else if (modFive == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }
}
