package companies.walmart;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = new int[]{5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));

        asteroids = new int[]{8, -8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));

        asteroids = new int[]{10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        final Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty()) {
                stack.add(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                } else {
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.add(asteroid);
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
