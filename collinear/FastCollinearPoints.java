// javac-algs4 collinear/FastCollinearPoints.java
// java-algs4 collinear.FastCollinearPoints collinear/input6.txt

package collinear;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private LineSegment[] segments = new LineSegment[2];
    private int count = 0;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException(); // no null points
        }
        Point[] pts = new Point[points.length];
        for (int i = 0; i < points.length; i++) pts[i] = points[i]; // make a copy
        Arrays.sort(pts);
        for (int i = 1; i < pts.length; i++) {
            if (pts[i].compareTo(pts[i - 1]) == 0) {
                throw new IllegalArgumentException(); // only distinct points
            }
        }
        getLineSegments(pts); // get line segments
    }

    // the number of line segments
    public int numberOfSegments() {
        return count;
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] ret = new LineSegment[count];
        for (int i = 0; i < count; i++) ret[i] = segments[i];
        return ret;
    }

    private void getLineSegments(Point[] pts) {
        int numpts = pts.length;
        Point[] ptsSlope = new Point[numpts - 1];
        for (int k = 0; k + 3 < numpts; k++) {
            Point base = pts[k];
            // copy required slice of the array to be sorted by slope
            for (int i = 0; i < numpts - 1; i++) {
                if (i < k) ptsSlope[i] = pts[i];
                else ptsSlope[i] = pts[i + 1];
            }
            Arrays.sort(ptsSlope, base.slopeOrder()); // sort by slope wrt base (needs to be stable)
            int low = 0; // start index into ptsSlope
            double lastSlope = Double.NEGATIVE_INFINITY;
            for (int high = 0; high < ptsSlope.length; high++) {
                double curSlope = base.slopeTo(ptsSlope[high]);
                if (high == 0) {
                    lastSlope = curSlope;
                }
                // add line segment
                else if (curSlope != lastSlope) {
                    if (ptsSlope[low].compareTo(base) > 0 && high - low + 1 >= 4) {
                        LineSegment ls = new LineSegment(base, ptsSlope[high - 1]);
                        addLineSegment(ls);
                    }
                    lastSlope = curSlope;
                    low = high;
                }
                // add last line segment
                else if (curSlope == lastSlope && high == ptsSlope.length - 1) {
                    if (ptsSlope[low].compareTo(base) > 0 && high - low + 2 >= 4) {
                        LineSegment ls = new LineSegment(base, ptsSlope[high]);
                        addLineSegment(ls);
                    }
                }
            }
        }
    }

    private void resize(int capacity) {
        LineSegment[] newsegments = new LineSegment[capacity];
        for (int i = 0; i < count; i++) newsegments[i] = segments[i];
        segments = newsegments;
    }

    private void addLineSegment(LineSegment ls) {
        if (ls == null) throw new IllegalArgumentException();
        if (count == segments.length) resize(count * 2);
        segments[count++] = ls;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.setPenRadius(0.01);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        StdDraw.setPenRadius(0.005);
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
