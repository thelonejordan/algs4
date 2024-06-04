// javac -cp .:lib/algs4.jar wordnet/SAP.java
// java -cp .:lib/algs4.jar wordnet.SAP wordnet/digraph1.txt

package wordnet;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SAP {
    // check out https://algs4.cs.princeton.edu/42directed/BreadthFirstDirectedPaths.java.html
    // private static final int INFINITY = Integer.MAX_VALUE;
    private final Digraph dg;
    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        dg = new Digraph(G);
    }

    private void bfs(int s, boolean[] marked, int[] distance) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(s);
        marked[s] = true;
        distance[s] = 0;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : dg.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true;
                    distance[w] = distance[v] + 1;
                }
            }
        }
    }

    private void bfs(Iterable<Integer> sources, boolean[] marked, int[] distance) {
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distance[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : dg.adj(v)) {
                if (!marked[w]) {
                    distance[w] = distance[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (v < 0 || v >= dg.V()) throw new IllegalArgumentException();
        if (w < 0 || w >= dg.V()) throw new IllegalArgumentException();
        boolean[] markedA = new boolean[dg.V()];
        boolean[] markedB = new boolean[dg.V()];
        int[] distanceA = new int[dg.V()];
        int[] distanceB = new int[dg.V()];
        bfs(v, markedA, distanceA);
        bfs(w, markedB, distanceB);
        int minDist = -1;
        for (int i = 0; i < dg.V(); i++) {
            if (markedA[i] && markedB[i]) {
                int dist = distanceA[i] + distanceB[i];
                if (minDist == -1 || minDist > dist) minDist = dist;
            }
        }
        return minDist;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        if (v < 0 || v >= dg.V()) throw new IllegalArgumentException();
        if (w < 0 || w >= dg.V()) throw new IllegalArgumentException();
        boolean[] markedA = new boolean[dg.V()];
        boolean[] markedB = new boolean[dg.V()];
        int[] distanceA = new int[dg.V()];
        int[] distanceB = new int[dg.V()];
        bfs(v, markedA, distanceA);
        bfs(w, markedB, distanceB);
        int minDist = -1;
        int sca = -1;
        for (int i = 0; i < dg.V(); i++) {
            if (markedA[i] && markedB[i]) {
                int dist = distanceA[i] + distanceB[i];
                if (minDist == -1 || minDist > dist) {
                    minDist = dist;
                    sca = i;
                }
            }
        }
        return sca;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) throw new IllegalArgumentException();
        for (Object iv : v) {
            if (iv == null) throw new IllegalArgumentException();
            int iiv = (int) iv;
            if (iiv < 0 || iiv >= dg.V()) throw new IllegalArgumentException();
        }
        for (Object iw : w) {
            if (iw == null) throw new IllegalArgumentException();
            int iiw = (int) iw;
            if (iiw < 0 || iiw >= dg.V()) throw new IllegalArgumentException();
        }
        boolean[] markedA = new boolean[dg.V()];
        boolean[] markedB = new boolean[dg.V()];
        int[] distanceA = new int[dg.V()];
        int[] distanceB = new int[dg.V()];
        bfs(v, markedA, distanceA);
        bfs(w, markedB, distanceB);
        int minDist = -1;
        for (int i = 0; i < dg.V(); i++) {
            if (markedA[i] && markedB[i]) {
                int dist = distanceA[i] + distanceB[i];
                if (minDist == -1 || minDist > dist) minDist = dist;
            }
        }
        return minDist;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null || w == null) throw new IllegalArgumentException();
        for (Object iv : v) {
            if (iv == null) throw new IllegalArgumentException();
            int iiv = (int) iv;
            if (iiv < 0 || iiv >= dg.V()) throw new IllegalArgumentException();
        }
        for (Object iw : w) {
            if (iw == null) throw new IllegalArgumentException();
            int iiw = (int) iw;
            if (iiw < 0 || iiw >= dg.V()) throw new IllegalArgumentException();
        }
        boolean[] markedA = new boolean[dg.V()];
        boolean[] markedB = new boolean[dg.V()];
        int[] distanceA = new int[dg.V()];
        int[] distanceB = new int[dg.V()];
        bfs(v, markedA, distanceA);
        bfs(w, markedB, distanceB);
        int minDist = -1;
        int sca = -1;
        for (int i = 0; i < dg.V(); i++) {
            if (markedA[i] && markedB[i]) {
                int dist = distanceA[i] + distanceB[i];
                if (minDist == -1 || minDist > dist) {
                    minDist = dist;
                    sca = i;
                }
            }
        }
        return sca;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length   = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}
