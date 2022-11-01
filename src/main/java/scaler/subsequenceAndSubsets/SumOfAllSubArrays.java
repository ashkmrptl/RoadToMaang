package scaler.subsequenceAndSubsets;

public class SumOfAllSubArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        long sum = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(A[k] + " ");
                    sum += A[k];
                }
                System.out.println();
            }
        }

        return (int) (sum % 1000000007);
    }
}
