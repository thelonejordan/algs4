package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int gridsize;
    private final int virtualSource;
    private final WeightedQuickUnionUF model;
    private boolean[] linked; // to sink
    private boolean[] opened;
    private int openedCount;
    private boolean percolates = false;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException();
        gridsize = n;
        int numel = gridsize * gridsize;
        virtualSource = numel;
        model = new WeightedQuickUnionUF(numel + 1);
        opened = new boolean[numel]; // source is always open
        linked = new boolean[numel + 1];
        openedCount = 0;
    }

    private void validate(int row, int col) {
        if ((row < 1) || (col < 1) || (row > gridsize) || (col > gridsize)) {
            throw new IllegalArgumentException();
        }
    }

    private int xyTo1D(int row, int col) {
        validate(row, col);
        return (row - 1) * gridsize + col - 1;
    }

    private boolean isBlue(int idx) {
        return opened[idx] && model.find(virtualSource) == model.find(idx);
    }

    private void link(int idx) {
        linked[idx] = true;
        linked[model.find(idx)] = true;
        if (isBlue(idx)) percolates = true;
    }

    private boolean linked(int idx) {
        return linked[idx] || linked[model.find(idx)];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int idx = xyTo1D(row, col);
        if (opened[idx]) return;
        opened[idx] = true;
        openedCount++;
        boolean c = linked(idx) || row == gridsize;

        if (row == 1) model.union(virtualSource, idx);
        if (row > 1) { // up exists
            int up = xyTo1D(row - 1, col);
            if (!c && linked(up)) c = true;
            if (opened[up]) model.union(idx, up);
        }
        if (row < gridsize) { // down exists
            int down = xyTo1D(row + 1, col);
            if (!c && linked(down)) c = true;
            if (opened[down]) model.union(idx, down);
        }
        if (col > 1) { // left exists
            int left = xyTo1D(row, col - 1);
            if (!c && linked(left)) c = true;
            if (opened[left]) model.union(idx, left);
        }
        if (col < gridsize) { // right exists
            int right = xyTo1D(row, col + 1);
            if (!c && linked(right)) c = true;
            if (opened[right]) model.union(idx, right);
        }

        if (c) link(idx);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return opened[xyTo1D(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return isBlue(xyTo1D(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolates;
    }
}
