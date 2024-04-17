// javac -cp .:lib/algs4.jar collection/Permutation.java
// java -cp .:lib/algs4.jar collection.Permutation 3 < collection/distinct.txt
// java -cp .:lib/algs4.jar collection.Permutation 8 < collection/duplicates.txt
package collection;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }
    }
}
