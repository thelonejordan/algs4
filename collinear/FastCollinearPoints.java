package collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints {

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

    }

    // the number of line segments
    public int numberOfSegments() {

    }

    // the line segments
    public LineSegment[] segments() {

    }

    public static void main(String[] args) {

        // read the n points from a file
        // In in = new In(args[0]);
        // int n = in.readInt();
        int n = Integer.parseInt(args[0]);
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            // int x = in.readInt();
            int x = Integer.parseInt(args[1]);
            // int y = in.readInt();
            int y = Integer.parseInt(args[2]);
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
