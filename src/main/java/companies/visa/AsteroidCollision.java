package companies.visa;

import java.util.Arrays;
import java.util.Stack;

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
        final Stack<Integer> s = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0 || s.isEmpty()) {
                s.push(asteroid);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroid)) {
                    s.pop();
                }
                if (!s.isEmpty() && s.peek() == Math.abs(asteroid)) {
                    s.pop();
                } else {
                    if (s.isEmpty() || s.peek() < 0) {
                        s.push(asteroid);
                    }
                }
            }
        }
        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }

    private static boolean willCollide(int a, int b) {
        return (a < 0 && b < 0) || (a >= 0 && b >= 0);
    }
}
