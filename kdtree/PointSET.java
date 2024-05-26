// javac -cp .:lib/algs4.jar kdtree/PointSET.java
// java -cp .:lib/algs4.jar kdtree.PointSET kdtree/input10.txt

package kdtree;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
    private SET<Point2D> points;
    public PointSET() {                               // construct an empty set of points
        points = new SET<>();
    }
    private static void validate(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
    }
    public boolean isEmpty() {                     // is the set empty?
        return points.isEmpty();
    }
    public int size() {                        // number of points in the set
        return points.size();
    } 
    public void insert(Point2D p) {             // add the point to the set (if it is not already in the set)
        validate(p);
        points.add(p);
    }
    public boolean contains(Point2D p) {           // does the set contain point p?
        validate(p);
        return points.contains(p);
    }
    public void draw() {                        // draw all points to standard draw
        for (Point2D p : points) {
            p.draw();
        }
    }
    public Iterable<Point2D> range(RectHV rect) {            // all points that are inside the rectangle (or on the boundary)
        if (points.isEmpty()) return null;
        Stack<Point2D> ret = new Stack<>();
        for (Point2D p : points) {
            if (rect.contains(p)) ret.push(p);
        }
        return ret;
    }
    public Point2D nearest(Point2D p) {            // a nearest neighbor in the set to point p; null if the set is empty
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
        if (args == null) throw new IllegalArgumentException();
        In in = new In(args[0]);
        PointSET pts = new PointSET();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            pts.insert(new Point2D(x, y));
        }
        StdDraw.setPenRadius(0.01);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        pts.draw();
        StdDraw.show();
    }
}
