// javac -cp .:lib/algs4.jar eightpuzzle/Solver.java
// java -cp .:lib/algs4.jar eightpuzzle.Solver eightpuzzle/puzzle04.txt

package eightpuzzle;

import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {
    // Search Node
    private class Node{
        Board board;
        int moves;
        Node prev;

        public Node(Board board, int moves, Node prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
        }
    }
    // Node Comparators
    private static final Comparator<Node> BY_HAMMING = new ByHammingPriority();
    private static final Comparator<Node> BY_MANHATTON = new ByManhattanPriority();

    private Node first;
    private Node firstTwin;
    private Node answer;

    // submission requires Manhattan Priority Function
    private MinPQ<Node> pq = new MinPQ<>(BY_MANHATTON);
    private MinPQ<Node> pqTwin = new MinPQ<>(BY_MANHATTON);

    private boolean solved = false;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        first = new Node(initial, 0, null);
        firstTwin = new Node(initial.twin(), 0, null);

        pq.insert(first);
        pqTwin.insert(firstTwin);

        while (true) {
            if (!pq.isEmpty()) {
                // pop min
                Node minNode = pq.delMin();
                if (minNode.board.isGoal()) {
                    solved = true;
                    answer = minNode;
                    break;
                }
                // insert its neighbors
                for (Board b : minNode.board.neighbors()) {
                    if (minNode.prev != null) {
                        if (b.equals(minNode.prev.board)) continue; // skip previous node
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
                        if (b.equals(minNode.prev.board)) continue; // skip previous node
                    }
                    Node n = new Node(b, minNode.moves + 1, minNode);
                    pqTwin.insert(n);
                }
            }
        }
    }

    private static class ByManhattanPriority implements Comparator<Node> {
        public int compare(Node a, Node b) {
            int priorityA = a.board.manhattan() + a.moves;
            int priorityB = b.board.manhattan() + b.moves;
            if (priorityA > priorityB) return 1;
            if (priorityA == priorityB) return 0;
            return -1;
        }
    }

    private static class ByHammingPriority implements Comparator<Node> {
        public int compare(Node a, Node b) {
            int priorityA = a.board.hamming() + a.moves;
            int priorityB = b.board.hamming() + b.moves;
            if (priorityA > priorityB) return 1;
            if (priorityA == priorityB) return 0;
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
        while(curr != null) {
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
