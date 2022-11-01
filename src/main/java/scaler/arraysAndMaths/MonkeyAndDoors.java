package scaler.arraysAndMaths;

public class MonkeyAndDoors {
    public static void main(String[] args) {
        int A = 100;
        System.out.println(solve(A));
    }

    private static int solve(int A) {
        return (int)Math.sqrt(A);
    }
}
