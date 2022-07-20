package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int first; // Index of the first item in the circular queue.
    private int last; // Index of the last item in the circular queue.

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
    }


    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resizeArray(size * 2);
        }
        size += 1;
        if (size == 1) {
            first = 0;
            last = 0;
        } else {
            if (first == 0) {
                first = items.length - 1;
            } else {
                first -= 1;
            }
        }
        items[first] = item;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resizeArray(size * 2);
        }
        size += 1;
        if (size == 1) {
            first = 0;
            last = 0;
        } else {
            if (last == items.length - 1) {
                last = 0;
            } else {
                last += 1;
            }
        }
        items[last] = item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            shrinkArray();
            T firstItem = items[first];
            items[first] = null;
            size -= 1;
            if (first == items.length - 1) { // "first" falls on the biggest index of the array
                first = 0;
            } else {
                first += 1;
            }
            return firstItem;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            shrinkArray();
            T lastItem = items[last];
            items[last] = null;
            size -= 1;
            if (last == 0) { // "last" falls on index 0 of the array
                last = items.length - 1;
            } else {
                last -= 1;
            }
            return lastItem;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (size > 0 && index < size) {
            if (first + index < items.length) {
                return items[first + index];
            } else {
                return items[first + index - items.length];
            }
        }
        return null;
    }

    @Override
    public void printDeque() {
        /* Consider two situations -
         * first < last: array index 0 does not fall in the middle of the deque (easy mode).
         *     [null, null, first, xx, xx, xx, last, null, null]
         *
         * first > last: array index 0 falls in the middle of the deque.
         *     [xx, xx, xx, last, null, null, null, first, xx, xx]
         * */

        if (size > 0) {
            if (first <= last) {
                for (int i = first; i <= last; i++) {
                    System.out.print(items[i] + " ");
                }
            } else {
                for (int i = first; i <= items.length; i++) {
                    System.out.print(items[i] + " ");
                }
                for (int i = 0; i <= last; i++) {
                    System.out.print(items[i] + " ");
                }
            }
            System.out.println();
        }
    }

    /** HELPER methods below. */

    private void resizeArray(int capacity) {
        /* Consider the two situations mentioned above. */

        T[] newItems = (T []) new Object[capacity];
        if (first < last) {
            System.arraycopy(items, first, newItems, 0, size);
        } else {
            System.arraycopy(items, first, newItems, 0, (items.length - first));
            System.arraycopy(items, 0, newItems, (items.length - first), (last + 1));
        }
        items = newItems;
        first = 0;
        last = size - 1;
    }

    /* check array usage. If usage < 25% then shrink array length. */
    private void shrinkArray() {
        if ((size <= items.length / 4) && (size > 4)) {
            resizeArray(items.length / 4);
        }
    }

    /** Make lld iterable. */

    public Iterator<T> iterator() {
        return new AdIterator();
    }

    private class AdIterator implements Iterator<T> {
        private int wizPos;
        public AdIterator() {
            wizPos = first;
        }

        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            return wizPos != last + 1;
        }

        public T next() {
            T returnItem = items[wizPos];
            if (wizPos == items.length - 1) {
                wizPos = 0;
            } else {
                wizPos += 1;
            }
            return returnItem;
        }
    }
}
