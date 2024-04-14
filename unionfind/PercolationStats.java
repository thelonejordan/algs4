// javac -cp .:lib/algs4.jar unionfind/PercolationStats.java
// java -cp .:lib/algs4.jar unionfind.PercolationStats 30 100

package unionfind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] opened_fracs;
    private int ntrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Given N <= 0 || T <= 0");
        }
        ntrials = trials;
        opened_fracs = new double[trials];
        for (int i = 0; i < trials; i++) {
            int opened_sites = 0;
            Percolation experiment = new Percolation(n);
            while (!experiment.percolates()) {
                int r = StdRandom.uniformInt(n);
                int c = StdRandom.uniformInt(n);
                if (!experiment.isOpen(r, c)) {
                    experiment.open(r, c);
                    opened_sites++;
                }
            }
            opened_fracs[i] = (double) opened_sites / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(opened_fracs);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(opened_fracs);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double z_score_95 = 1.96;
        return mean() - ((z_score_95 * stddev()) / Math.sqrt(ntrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(ntrials));
    }

   // test client (see below)
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(N, T);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}
