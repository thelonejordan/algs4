package unionfind;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int gridsize;
    private int numel;
    private int virtualSource;
    private int virtualSink;
    private boolean[] opened;
    private WeightedQuickUnionUF model;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        gridsize = n;
        numel = gridsize * gridsize;
        model = new WeightedQuickUnionUF(numel + 2);
        opened = new boolean[numel]; // source and sink are always open
        virtualSource = numel;
        virtualSink = numel + 1;
        for (int i = 0; i < n; i++) {
            model.union(virtualSource, i);
            model.union(virtualSink, numel - i - 1);
        }
    }

    private void check(int row, int col) {
        if ((row < 0) || (col < 0) || (row >= gridsize) || (col >= gridsize)) {
            throw new IllegalArgumentException("invalid args");
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        check(row, col);
        int idx = col * gridsize + row;
        if (opened[idx]) { return; }
        else { opened[idx] = true; }

        if (idx < gridsize) { model.union(virtualSource, idx); }
        else {
            int up = idx - gridsize;
            if (opened[up]) model.union(idx, up);
        }
        if (idx >= numel - gridsize - 1) { model.union(virtualSink, idx); }
        else {
            int down = idx + gridsize;
            if (opened[down]) model.union(idx, down);
        }
        int left = idx - 1;
        int right = idx + 1;
        if ((left >= 0) && (opened[left])) model.union(idx, left);
        if ((right < numel) && (opened[right])) model.union(idx, right);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        check(row, col);
        return opened[col * gridsize + row];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        check(row, col);
        // return model.connected(virtual_source, col * gridsize + row);
        return model.find(virtualSource) == model.find(col * gridsize + row);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        for (int i = 0; i < numel; i++) {
            if (opened[i]) count++;
        }
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        // return model.connected(virtual_source, virtual_sink);
        return model.find(virtualSource) == model.find(virtualSink);
    }

    // test client (optional)
    public static void main(String[] args) {
        // TODO: write this
    }
}
