// javac -cp .:lib/algs4.jar kdtree/KdTree.java
// java -cp .:lib/algs4.jar kdtree.KdTree < kdtree/input10.txt

package kdtree;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Stack;
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
        private int size;       // size of subtree rooted at this node
        public Node(Point2D p, Double xmin, Double ymin, Double xmax, Double ymax, boolean split) {
            this.p = p;
            this.rect = new RectHV(xmin, ymin, xmax, ymax);
            this.split = split;
            this.size = 1;
            lb = null;
            rt = null;
        }
    }
    private Node root;

    public KdTree() {                              // construct an empty set of points 
        root = null;
    }
    public boolean isEmpty() {                     // is the set empty?
        return root == null;
    }
    public int size() {                        // number of points in the set
        if (isEmpty()) return 0;
        return root.size;
    }
    public void insert(Point2D p) {             // add the point to the set (if it is not already in the set)
        if (p == null) throw new IllegalArgumentException();
        root = insert(root, p);
    }
    private Node insert(Node node, Point2D p) {
        if (node == null) {
            node = new Node(p, 0.0, 0.0, 1.0, 1.0, VERTICAL);
        }
        if (node.p.compareTo(p) == 0) return node;
        if (node.split == VERTICAL) {
            if (p.x() < node.p.x()) {
                if (node.lb == null) {
                    node.lb = new Node(p, node.rect.xmin(), node.rect.ymin(), node.p.x(), node.rect.ymax(), HORIZONTAL);
                }
                else {
                    node.lb = insert(node.lb, p);
                }
            }
            else {
                if (node.rt == null) {
                    node.rt = new Node(p, node.p.x(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax(), HORIZONTAL);
                }
                else {
                    node.rt = insert(node.rt, p);
                }
            }
        }
        else {
            if (p.y() < node.p.y()) {
                if (node.lb == null) {
                    node.lb = new Node(p, node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.p.y(), VERTICAL);
                }
                else {
                    node.lb = insert(node.lb, p);
                }
            }
            else {
                if (node.rt == null) {
                    node.rt = new Node(p, node.rect.xmin(), node.p.y(), node.rect.xmax(), node.rect.ymax(), VERTICAL);
                }
                else {
                    node.rt = insert(node.rt, p);
                }
            }
        }
        node.size = 1;
        if (node.lb != null) node.size = node.size + node.lb.size;
        if (node.rt != null) node.size = node.size + node.rt.size;
        return node;
    }
    public boolean contains(Point2D p) {           // does the set contain point p? 
        if (p == null) throw new IllegalArgumentException();
        if (isEmpty()) return false;
        return contains(root, p);
    }
    private boolean contains(Node node, Point2D p) {
        if (node == null) return false;
        if (node.p.compareTo(p) == 0) return true;
        if (node.split == VERTICAL) {
            if (p.x() < node.p.x()) {
                return contains(node.lb, p);
            }
            else {
                return contains(node.rt, p);
            }
        }
        else {
            if (p.y() < node.p.y()) {
                return contains(node.lb, p);
            }
            else {
                return contains(node.rt, p);
            }
        }
    }
    public void draw() {                        // draw all points to standard draw 
        draw(root);
    }
    private void draw(Node node) {
        if (node == null) return;
        node.p.draw();
        draw(node.lb);
        draw(node.rt);
    }
    public Iterable<Point2D> range(RectHV rect) {            // all points that are inside the rectangle (or on the boundary) 
        if (rect == null) throw new IllegalArgumentException();
        Stack<Point2D> points = new Stack<>();
        range(points, root, rect);
        return points;
    }
    private void range(Stack<Point2D> points, Node node, RectHV rect) {
        if (node == null) return;
        if (!(node.rect.intersects(rect))) return;
        if (rect.contains(node.p)) points.push(node.p);
        range(points, node.lb, rect);
        range(points, node.rt, rect);
    }
    public Point2D nearest(Point2D p) {            // a nearest neighbor in the set to point p; null if the set is empty 
        if (p == null) throw new IllegalArgumentException();
        if (isEmpty()) return null;
        return nearest(root, p, root.p);
    }
    private Point2D nearest(Node node, Point2D p, Point2D closest) {
        if (node == null) return closest;
        if (p.distanceSquaredTo(closest) > p.distanceSquaredTo(node.p)) closest = node.p;
        if (node.split == VERTICAL) {
            if (p.x() < node.p.x()) {
                closest = nearest(node.lb, p, closest);
                if ((node.rt != null) && (p.distanceSquaredTo(closest) > node.rt.rect.distanceSquaredTo(p))) {
                    closest = nearest(node.rt, p, closest);
                }
            }
            else {
                closest = nearest(node.rt, p, closest);
                if ((node.lb != null) && (p.distanceSquaredTo(closest) > node.lb.rect.distanceSquaredTo(p))) {
                    closest = nearest(node.lb, p, closest);
                }
            }
        }
        else {
            if (p.y() < node.p.y()) {
                closest = nearest(node.lb, p, closest);
                if ((node.rt != null) && (p.distanceSquaredTo(closest) > node.rt.rect.distanceSquaredTo(p))) {
                    closest = nearest(node.rt, p, closest);
                }
            }
            else {
                closest = nearest(node.rt, p, closest);
                if ((node.lb != null) && (p.distanceSquaredTo(closest) > node.lb.rect.distanceSquaredTo(p))) {
                    closest = nearest(node.lb, p, closest);
                }
            }
        }
        return closest;
    }
    public static void main(String[] args) {                 // unit testing of the methods (optional)

        KdTree pts = new KdTree();
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
