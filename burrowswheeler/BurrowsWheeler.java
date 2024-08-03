// javac-algs4 burrowswheeler/BurrowsWheeler.java
// java-algs4 burrowswheeler.BurrowsWheeler - < burrowswheeler/abra.txt | java-algs4 edu.princeton.cs.algs4.HexDump 16
// java-algs4 burrowswheeler.BurrowsWheeler - < burrowswheeler/abra.txt | java-algs4 burrowswheeler.BurrowsWheeler +

package burrowswheeler;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

    private static final int R = 256;

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output 
    public static void transform() {
        String input = BinaryStdIn.readString();
        int len = input.length();
        CircularSuffixArray csa = new CircularSuffixArray(input);
        for (int i = 0; i < input.length(); i++) {
            if (csa.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            int lastIdx = (csa.index(i) + len - 1) % len;
            BinaryStdOut.write(input.charAt(lastIdx));
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String lastCol = BinaryStdIn.readString();
        int len = lastCol.length();

        int[] sortedPos = new int[R + 1]; // starting position of each character in the sorted order (first column)
        for (int i = 0; i < len; i++) sortedPos[lastCol.charAt(i) + 1]++;
        for (int i = 0; i < R; i++) sortedPos[i + 1] += sortedPos[i];

        char[] firstCol = new char[len]; // sorted characters in the first column
        int[] next = new int[len]; // i being the (sorted) position of a suffix, next[i] gives the position of the next one
        for (int i = 0; i < len; i++) {
            int posi = sortedPos[lastCol.charAt(i)]++;
            firstCol[posi] = lastCol.charAt(i);
            next[posi] = i;
        }
        for (int i = 0; i < len; i++) {
            BinaryStdOut.write(firstCol[first]);
            first = next[first];
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) BurrowsWheeler.transform();
        if (args[0].equals("+")) BurrowsWheeler.inverseTransform();
    }
}
