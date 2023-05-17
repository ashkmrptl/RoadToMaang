package companies.cisco;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));

        n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));

        flowerbed = new int[]{0, 0, 1, 0, 1};
        n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));

        flowerbed = new int[]{1, 0, 0, 0, 1, 0, 0};
        n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            if (n == 0) {
                break;
            }
        }

        return n == 0;
    }
}
