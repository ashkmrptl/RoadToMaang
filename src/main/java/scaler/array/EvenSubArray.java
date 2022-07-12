package scaler.array;

public class EvenSubArray {
    public static void main(String[] args) {
        //final int[] array = new int[]{654, 50, 693, 750, 712, 275, 736, 146, 279, 816, 707, 396, 406, 589, 370, 742, 840, 290, 505, 23, 249, 447, 618, 80, 968, 189, 600, 662, 91, 604, 575, 689, 72, 196, 475, 198, 850, 844, 361, 419, 617, 911, 268, 628, 408, 404, 477, 921, 478, 806, 204, 637, 403, 911, 589, 529, 867, 584, 768, 257, 437, 380, 698, 452, 368, 97, 977, 582, 775, 103};
        //final int[] array = new int[]{540, 881, 266, 917, 768, 245, 646, 197, 709, 778, 541, 54};
        //System.out.println(solve(array));

        System.out.println(hintAnswer(new int[]{4, 1, 2, 1, 3, 6}));
    }

    private static String hintAnswer(final int[] A) {
        int n = A.length;
        if (A[0] % 2 == 0 && A[n - 1] % 2 == 0 && n % 2 == 0)
            return "YES";
        return "NO";
    }

    private static String solve(int[] array) {
        if ((array.length % 2 != 0) || (array[0] % 2 != 0) || (array[array.length - 1] % 2 != 0)) {
            return "NO";
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                continue;
            }

            if (array[i] % 2 == 0 && i % 2 == 0) {
                continue;
            }

            if (array[i] % 2 == 0 && i % 2 != 0) {
                if (i == array.length - 1) {
                    return "YES";
                }
            }
        }

        return "NO";
    }
}
