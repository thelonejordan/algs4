// javac -cp .:lib/algs4.jar collection/Permutation.java
// java -cp .:lib/algs4.jar collection.Permutation 3 < collection/distinct.txt
// java -cp .:lib/algs4.jar collection.Permutation 8 < collection/duplicates.txt

package queues;

// TODO: fix bonus test (MEMORY :: Analyzing memory of Permutation) by using reservior sampling
// https://github.com/herricane/Deques-and-Randomized-Queues/commit/617b7e35b9e4bebbf6d5a467b8d6d2f774428c37

// */ Test 3 (bonus): check that maximum size of any or Deque or RandomizedQueue object
// created is equal to k
// * filename = tale.txt, n = 138653, k = 5
//   - max size of RandomizedQueue object = 138653
//
// * filename = tale.txt, n = 138653, k = 50
//   - max size of RandomizedQueue object = 138653
//
// * filename = tale.txt, n = 138653, k = 500
//   - max size of RandomizedQueue object = 138653
//
// * filename = tale.txt, n = 138653, k = 5000
//   - max size of RandomizedQueue object = 138653
//
// * filename = tale.txt, n = 138653, k = 50000
//   - max size of RandomizedQueue object = 138653
//
// ==> FAILED

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) rq.enqueue(StdIn.readString());
        for (int i = 0; i < k; i++) StdOut.println(rq.dequeue());
    }
}
