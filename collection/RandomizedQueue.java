// javac -cp .:lib/algs4.jar collection/RandomizedQueue.java
// java -cp .:lib/algs4.jar collection.RandomizedQueue

package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arr;
    private int sz;

    // construct an empty randomized queue
    public RandomizedQueue() {
        @SuppressWarnings("unchecked") // comment this out before submitting
        Item[] newarr = (Item[]) new Object[2];
        arr = newarr;
        sz = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return sz == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return sz;
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked") // comment this out before submitting
        Item[] newarr = (Item[]) new Object[capacity];
        for (int i = 0; i < sz; i++) newarr[i] = arr[i];
        arr = newarr;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (sz == arr.length) resize(sz * 2);
        arr[sz++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int idx = StdRandom.uniformInt(sz);
        Item item = arr[idx];
        if (idx != sz - 1) arr[idx] = arr[sz - 1];
        // no loitering
        // (see slide 4 of https://algs4.cs.princeton.edu/lectures/keynote/13StacksAndQueues-2x2.pdf)
        arr[--sz] = null;
        if (sz > 0 && sz == arr.length / 4) resize(arr.length / 2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return arr[StdRandom.uniformInt(sz)];
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private int i = 0;
        private int[] rngIndices = new int[sz];

        public ArrayIterator() {
            for (int j = 0; j < sz; j++) rngIndices[j] = j;
            StdRandom.shuffle(rngIndices);
        }

        @Override
        public boolean hasNext() {
            return i < sz;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arr[rngIndices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        StdOut.println(rq.dequeue());
        rq.enqueue(4);
        rq.enqueue(5);
        StdOut.println(rq.dequeue());
        for (int i : rq) StdOut.println(i);
        StdOut.println(rq.size());
        StdOut.println(rq.isEmpty());
    }
}
