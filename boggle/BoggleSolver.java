// javac -cp .:lib/algs4.jar boggle/BoggleSolver.java
// java -cp .:lib/algs4.jar boggle.BoggleSolver boggle/dictionary-algs4.txt boggle/board4x4.txt

package boggle;

import edu.princeton.cs.algs4.TrieSET;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;

public class BoggleSolver {

    private final TrieSET dict;
    private SET<String> found;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        dict = new TrieSET();
        for (int i = 0; i < dictionary.length; i++) {
            String word = dictionary[i];
            if (word.length() >= 3) {
                dict.add(word);
            }
        }
    }

    // private static void printMarked(boolean[][] marked, int m, int n) {
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (marked[i][j]) StdOut.print(" 1");
    //             else StdOut.print(" 0");
    //         }
    //         StdOut.println();
    //     }
    //     StdOut.println();
    // }

    // private static void printStack(Stack<Integer> stack, int m, int n) {
    //     StdOut.print(stack.size());
    //     for (int i : stack) {
    //         // StdOut.print(" " + i);
    //         int x = toX(i, n);
    //         int y = toY(i, n);
    //         StdOut.print("-(" +x+","+y+")");
    //     }
    //     StdOut.println();
    // }

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
        // StdOut.println("(" + x + ", " + y + ")");
        marked[x][y] = true;
        stack.push(xyTo1D(x, y, board.cols()));
        char[] arr = new char[stack.size()];
        int idx = 1;
        for (int v : stack) {
            arr[stack.size() - idx] = board.getLetter(toX(v, board.cols()), toY(v, board.cols()));
            idx++;
        }
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'Q') st.append("QU");
            else st.append(c);
        }
        String word = st.toString();
        if (dict.contains(word)) found.add(word);
        // printStack(stack, board.rows(), board.cols());
        // printMarked(marked, board.rows(), board.cols());
        if (x > 0) {
            int x2 = x - 1;
            if (!marked[x2][y]) dfs(board, x2, y, marked, stack); // top
            if (y > 0) {
                int y2 = y - 1;
                if (!marked[x2][y2]) dfs(board, x2, y2, marked, stack); // top left
            }
            if (y < board.cols() - 1) {
                int y2 = y + 1;
                if (!marked[x2][y2]) dfs(board, x2, y2, marked, stack); // top right
            }
        }
        if (y > 0) {
            int y2 = y - 1;
            if (!marked[x][y2]) dfs(board, x, y2, marked, stack); // left
        }
        if (y < board.cols() - 1) {
            int y2 = y + 1;
            if (!marked[x][y2]) dfs(board, x, y2, marked, stack); // right
        }
        if (x < board.rows() - 1) {
            int x2 = x + 1;
            if (!marked[x2][y]) dfs(board, x2, y, marked, stack); // bottom
            if (y > 0) {
                int y2 = y - 1;
                if (!marked[x2][y2]) dfs(board, x2, y2, marked, stack); // bottom left
            }
            if (y < board.cols() - 1) {
                int y2 = y + 1;
                if (!marked[x2][y2]) dfs(board, x2, y2, marked, stack); // bottom right
            }
        }
        stack.pop();
        marked[x][y] = false;
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
        if (dict.contains(word) && n > 2) {
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
