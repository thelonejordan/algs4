// javac -cp .:lib/algs4.jar unionfind/Sample.java

package unionfind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Sample {
    public static void main(String[] args) {
        WeightedQuickUnionUF exp = new WeightedQuickUnionUF(10);
        StdOut.println(exp.find(10));
    }
}
