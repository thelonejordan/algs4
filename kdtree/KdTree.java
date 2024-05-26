// javac -cp .:lib/algs4.jar kdtree/KdTree.java
// java -cp .:lib/algs4.jar kdtree.KdTree kdtree/input10.txt

package kdtree;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {
    public KdTree() {                              // construct an empty set of points 
    }
    private static void validate(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
    }
    public boolean isEmpty() {                     // is the set empty?
        return true;
    }
    public int size() {                        // number of points in the set
        return 0;
    }
    public void insert(Point2D p) {             // add the point to the set (if it is not already in the set)
        validate(p);
        return;
    }
    public boolean contains(Point2D p) {           // does the set contain point p? 
        validate(p);
        return false;
    }
    public void draw() {                        // draw all points to standard draw 
        return;
    }
    public Iterable<Point2D> range(RectHV rect) {            // all points that are inside the rectangle (or on the boundary) 
        return null;
    }
    public Point2D nearest(Point2D p) {            // a nearest neighbor in the set to point p; null if the set is empty 
        return null;
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
