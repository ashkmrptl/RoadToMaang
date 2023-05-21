package companies.cisco;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 */
public class SuffleAnArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};

        SuffleAnArray suffleAnArray = new SuffleAnArray(nums);

        System.out.println(Arrays.toString(suffleAnArray.shuffle()));

        System.out.println(Arrays.toString(suffleAnArray.reset()));

        System.out.println(Arrays.toString(suffleAnArray.shuffle()));
    }

    final int[] nums;
    final Random random;

    public SuffleAnArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] temp = Arrays.copyOf(nums, nums.length);

        int i = temp.length - 1;

        while (i > 0) {
            int index = random.nextInt(i + 1);
            //Swap index element with i
            if (i != index) {
                int t = temp[i];
                temp[i] = temp[index];
                temp[index] = t;
            }
            i--;
        }

        return temp;
    }
}
