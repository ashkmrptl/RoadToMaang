package companies.walmart;

import java.util.Arrays;

/**
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 *
 */
public class DesignHashMap {
    public static void main(String[] args) {

    }

    class MyHashMap {
        int[] data;

        public MyHashMap() {
            data = new int[1000001];
            Arrays.fill(data, -1);
        }

        public void put(int key, int value) {
            data[key] = value;
        }

        public int get(int key) {
            return data[key];
        }

        public void remove(int key) {
            data[key] = -1;
        }
    }
}
