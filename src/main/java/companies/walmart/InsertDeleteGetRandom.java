package companies.walmart;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element
 * exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
    }

    private static class RandomizedSet {

        java.util.Random rand = new Random();
        final List<Integer> array;
        final Map<Integer, Integer> map;

        public RandomizedSet() {
            array = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            //if the value is there, return false
            if (map.containsKey(val)) return false;

            //adds val as a key with its position being the value
            map.put(val, array.size());
            array.add(val);
            return true;
        }

        public boolean remove(int val) {
            //if the value isn't there, return false
            if (!map.containsKey(val)) return false;

            //getting the location of the value to be removed
            int location = map.get(val);
            //swaps our value with the last when not already true
            if (location < array.size() - 1) {
                int last = array.get(array.size() - 1);
                array.set(location, last);
                map.put(last, location);
            }
            //removes the value and returns true
            map.remove(val);
            array.remove(array.size() - 1);
            return true;
        }

        public int getRandom() {
            //because we are storing values in an arraylist, we can simply get a random index
            return array.get(rand.nextInt(array.size()));
        }
    }
}
