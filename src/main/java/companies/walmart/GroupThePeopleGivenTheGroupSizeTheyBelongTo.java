package companies.walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. Group the People Given the Group Size They Belong To
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSizes));
    }

    private static List<List<Integer>> groupThePeople(int[] groupSizes) {
        final Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                final List<List<Integer>> groups = map.get(groupSizes[i]);

                boolean added = false;

                for (final List<Integer> group : groups) {
                    if (group.size() < groupSizes[i]) {
                        group.add(i);
                        added = true;
                        break;
                    }
                }

                if (!added) {
                    final List<Integer> group = new ArrayList<>();
                    group.add(i);

                    groups.add(group);
                    map.put(groupSizes[i], groups);
                }

            } else {
                final List<Integer> group = new ArrayList<>();
                group.add(i);
                final List<List<Integer>> groups = new ArrayList<>();
                groups.add(group);

                map.put(groupSizes[i], groups);
            }
        }

        final List<List<Integer>> ans = new ArrayList<>();
        for (final Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
            ans.addAll(entry.getValue());
        }

        return ans;
    }
}