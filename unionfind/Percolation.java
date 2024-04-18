package unionfind;

// TODO: fix bonus test (MEMORY :: Analyzing memory of Percolation)

// Test 2 (bonus): check that total memory <= 11 n^2 + 128 n + 1024 bytes
// -  failed memory test for n = 64
// ==> FAILED

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int gridsize;
    private int virtualSource;
    private int virtualSink;
    private boolean[] opened;
    private int openedCount;
    private WeightedQuickUnionUF model;
    private WeightedQuickUnionUF backwash;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("invalid arg");
        }
        gridsize = n;
        int numel = gridsize * gridsize;
        virtualSource = numel;
        virtualSink = virtualSource + 1;
        model = new WeightedQuickUnionUF(numel + 2);
        backwash = new WeightedQuickUnionUF(numel + 1);
        opened = new boolean[numel]; // source and sink are always open
        openedCount = 0;
    }

    private int flatIndex(int row, int col) {
        validate(row, col);
        return (row - 1) * gridsize + col - 1;
    }

    private void validate(int row, int col) {
        if ((row < 1) || (col < 1) || (row > gridsize) || (col > gridsize)) {
            throw new IllegalArgumentException("invalid args");
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int idx = flatIndex(row, col);
        if (opened[idx]) return;
        opened[idx] = true;
        openedCount++;

        if (row == 1) {
            model.union(virtualSource, idx);
            backwash.union(virtualSource, idx);
        }
        else {
            // up exists
            int up = idx - gridsize;
            if (opened[up]) {
                model.union(idx, up);
                backwash.union(idx, up);
            }
        }
        if (row == gridsize) {
            model.union(virtualSink, idx);
            // no backwash here
        }
        else {
            // down exists
            int down = idx + gridsize;
            if (opened[down]) {
                model.union(idx, down);
                backwash.union(idx, down);
            }
        }
        int left = idx - 1;
        int right = idx + 1;
        if (col != 1 && opened[left]) {
            model.union(idx, left);
            backwash.union(idx, left);
        }
        if (col != gridsize && opened[right]) {
            model.union(idx, right);
            backwash.union(idx, right);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int idx = flatIndex(row, col);
        return opened[idx];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int idx = flatIndex(row, col);
        // return model.connected(virtualSource, idx);
        return isOpen(row, col) && backwash.find(virtualSource) == backwash.find(idx);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedCount;
    }

    // does the system percolate?
    public boolean percolates() {
        // return model.connected(virtual_source, virtualSink);
        return model.find(virtualSource) == model.find(virtualSink);
    }

    // test client (optional)
    public static void main(String[] args) {
        // TODO: write this
    }
}
