// javac -cp .:lib/algs4.jar boggle/BoggleSolver.java
// java -cp .:lib/algs4.jar boggle.BoggleSolver boggle/dictionary-algs4.txt boggle/board4x4.txt

package boggle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;

public class BoggleSolver {

    private static final int R = 26;
    private Node root = new Node();
    private SET<String> found;
    private Node prefixNode = null;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            String word = dictionary[i];
            if (word.length() >= 3) {
                add(word);
            }
        }
    }

    private static class Node {
        private boolean exists = false;
        private Node[] next = new Node[R];
    }

    private void add(String key) {
        root = put(root, key, 0);
    }

    private static Node put(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.exists = true;
            return x;
        }
        char c = key.charAt(d);
        x.next[c - 'A'] = put(x.next[c - 'A'], key, d + 1);
        return x;
    }

    private boolean contains(String key) {
        Node x = get(root, key, 0);
        return x != null && x.exists;
    }

    private boolean hasPrefix(String prefix) {
        Node x;
        if (prefixNode == null) x = get(root, prefix, 0);
        else {
            int offset = 1;
            if (prefix.endsWith("QU")) offset = 2;
            x = get(prefixNode, prefix, prefix.length()-offset);
        }
        prefixNode = x;
        return x != null;
    }

    private static Node get(Node x, String key, int d) {
        Node node = x;
        while (d < key.length() && node != null) {
            char c = key.charAt(d);
            node = node.next[c - 'A'];
            d++;
        }
        return node;
    }

    private static int xyTo1D(int x, int y, int n) {
        return x * n + y;
    }

    private static int toX(int v, int n) {
        return  v / n;
    }

    private static int toY(int v, int n) {
        return  v % n;
    }

    private void dfs(BoggleBoard board) {
        int m = board.rows();
        int n = board.cols();
        found = new SET<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                boolean[][] marked = new boolean[m][n];
                Stack<Integer> stack = new Stack<>();
                dfs(board, x, y, marked, stack);
            }
        }
    }

    private void dfs(BoggleBoard board, int x, int y, boolean[][] marked, Stack<Integer> stack) {
        marked[x][y] = true;
        stack.push(xyTo1D(x, y, board.cols()));
        StringBuilder st = new StringBuilder();
        for (int v : stack) {
            char c = board.getLetter(toX(v, board.cols()), toY(v, board.cols()));
            if (c == 'Q') st.append("UQ");
            else st.append(c);
        }
        String word = st.reverse().toString();
        if (hasPrefix(word)) {
            if (prefixNode.exists) found.add(word);
            if (x > 0 && !marked[x-1][y]) dfs(board, x-1, y, marked, stack); // top
            if (x > 0 && y > 0 && !marked[x-1][y-1]) dfs(board, x-1, y-1, marked, stack); // top left
            if (x > 0 && y < board.cols()-1 && !marked[x-1][y+1]) dfs(board, x-1, y+1, marked, stack); // top right
            if (y > 0 && !marked[x][y-1]) dfs(board, x, y-1, marked, stack); // left
            if (y < board.cols()-1 && !marked[x][y+1]) dfs(board, x, y+1, marked, stack); // right
            if (x < board.rows()-1 && !marked[x+1][y]) dfs(board, x+1, y, marked, stack); // bottom
            if (x < board.rows()-1 && y > 0 && !marked[x+1][y-1]) dfs(board, x+1, y-1, marked, stack); // bottom left
            if (x < board.rows()-1 && y < board.cols()-1 && !marked[x+1][y+1]) dfs(board, x+1, y+1, marked, stack); // bottom right
        }
        prefixNode = null;
        marked[x][y] = false;
        stack.pop();
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        if (board == null) throw new IllegalArgumentException();
        dfs(board);
        return found;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        int n = word.length();
        if (contains(word) && n > 2) {
            if (n <= 4) return 1;
            if (n == 5) return 2;
            if (n == 6) return 3;
            if (n == 7) return 5;
            return 11;
        }
        return 0;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        StdOut.println(board.toString());
        StdOut.println();
        int score = 0;
        for (String word : solver.getAllValidWords(board)) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }
}
