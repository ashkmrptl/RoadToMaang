package companies.walmart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
    final List<Integer> list;

    int currentIndex = 0;

    /**
     * This can also be done by one variable instead of creating a list
     */
    public PeekingIterator(Iterator<Integer> iterator) {
        this.currentIndex = 0;
        list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    public Integer peek() {
        return list.get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public Integer next() {
        return list.get(currentIndex++);
    }
}
