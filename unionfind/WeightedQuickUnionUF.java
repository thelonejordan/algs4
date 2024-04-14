package unionfind;

public class WeightedQuickUnionUF {

    private int[] id;
    private int[] sz;

    // constructor
    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) { id[i] = i; sz[i] = 1; }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // path compression (simpler one-pass variant)
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int p_root = root(p);
        int q_root = root(q);
        if (p_root == q_root) return;
        if (sz[p_root] < sz[q_root])
            { id[p_root] = q_root; sz[q_root] += sz[p_root]; }
        else
            { id[q_root] = p_root; sz[p_root] += sz[q_root]; }
    }

    public static void main (String[] args) {
        // TODO: write this
    }
}
