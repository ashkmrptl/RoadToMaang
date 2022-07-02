package scaler.array;

public class EvenAndOddNumbers {
    public static void main(String[] args) {
        final int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        printEvenUsingModulo(array);
        System.out.println();
        printEvenUsingBitwiseAND(array);
    }

    private static void printEvenUsingModulo(final int[] array) {
        for (int j : array) {
            if (j % 2 == 0) {
                System.out.print(j + " ");
            }
        }
    }

    private static void printEvenUsingBitwiseAND(final int[] array) {
        for (int j : array) {
            if ((j & 1) == 0) {
                System.out.print(j + " ");
            }
        }
    }
}
