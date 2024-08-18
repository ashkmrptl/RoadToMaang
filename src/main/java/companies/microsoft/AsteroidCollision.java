package companies.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteriods = new int[]{5, 10, -5};
        //System.out.println(Arrays.toString(asteroidCollision(asteriods)));

        asteriods = new int[]{8, -8};
        //System.out.println(Arrays.toString(asteroidCollision(asteriods)));

        asteriods = new int[]{10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteriods)));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        final Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty()) {
                stack.push(asteroid);
            } else {//This will execute for -ve numbers
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                } else {
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroid);
                    }
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
