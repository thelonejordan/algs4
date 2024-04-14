// javac -cp .:lib/algs4.jar unionfind/PercolationStats.java
// java -cp .:lib/algs4.jar unionfind.PercolationStats 30 100

package unionfind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double ZSCORE95 = 1.96;
    private double[] openedFractions;
    private int ntrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("invalid args");
        }
        ntrials = trials;
        openedFractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            int openedSites = 0;
            Percolation experiment = new Percolation(n);
            while (!experiment.percolates()) {
                int r = StdRandom.uniformInt(n) + 1;
                int c = StdRandom.uniformInt(n) + 1;
                if (!experiment.isOpen(r, c)) {
                    experiment.open(r, c);
                    openedSites++;
                }
            }
            openedFractions[i] = (double) openedSites / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openedFractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(openedFractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((ZSCORE95 * stddev()) / Math.sqrt(ntrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((ZSCORE95 * stddev()) / Math.sqrt(ntrials));
    }

   // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);

        String confidence = "[" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]";
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}
