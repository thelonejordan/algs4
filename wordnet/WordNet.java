// javac -cp .:lib/algs4.jar wordnet/WordNet.java
// java -cp .:lib/algs4.jar wordnet.WordNet wordnet/synsets.txt wordnet/hypernyms.txt

package wordnet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Topological;

public class WordNet {
    private final ST<Integer, String> vertices;
    private final ST<String, SET<Integer>> nouns;
    private final SAP sap;
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null) throw new IllegalArgumentException();
        if (hypernyms == null) throw new IllegalArgumentException();
        int count = 0;
        vertices = new ST<>();
        nouns = new ST<>();
        In syn = new In(synsets);
        In hyp = new In(hypernyms);
        while (!syn.isEmpty()) {
            String[] content = syn.readLine().split(",");
            assert content.length == 3;
            int id = Integer.parseInt(content[0]);
            String synset = content[1];
            // String definition = content[2];
            String[] words = synset.split(" ");
            vertices.put(id, synset);
            for (String word : words) {
                if (nouns.contains(word)) {
                    nouns.get(word).add(id);
                }
                else {
                    SET<Integer> ids = new SET<>();
                    ids.add(id);
                    nouns.put(word, ids);
                }
            }
            count++;
        }
        Digraph dg = new Digraph(count);
        while (!hyp.isEmpty()) {
            String[] content = hyp.readLine().split(",");
            assert content.length >= 1;
            int synId = Integer.parseInt(content[0]);
            for (int i = 1; i < content.length; i++) {
                dg.addEdge(synId, Integer.parseInt(content[i]));
            }
        }
        // this ensures SAP methods doesn't return -1
        Topological t = new Topological(dg);
        if (!t.hasOrder()) throw new IllegalArgumentException();
        sap = new SAP(dg);
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return nouns.keys();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return nouns.contains(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        return sap.length(nouns.get(nounA), nouns.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        SET<Integer> as = nouns.get(nounA);
        SET<Integer> bs = nouns.get(nounB);
        return vertices.get(sap.ancestor(as, bs));
    }

    // do unit testing of this class
    public static void main(String[] args) {        
        WordNet wn = new WordNet(args[0], args[1]);
        for (String noun : wn.nouns()) {
            StdOut.println(noun);
            StdOut.println(wn.nouns.get(noun));
        }
        while (!StdIn.isEmpty()) {
            String nounA = StdIn.readString();
            String nounB = StdIn.readString();
            StdOut.println("isNoun(nounA) = " + wn.isNoun(nounA));
            StdOut.println("isNoun(nounB) = " + wn.isNoun(nounB));
            StdOut.println("distance(nounA, nounB) = " + wn.distance(nounA, nounB));
            StdOut.println("sap(nounA, nounB) = " + wn.sap(nounA, nounB));
        }
    }
}
