package companies.walmart;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = new int[]{1, 2};
        System.out.println(numRescueBoats(people, 3));

        people = new int[]{3, 2, 2, 1};
        System.out.println(numRescueBoats(people, 3));

        people = new int[]{3, 5, 3, 4};
        System.out.println(numRescueBoats(people, 5));
    }


    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        int count = 0;

        while (l < r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            count++;
            r--;
        }

        if (l == r) {
            count++;
        }

        return count;
    }
}
