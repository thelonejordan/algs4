package percolation;

public class QuickFindUF {

    private int[] id;

    // constructor
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int p_id = id[p];
        int q_id = id[q];
        for (int i = 0; i < id.length; i++) {
            // NOTE: can't use connected here. can you tell why?
            if (id[i] == p_id) id[i] = q_id;
        }
    }

    public static void main (String[] args) {
        // TODO: write this
    }
}
