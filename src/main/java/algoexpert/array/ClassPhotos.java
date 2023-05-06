package algoexpert.array;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {
    public static void main(String[] args) {

    }

    private static boolean solve(final ArrayList<Integer> redShirtHeights, final ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        ArrayList<Integer> firstRow;
        ArrayList<Integer> secondRow;

        if (redShirtHeights.get(0) < blueShirtHeights.get(0)) {
            firstRow = redShirtHeights;
            secondRow = blueShirtHeights;
        } else {
            firstRow = blueShirtHeights;
            secondRow = redShirtHeights;
        }

        for (int i = 0; i < firstRow.size(); i++) {
            if (firstRow.get(i) >= secondRow.get(i)) {
                return false;
            }
        }

        return true;
    }
}
