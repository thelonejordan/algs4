// javac-algs4 burrowswheeler/MoveToFront.java
// java-algs4 burrowswheeler.MoveToFront - < burrowswheeler/abra.txt | java-algs4 edu.princeton.cs.algs4.HexDump 16
// java-algs4 burrowswheeler.MoveToFront - < burrowswheeler/abra.txt | java-algs4 burrowswheeler.MoveToFront +

package burrowswheeler;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int R = 256;

    private static char[] initSequence() {
        char[] sequence = new char[R];
        for (int i = 0; i < R; i++) sequence[i] = (char) i;
        return sequence;
    }

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        char[] seq = initSequence();
        while (!BinaryStdIn.isEmpty()) {
            char prev = seq[0];
            char c = BinaryStdIn.readChar();
            for (int i = 0; i < R; i++) {
                if (seq[i] == c) {
                    BinaryStdOut.write((char) i);
                    seq[0] = c;
                    seq[i] = prev;
                    break;
                }
                // update prev
                char tmp = seq[i];
                seq[i] = prev;
                prev = tmp;
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] seq = initSequence();
        while (!BinaryStdIn.isEmpty()) {
            char prev = seq[0];
            char c = BinaryStdIn.readChar();
            int idx = (int) c;
            for (int i = 0; i < R; i++) {
                if (i == idx) {
                    BinaryStdOut.write(seq[i]);
                    seq[0] = seq[i];
                    seq[i] = prev;
                    break;
                }
                // update prev
                char tmp = seq[i];
                seq[i] = prev;
                prev = tmp;
            }
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) MoveToFront.encode();
        if (args[0].equals("+")) MoveToFront.decode();
    }
}
