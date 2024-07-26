// javac -cp .:lib/algs4.jar kdtrees/PointSET.java
// java -cp .:lib/algs4.jar kdtrees.PointSET < kdtrees/input10.txt

package kdtrees;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
    private SET<Point2D> points;

    public PointSET() {                               // construct an empty set of points
        points = new SET<>();
    }
    public boolean isEmpty() {                     // is the set empty?
        return points.isEmpty();
    }
    public int size() {                        // number of points in the set
        return points.size();
    } 
    public void insert(Point2D p) {             // add the point to the set (if it is not already in the set)
        if (p == null) throw new IllegalArgumentException();
        points.add(p);
    }
    public boolean contains(Point2D p) {           // does the set contain point p?
        if (p == null) throw new IllegalArgumentException();
        return points.contains(p);
    }
    public void draw() {                        // draw all points to standard draw
        for (Point2D p : points) {
            p.draw();
        }
    }
    public Iterable<Point2D> range(RectHV rect) {            // all points that are inside the rectangle (or on the boundary)
        if (rect == null) throw new IllegalArgumentException();
        if (points.isEmpty()) return null;
        Stack<Point2D> ret = new Stack<>();
        for (Point2D p : points) {
            if (rect.contains(p)) ret.push(p);
        }
        return ret;
    }
    public Point2D nearest(Point2D p) {            // a nearest neighbor in the set to point p; null if the set is empty
        if (p == null) throw new IllegalArgumentException();
        if (points.isEmpty()) return null;
        Point2D nearestPoint = null;
        for (Point2D x : points) {
            if (nearestPoint == null) {
                nearestPoint = x;
                continue;
            }
            if (p.distanceSquaredTo(x) < p.distanceSquaredTo(nearestPoint)) {
                nearestPoint = x;
            }
        }
        return nearestPoint;
    }
    public static void main(String[] args) {                 // unit testing of the methods (optional)
        
        PointSET pts = new PointSET();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            pts.insert(new Point2D(x, y));
        }
        StdDraw.setPenRadius(0.01);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        pts.draw();
        StdOut.println("no. of points = " + pts.size());
        RectHV rect = new RectHV(0.25, 0.25, 0.6, 0.6);
        StdDraw.setPenColor(StdDraw.RED);
        rect.draw();
        StdOut.println("range = " + rect.toString());
        for (Point2D p : pts.range(rect)) {
            StdOut.println("within range = " + p.toString());
        }
        StdDraw.show();
        Point2D np = pts.nearest(new Point2D(0, 0));
        if (np == null) StdOut.println("nearest = null");
        else StdOut.println("nearest = " + np.toString());
    }
}
