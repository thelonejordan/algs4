// javac-algs4 wordnet/Outcast.java
// java-algs4 wordnet.Outcast wordnet/synsets.txt wordnet/hypernyms.txt wordnet/outcast5.txt wordnet/outcast7.txt wordnet/outcast11.txt

package wordnet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    private final WordNet wn;
    public Outcast(WordNet wordnet) {         // constructor takes a WordNet object
        wn = wordnet;
    }
    public String outcast(String[] nouns) {  // given an array of WordNet nouns, return an outcast
        int maxDist = -1;
        int idx = 0;
        for (int i = 0; i < nouns.length; i++) {
            int dist = 0;
            for (int j = 0; j < nouns.length; j++) {
                if (i != j) {
                    dist = dist + wn.distance(nouns[i], nouns[j]);
                }
            }
            if (dist > maxDist) {
                maxDist = dist;
                idx = i;
            }
        }
        return nouns[idx];
    }

    public static void main(String[] args) { // see test client below
        if (args.length < 3) throw new IllegalArgumentException();
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int i = 2; i < args.length; i++) {
            In in = new In(args[i]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[i] + ": " + outcast.outcast(nouns));
        }
    }
}
