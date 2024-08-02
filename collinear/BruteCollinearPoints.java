// javac-algs4 collinear/BruteCollinearPoints.java
// java-algs4 collinear.BruteCollinearPoints collinear/input6.txt

package collinear;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    private LineSegment[] segments = new LineSegment[2];
    private int count = 0;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException(); // no null points
        }
        Point[] pts = new Point[points.length];
        for (int i = 0; i < points.length; i++) pts[i] = points[i]; // make a copy
        Arrays.sort(pts);
        for (int i = 1; i < pts.length; i++) {
            if (pts[i].compareTo(pts[i - 1]) == 0)
                throw new IllegalArgumentException(); // only distinct points
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
        for (int i = 0; i + 3 < pts.length; i++) {
            for (int j = i + 1; j + 2 < pts.length; j++) {
                for (int k = j + 1; k + 1 < pts.length; k++) {
                    for (int w = k + 1; w < pts.length; w++) {
                        Point a = pts[i];
                        Point b = pts[j];
                        Point c = pts[k];
                        Point d = pts[w];
                        double slope1 = a.slopeTo(b);
                        double slope2 = a.slopeTo(c);
                        double slope3 = a.slopeTo(d);
                        // get line segments
                        if (slope1 == slope2 && slope2 == slope3) {
                            addLineSegment(new LineSegment(a, d));
                        }
                    }
                }
            }
        }
    }

    private void addLineSegment(LineSegment ls) {
        if (ls == null) throw new IllegalArgumentException();
        if (count == segments.length) resize(count * 2);
        segments[count++] = ls;
    }

    private void resize(int capacity) {
        LineSegment[] newsegments = new LineSegment[capacity];
        for (int i = 0; i < count; i++) newsegments[i] = segments[i];
        segments = newsegments;
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
