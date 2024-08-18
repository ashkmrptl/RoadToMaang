package companies.visa;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));

        numbers = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers, 6)));

        numbers = new int[]{-1, 0};
        System.out.println(Arrays.toString(twoSum(numbers, -1)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[2];
    }
}
