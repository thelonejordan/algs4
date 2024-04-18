// javac -cp .:lib/algs4.jar collection/Deque.java
// java -cp .:lib/algs4.jar collection.Deque

package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    private Node first, last;
    private int sz;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        sz = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return sz == 0;
    }

    // return the number of items on the deque
    public int size() {
        return sz;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node newfirst = new Node();
        newfirst.item = item;
        newfirst.prev = null;
        if (isEmpty()) {
            newfirst.next = null;
            first = newfirst;
            last = newfirst;
        }
        else {
            newfirst.next = first;
            first.prev = newfirst;
            first = newfirst;
        }
        sz++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node newlast = new Node();
        newlast.item = item;
        newlast.next = null;
        if (isEmpty()) {
            newlast.prev = null;
            first = newlast;
            last = newlast;
        }
        else {
            newlast.prev = last;
            last.next = newlast;
            last = newlast;
        }
        sz++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item removed = first.item;
        sz--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.prev = null;
        }
        return removed;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item removed = last.item;
        sz--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            last = last.prev;
            last.next = null;
        }
        return removed;
    }

    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() {
        // Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
        // Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<Integer> deq = new Deque<>();
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addLast(3);
        deq.addLast(4);
        StdOut.println(deq.removeFirst());
        StdOut.println(deq.removeLast());
        for (int i : deq) {
            StdOut.println(i);
        }
        StdOut.println(deq.size());
        StdOut.println(deq.isEmpty());
    }
}
