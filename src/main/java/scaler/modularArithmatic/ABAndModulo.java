package scaler.modularArithmatic;

public class ABAndModulo {
    public static void main(String[] args) {
        int A = 2335312;
        int B = 9055344;

        //ans = 6720032

        System.out.println(solve(A, B));
        System.out.println(solveOptimized(A, B));
    }

    /**
     * Approach: According to question, A != B.
     *  Hence, lets assume that B > A by D.
     *  => B = A + D
     *
     *  As A % M == B % M
     *  we can say
     *  A % M = (A + D) % M
     *  => A % M = (A % M) + (D % M)
     *  => D % M = 0
     *
     *  So, the largest factor of D (i.e B - A) is the answer. And largest factor of a number is the number it self.
     *  Hence D is the answer
     *
     */
    private static int solveOptimized (final int A, final int B) {
        return Math.abs(A - B);
    }

    private static int solve(int A, int B) {
        int result = 0;
        int i = Math.max(A, B);

        while (i >= 0) {
            if ((A % i) == (B % i)) {
                result = i;
                break;
            }
            i--;
        }

        return result;
    }
}
