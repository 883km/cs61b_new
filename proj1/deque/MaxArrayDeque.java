package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c; // TODO: ?? Where do I instantiate c ??

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.c = c;
    }

    /*  Returns the maximum element in the deque as governed by the previously given comparator c. */
    public T max() {
        if (isEmpty()) {
            return null;
        }
        T maxItem = this.get(0);
        for (T item : this) {
            if (c.compare(item, maxItem) > 0) { // TODO: ?? c. or no c. before compare??
                maxItem = item;
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = this.get(0);
        for (T item : this) {
            if (c.compare(item, maxItem) > 0) { // TODO: ?? c. or no c. before compare??
                maxItem = item;
            }
        }
        return maxItem;
    }

    private class HashCodeComparator implements Comparator<T> {
        public int compare(T item1, T item2) {
            return item1.hashCode() - item2.hashCode();
        }
    }
}
