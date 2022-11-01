package scaler.arraysAndMaths;

public class PeopleInCircle {
    public static void main(String[] args) {
        int A = 100;
        solve(A);
    }

    private static void solve (final int A) {
        int x = (int) (Math.log(A) / Math.log(2));
        int num = (int) (A - Math.pow(2, x));

        System.out.println((2 * num + 1));
    }
}
