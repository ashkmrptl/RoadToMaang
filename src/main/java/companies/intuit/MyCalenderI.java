package companies.intuit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MyCalenderI {

    //The following can also be a sorted map/tree map
    final List<int[]> list;
    final TreeSet<int[]> tree;

    public MyCalenderI() {
        list = new ArrayList<>();
        tree = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
    }

    public boolean book(int start, int end) {
        for (final int[] existing : list) {
            if ((existing[0] <= start && start < existing[1]) || (start <= existing[0] && existing[0] < end)) {
                return false;
            }
        }
        list.add(new int[]{start, end});

        return true;
    }

    public boolean book_tree(int start, int end) {
        for (final int[] existing : tree) {
            if ((existing[0] <= start && start < existing[1]) || (start <= existing[0] && existing[0] < end)) {
                return false;
            }
        }
        tree.add(new int[]{start, end});

        return true;
    }

    public static void main(String[] args) {
        final MyCalenderI calender = new MyCalenderI();
        System.out.println(calender.book(10, 20));
        System.out.println(calender.book(15, 25));
        System.out.println(calender.book(20, 30));

        System.out.println(calender.book_tree(10, 20));
        System.out.println(calender.book_tree(15, 25));
        System.out.println(calender.book_tree(20, 30));
    }
}
