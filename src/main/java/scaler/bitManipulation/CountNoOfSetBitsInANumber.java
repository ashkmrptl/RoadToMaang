package scaler.bitManipulation;

public class CountNoOfSetBitsInANumber {
    public static void main(String[] args) {
        System.out.println(countSetBit(8));
        System.out.println(solveOptimized(8));
        System.out.println(countSetBit(7));
        System.out.println(solveOptimized(7));
    }

    //Kernighan's algorithm
    private static int solveOptimized(int A) {
        int count = 0;

        while (A > 0) {
            count++;
            int rsbm = A & (-A);
            A = A - rsbm;
        }

        return count;
    }

    private static int countSetBit(final int N) {
        //We're guessing the humber can have at most 32 bits.
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((N & (1 << i)) > 0) {
                count++;
            }
        }

        return count;
    }
}
