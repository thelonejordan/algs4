// javac -cp .:lib/algs4.jar kdtree/KdTree.java
// java -cp .:lib/algs4.jar kdtree.KdTree < kdtree/input10.txt

package kdtree;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;


public class KdTree {
    private static final boolean HORIZONTAL = true; // split by horizontal line
    private static final boolean VERTICAL = false; // split by vertical line
    private static class Node {
        private Point2D p;      // the point
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree
        private boolean split;  // type of split
        public Node(Point2D p, Double xmin, Double ymin, Double xmax, Double ymax, boolean split) {
            this.p = p;
            this.rect = new RectHV(xmin, ymin, xmax, ymax);
            this.split = split;
            lb = null;
            rt = null;
        }
     }
    private static int size;
    private Node root;

    public KdTree() {                              // construct an empty set of points 
        root = null;
        size = 0;
    }
    private static void validate(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
    }
    public boolean isEmpty() {                     // is the set empty?
        return size == 0;
    }
    public int size() {                        // number of points in the set
        return size;
    }
    public void insert(Point2D p) {             // add the point to the set (if it is not already in the set)
        validate(p);
        // implement insertion
        if (isEmpty()) {
            root = new Node(p, 0.0, 0.0, 1.0, 1.0, VERTICAL);
        }
        else {
            root = insert(root, p);
        }
    }
    private static Node insert(Node node, Point2D p) {
        if (node.split == VERTICAL) {
            if (node.p.x() < p.x()) {
                if (node.rt == null) {
                    size++;
                    node.rt = new Node(p, node.p.x(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax(), HORIZONTAL);
                }
                else {
                    node.rt = insert(node.rt, p);
                }
            }
            else {
                if (node.lb == null) {
                    size++;
                    node.lb = new Node(p, node.rect.xmin(), node.rect.ymin(), node.p.x(), node.rect.ymax(), HORIZONTAL);
                }
                else {
                    node.lb = insert(node.lb, p);
                }
            }
        }  
        else {
            if (node.p.y() < p.y()) {
                if (node.rt == null) {
                    size++;
                    node.rt = new Node(p, node.rect.xmin(), node.p.y(), node.rect.xmax(), node.rect.ymax(), VERTICAL);
                }
                else {
                    node.rt = insert(node.rt, p);
                }
            }
            else {
                if (node.lb == null) {
                    size++;
                    node.lb = new Node(p, node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.p.y(), VERTICAL);
                }
                else {
                    node.lb = insert(node.lb, p);
                }
            }
        }
        return node;
    }
    public boolean contains(Point2D p) {           // does the set contain point p? 
        validate(p);
        if (isEmpty()) {
            return false;
        }
        return contains(root, p);
    }
    private static boolean contains(Node node, Point2D p) {
        if (node == null) return false;
        int cmp = node.p.compareTo(p);
        if (cmp == 1) return contains(node.rt, p);
        if (cmp == -1) return contains(node.lb, p);
        return true;
    }
    public void draw() {                        // draw all points to standard draw 
        for (Point2D p : range(new RectHV(0.0, 0.0, 1.0, 1.0))) {
            p.draw();
        }
    }
    public Iterable<Point2D> range(RectHV rect) {            // all points that are inside the rectangle (or on the boundary) 
        return null;
    }
    public Point2D nearest(Point2D p) {            // a nearest neighbor in the set to point p; null if the set is empty 
        return null;
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
        Point2D np = pts.nearest(new Point2D(0, 0));
        StdOut.println("nearest = " + np.toString());
        RectHV rect = new RectHV(0.5, 0.5, 1, 1);
        StdDraw.setPenColor(StdDraw.RED);
        rect.draw();
        for (Point2D p : pts.range(rect)) {
            StdOut.println("within range = " + p.toString());
        }
        StdDraw.show();
    }
}
