package scaler.modularArithmatic;

/**
 * Eight integers A, B, C, D, E, F, G, and H represent two rectangles in a 2D plane.
 * For the first rectangle, its bottom left corner is (A, B), and the top right corner is (C, D), and for the second rectangle, its bottom left corner is (E, F), and the top right corner is (G, H).
 * Find and return whether the two rectangles overlap or not.
 * <p>
 * Problem Constraints
 * -10000 <= A < C <= 10000
 * -10000 <= B < D <= 10000
 * -10000 <= E < G <= 10000
 * -10000 <= F < H <= 10000
 * <p>
 * Input Format
 * The eight arguments are integers A, B, C, D, E, F, G, and H.
 * <p>
 * Output Format
 * Return 1 if the two rectangles overlap else, return 0.
 * <p>
 * Example Input
 * Input 1:
 * A = 0   B = 0
 * C = 4   D = 4
 * E = 2   F = 2
 * G = 6   H = 6
 * <p>
 * Input 2:
 * A = 0   B = 0
 * C = 4   D = 4
 * E = 2   F = 2
 * G = 3   H = 3
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 1
 */
public class OverlappingRectangle {
    public static void main(String[] args) {
        int A = 0, B = 0, C = 4, D = 4, E = 2, F = 2, G = 6, H = 6;
        System.out.println(check(A, B, C, D, E, F, G, H));

        A = 0;
        B = 0;
        C = 1;
        D = 1;
        E = 1;
        F = 1;
        G = 6;
        H = 6;

        System.out.println(check(A, B, C, D, E, F, G, H));
    }

    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        int xs = Math.max(A, E), xe = Math.min(C, G);
        int ys = Math.max(B, F), ye = Math.min(D, H);
        if (xs < xe && ys < ye)
            return 1;
        else
            return 0;
    }

    private static int check(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A == C || B == D || E == G || F == H) {
            return 0;
        }

        if (C <= E || G <= A) {
            return 0;
        }

        if (D <= F || H <= B) {
            return 0;
        }

        return 1;
    }
}
