// javac -cp .:lib/algs4.jar wordnet/WordNet.java
// java -cp .:lib/algs4.jar wordnet.WordNet wordnet/synsets.txt wordnet/hypernyms.txt

package wordnet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Digraph;

public class WordNet {
    private final Digraph dg;
    private final ST<String, SET<Integer>> nouns;
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null) throw new IllegalArgumentException();
        if (hypernyms == null) throw new IllegalArgumentException();
        int count = 0;
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
        dg = new Digraph(count);
        while (!hyp.isEmpty()) {
            String[] content = hyp.readLine().split(",");
            assert content.length >= 1;
            int synId = Integer.parseInt(content[0]);
            for (int i = 1; i < content.length; i++) {
                dg.addEdge(synId, Integer.parseInt(content[i]));
            }
        }
        Topological t = new Topological(dg);
        if (!t.hasOrder()) throw new IllegalArgumentException();
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
        SAP sap = new SAP(dg);
        return sap.length(nouns.get(nounA), nouns.get(nounB));
    }

    private int[] bfs(int s) {
        boolean[] marked = new boolean[dg.V()];
        int[] edgeTo = new int[dg.V()];
        Queue<Integer> q = new Queue<>();
        q.enqueue(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : dg.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
        return edgeTo;
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        SAP sap = new SAP(dg);
        SET<Integer> as = nouns.get(nounA);
        SET<Integer> bs = nouns.get(nounB);
        int ca = sap.ancestor(as, bs);
        int[] edgeTo = bfs(ca);
        int a = ca;
        int b = ca;
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new Queue<>();
        while (!as.contains(a)) {
            a = edgeTo[a];
            s.push(a);
        }
        while (!bs.contains(b)) {
            b = edgeTo[b];
            q.enqueue(b);
        }
        StringBuilder out = new StringBuilder();
        while (!s.isEmpty()) {
            out.append(s.pop() + "-");
        }
        out.append(ca);
        while (!q.isEmpty()) {
            out.append("-" + q.dequeue());
        }
        return out.toString();
    }

    // do unit testing of this class
    public static void main(String[] args) {        
        WordNet wn = new WordNet(args[0], args[1]);
        for (String noun : wn.nouns()) {
            StdOut.println(noun);
            StdOut.println(wn.nouns.get(noun));
        }
        String nounA = "1900s";
        String nounB = "9/11";
        StdOut.println(wn.isNoun(nounA));
        StdOut.println(wn.isNoun(nounB));
        StdOut.println(wn.distance(nounA, nounB));
    }
}
