// javac-algs4 eightpuzzle/Solver.java
// java-algs4 eightpuzzle.Solver eightpuzzle/puzzle04.txt

package eightpuzzle;

import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {
    // Search Node
    private class Node {
        Board board;
        int moves;
        Node prev;
        int priorityCache;

        public Node(Board board, int moves, Node prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            this.priorityCache = -1;
        }
    }
    private Node first;
    private Node firstTwin;
    private Node answer;

    private boolean solved = false;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        if (initial == null) throw new IllegalArgumentException();

        Comparator<Node> BY_MANHATTON = new ByManhattanPriority();

        MinPQ<Node> pq = new MinPQ<>(BY_MANHATTON);
        MinPQ<Node> pqTwin = new MinPQ<>(BY_MANHATTON);

        first = new Node(initial, 0, null);
        firstTwin = new Node(initial.twin(), 0, null);

        pq.insert(first);
        pqTwin.insert(firstTwin);

        while (true) {
            if (!pq.isEmpty()) {
                // pop node with min priority
                Node minNode = pq.delMin();
                if (minNode.board.isGoal()) {
                    solved = true;
                    answer = minNode;
                    break;
                }
                // insert its neighbors
                for (Board b : minNode.board.neighbors()) {
                    if (minNode.prev != null) {
                        if (b.equals(minNode.prev.board)) continue; // skip previous node (Optimization 1)
                    }
                    Node n = new Node(b, minNode.moves + 1, minNode);
                    pq.insert(n);
                }
            }
            if (!pqTwin.isEmpty()) {
                Node minNode = pqTwin.delMin();
                if (minNode.board.isGoal()) {
                    break;
                }
                for (Board b : minNode.board.neighbors()) {
                    if (minNode.prev != null) {
                        if (b.equals(minNode.prev.board)) continue; // skip previous node (Optimization 1)
                    }
                    Node n = new Node(b, minNode.moves + 1, minNode);
                    pqTwin.insert(n);
                }
            }
        }
    }

    private static class ByManhattanPriority implements Comparator<Node> {
        public int compare(Node a, Node b) {
            // cache priorities (Optimization 2)
            if (a.priorityCache == -1)
                a.priorityCache = a.board.manhattan() + a.moves;
            if (b.priorityCache == -1)
                b.priorityCache = b.board.manhattan() + b.moves;
            // compare
            if (a.priorityCache > b.priorityCache) return 1;
            if (a.priorityCache == b.priorityCache) return 0;
            return -1;
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return solved;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) return -1;
        return answer.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) return null;
        Stack<Board> ret = new Stack<>();
        Node curr = answer;
        while (curr != null) {
            ret.push(curr.board);
            curr = curr.prev;
        }
        return ret;
    }

    // test client (see below) 
    public static void main(String[] args) {
        // create initial board from file
        if (args == null) throw new IllegalArgumentException();
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
