package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. Fruit Into Baskets
 * https://leetcode.com/problems/fruit-into-baskets/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] fruits = new int[]{1, 2, 1};
        System.out.println(totalFruit(fruits));

        fruits = new int[]{0, 1, 2, 2};
        System.out.println(totalFruit(fruits));

        fruits = new int[]{1, 2, 3, 2, 2};
        System.out.println(totalFruit(fruits));

        fruits = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits));

        fruits = new int[]{0, 1, 2};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;

        int count = 0;
        final Map<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length) {
            while (map.size() > 2) {
                int fruitType = fruits[l];
                map.put(fruitType, map.get(fruitType) - 1);

                if (map.get(fruitType) == 0) {
                    map.remove(fruitType);
                }
                l++;
            }

            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() <= 2) {
                count = Math.max(count, r - l + 1);
            }
            r++;
        }

        return count;
    }

}
