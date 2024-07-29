// javac -cp .:lib/algs4.jar boggle/BoggleSolver.java
// java -cp .:lib/algs4.jar boggle.BoggleSolver boggle/dictionary-algs4.txt boggle/board4x4.txt
// java -cp .:lib/algs4.jar boggle.BoggleSolver boggle/dictionary-algs4.txt boggle/board-q.txt

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
            x = get(prefixNode, prefix, prefix.length() - offset);
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

    private static class Dice {
        private char character;
        private boolean marked = false;
        private final Stack<Dice> adj = new Stack<>();
    }

    private static Dice[][] dices(BoggleBoard board) {
        Dice[][] dices = new Dice[board.rows()][board.cols()];
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                Dice dice = new Dice();
                dice.character = board.getLetter(i, j);
                dices[i][j] = dice;
            }
        }
        for (int x = 0; x < board.rows(); x++) {
            for (int y = 0; y < board.cols(); y++) {
                Dice dice = dices[x][y];
                if (x > 0) dice.adj.push(dices[x-1][y]); // top
                if (x > 0 && y > 0) dice.adj.push(dices[x-1][y-1]); // top left
                if (x > 0 && y < board.cols()-1) dice.adj.push(dices[x-1][y+1]); // top right
                if (y > 0) dice.adj.push(dices[x][y-1]); // left
                if (y < board.cols()-1) dice.adj.push(dices[x][y+1]); // right
                if (x < board.rows()-1) dice.adj.push(dices[x+1][y]); // bottom
                if (x < board.rows()-1 && y > 0) dice.adj.push(dices[x+1][y-1]); // bottom left
                if (x < board.rows()-1 && y < board.cols()-1) dice.adj.push(dices[x+1][y+1]); // bottom right
            }
        }
        return dices;
    }

    private void dfs(BoggleBoard board) {
        found = new SET<>();
        Dice[][] dices = dices(board);
        for (int x = 0; x < board.rows(); x++) {
            for (int y = 0; y < board.cols(); y++) {
                dfs(board.rows(), board.cols(), dices[x][y], new Stack<Character>());
            }
        }
    }

    private void dfs(int rows, int cols, Dice dice, Stack<Character> stack) {
        dice.marked = true;
        stack.push(dice.character);
        StringBuilder st = new StringBuilder(rows * cols * 2);
        for (char c : stack) {
            if (c == 'Q') st.append("UQ");
            else st.append(c);
        }
        String word = st.reverse().toString();
        if (hasPrefix(word)) {
            if (prefixNode.exists) found.add(word);
            for (Dice adjDice : dice.adj) {
                if (!adjDice.marked) dfs(rows, cols, adjDice, stack);
            }
        }
        prefixNode = null;
        dice.marked = false;
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
