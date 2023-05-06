package scaler.graph;

/**
 * Given the number of vertices A in a Cyclic Graph.
 *
 * Your task is to determine the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.
 */
public class ColoringCycleGraph {
    public static void main(String[] args) {
        System.out.println(solve(2));
        System.out.println(solve(3));
    }

    private static int solve(int A) {
        return A % 2 == 0 ? 2 : 3;
    }
}
