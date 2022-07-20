package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }


    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        //https://www.youtube.com/watch?v=hoYMyvWjCTg&list=PL8FaHk7qbOD7Ycy9QeJSPXVoTwAH52Rlw&index=3
        //4:45 sentinel null
        sentinel = new Node(null, null,null);
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node(null, null, null);
        Node first = new Node(item, sentinel, sentinel);
        sentinel.prev = first;
        sentinel.next = first;
        size = 1;
    }


    @Override
    public void addFirst(T item) {
        size += 1;
        Node node;
        if (size == 1) {
            node = new Node(item, sentinel, sentinel);
            sentinel.prev = node;
        } else {
            node = new Node(item, sentinel, sentinel.next);
            sentinel.next.prev = node;
        }
        sentinel.next = node;
    }

    @Override
    public void addLast(T item) {
        size += 1;
        Node node;
        if (size == 1) {
            node = new Node(item, sentinel, sentinel);
            sentinel.next = node;
        } else {
            node = new Node(item, sentinel.prev, sentinel);
            sentinel.prev.next = node;
        }
        sentinel.prev = node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            size -= 1;
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return first;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            size -= 1;
            T last = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return last;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (size > 0 && index < size) {
            Node current = sentinel;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
            return current.item;
        }
        return null;
    }

    public T getRecursive(int index) {
        // TODO: to be finished.
        Node current;
        if (size == 0 || index >= size) {
            return null;
        } else if (size == 1) {
            current = sentinel.next;
        } else {
            current = null;
        }
        return current.item;
    }

    @Override
    public void printDeque() {
        if (size > 0) {
            Node current = sentinel.next;
            for (int i = 0; i < size; i++) {
                System.out.print(current.item + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    /** Make lld iterable. */
    public Iterator<T> iterator() {
        return new LldIterator();
    }

    private class LldIterator implements Iterator<T> {
        private Node wizNode;
        public LldIterator() {
            wizNode = sentinel;
        }

        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            return wizNode.next != sentinel;
        }

        public T next() {
            wizNode = wizNode.next;
            return wizNode.item;
        }
    }
}
