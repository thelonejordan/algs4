// javac-algs4 queues/Permutation.java
// java-algs4 queues.Permutation 3 < queues/distinct.txt
// java-algs4 queues.Permutation 8 < queues/duplicates.txt

package queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int i = 0;
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            // https://en.wikipedia.org/wiki/Reservoir_sampling
            if (i < k) rq.enqueue(item);
            else {
                int j = StdRandom.uniformInt(i + 1);
                if (j < k) {
                    rq.dequeue();
                    rq.enqueue(item);
                }
            }
            i++;
        }
        for (String item : rq) StdOut.println(item);
    }
}
