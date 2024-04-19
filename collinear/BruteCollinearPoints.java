// javac -cp .:lib/algs4.jar collinear/BruteCollinearPoints.java
// java -cp .:lib/algs4.jar collinear.BruteCollinearPoints collinear/input6.txt

package collinear;

import java.util.Arrays;

import edu.princeton.cs.algs4.LinkedStack;

public class BruteCollinearPoints {

    private LinkedStack<LineSegment> segs = new LinkedStack<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        Point a = points[i];
                        Point b = points[j];
                        Point c = points[k];
                        Point d = points[l];
                        double slope1 = a.slopeTo(b);
                        double slope2 = a.slopeTo(c);
                        double slope3 = a.slopeTo(d);
                        if (slope1 == slope2 && slope2 == slope3) {
                            segs.push(new LineSegment(a, d));
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segs.size();
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] ret = new LineSegment[segs.size()];
        for (int i = 0; i < segs.size(); i++) {
            ret[i] = segs.pop();
        }
        return ret;
    }
}
