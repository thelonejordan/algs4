// javac -cp .:lib/algs4.jar eightpuzzle/Board.java
// java -cp .:lib/algs4.jar eightpuzzle.Board

package eightpuzzle;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Board {
    private final int[][] blocks;
    private final int num;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        this.num = tiles.length;
        blocks = new int[num][num];
        for (int i = 0; i < this.num; i++) {
            for (int j = 0; j < this.num; j++) {
                // make a copy
                this.blocks[i][j] = tiles[i][j];
            }
        }
    }
                                           
    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.num + "\n");
        for (int i = 0; i < this.num; i++) {
            for (int j = 0; j < this.num; j++) {
                s.append(String.format("%2d ", this.blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return this.num;
    }

    private int pos1D(int x, int y) {
        return this.num * x + y;
    }

    private int pos2DX(int pos) {
        return pos / this.num;
    }

    private int pos2DY(int pos) {
        return pos % this.num;
    }

    private int targetPosX(int val) {
        if (val == 0) return this.num - 1;
        return this.pos2DX(val - 1);
    }

    private int targetPosY(int val) {
        if (val == 0) return this.num - 1;
        return this.pos2DY(val - 1);
    }

    private int targetVal(int x, int y) {
        if (x == num - 1 && y == num - 1) return 0;
        return this.pos1D(x, y) + 1;
    }

    // number of tiles out of place
    public int hamming() {
        int ret = 0;
        for (int i = 0; i < this.num; i++) {
            for (int j = 0; j < this.num; j++) {
                int val = blocks[i][j];
                if (val == 0) continue;
                if (val != this.targetVal(i, j)) ret++;
            }
        }
        return ret;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int ret = 0;
        for (int x = 0; x < this.num; x++) {
            for (int y = 0; y < this.num; y++) {
                int val = blocks[x][y];
                if (val == 0) continue;
                int tx = this.targetPosX(val);
                int ty = this.targetPosY(val);

                if (tx > x) ret = ret + (tx - x);
                else ret = ret + (x - tx);

                if (ty > y) ret = ret + (ty - y);
                else ret = ret + (y - ty);
            }
        }
        return ret;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return this.hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null) return false;
        if (y == this) return true;
        if (y.getClass() == this.getClass()) {
            Board by = (Board) y;
            if (by.num == this.num) {
                for (int i = 0; i < this.num; i++) {
                    for (int j = 0; j < this.num; j++) {
                        if (by.blocks[i][j] != this.blocks[i][j]) return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private Board copy() {
        return new Board(this.blocks);
    }

    private Board swap(int x, int y, int offsetX, int offsetY) {
        Board swapped = this.copy();
        int tmp = swapped.blocks[x][y];
        swapped.blocks[x][y] = swapped.blocks[x + offsetX][y + offsetY];
        swapped.blocks[x + offsetX][y + offsetY] = tmp;
        return swapped;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> stack = new Stack<>();
        int zeroX = 0;
        int zeroY = 0;
        for (int x = 0; x < num; x++) {
            for (int y = 0; y < num; y++) {
                if (blocks[x][y] == 0) {
                    zeroX = x;
                    zeroY = y;
                    break;
                }
            }
        }
        if (zeroX - 1 >= 0) stack.push(this.swap(zeroX, zeroY, -1, 0)); // left
        if (zeroX + 1 < this.num) stack.push(this.swap(zeroX, zeroY, 1, 0)); // right
        if (zeroY - 1 >= 0) stack.push(this.swap(zeroX, zeroY, 0, -1)); // up
        if (zeroY + 1 < this.num) stack.push(this.swap(zeroX, zeroY, 0, 1)); // down
        return stack;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int total = this.num * this.num;
        int lastPos = 0;
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        for (int pos = 0; pos < total; pos++) {
            int x = this.pos2DX(pos);
            int y = this.pos2DY(pos);
            if (this.blocks[x][y] != 0) {
                lastPos = pos;
                x1 = x;
                y1 = y;
                break;
            }
        }
        for (int pos = lastPos + 1; pos < total; pos++) {
            int x = this.pos2DX(pos);
            int y = this.pos2DY(pos);
            if (this.blocks[x][y] != 0) {
                x2 = x;
                y2 = y;
                break;
            }
        }
        return this.swap(x1, y1, x2 - x1, y2 - y1);
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] data = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        Board b = new Board(data);

        for (int i = 0; i < b.num; i++) {
            for (int j = 0; j < b.num; j++) {
                int targetValue = b.targetVal(i, j);
                int x = b.targetPosX(targetValue);
                int y = b.targetPosY(targetValue);
                StdOut.println(targetValue + " -> (" + x + "," + y + ")");
            }
        }
        StdOut.println();
        StdOut.println("hamming = " + b.hamming());
        StdOut.println("manhattan = " + b.manhattan());
        StdOut.println("isGoal = " + b.isGoal());
        StdOut.println();
        StdOut.println("toString:\n" + b.toString());
        StdOut.println();
        StdOut.println("neighbors:");
        for (Board i : b.neighbors()) {
            StdOut.println(i.toString());
        }
        StdOut.println();
        StdOut.println("twin:");
        StdOut.println(b.twin().toString());
    }
}
