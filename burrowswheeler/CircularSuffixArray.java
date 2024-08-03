// javac-algs4 burrowswheeler/CircularSuffixArray.java
// java-algs4 burrowswheeler.CircularSuffixArray burrowswheeler/abra.txt

package burrowswheeler;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {

    private final int length;
    private final Integer[] index;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) throw new IllegalArgumentException();
        length = s.length();
        index = new Integer[length];
        char[] value = new char[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
            value[i] = s.charAt(i);
        }

        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer idx1, Integer idx2) {
                for (int i = 0; i < length; i++) {
                    char c1 = value[(i + idx1) % length];
                    char c2 = value[(i + idx2) % length];
                    if (c1 > c2) return 1;
                    if (c1 < c2) return -1;
                }
                return 0;
            }
        });
    }

    // length of s
    public int length() {
        return length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= length) throw new IllegalArgumentException();
        return index[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        In in = new In(args[0]);
        CircularSuffixArray csa = new CircularSuffixArray(in.readString());
        for (int i = 0; i < csa.length(); i++)
            StdOut.print(csa.index(i) + " ");
    }
}
