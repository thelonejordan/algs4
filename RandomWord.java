/******************************************************************************
 * 
 * Source: https://github.com/camilamaia/jornada-big-tech/blob/main/coursera-algorithms-part-1/hello/RandomWord.java
 * Compilation: javac -cp lib/algs4.jar RandomWord.java
 * Execution:
 * java -cp .:lib/algs4.jar RandomWord
 * java -cp .:lib/algs4.jar RandomWord < downloads/animals.txt
 * 
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/** Represents a random word picker */
public class RandomWord {
   /**
    * Reads a sequence of words from standard input and prints one of those words uniformly at random
    *
    * @param args sequence of words
    */
    public static void main(String[] args) {

        int index = 0;
        String champion = "";

        while (!StdIn.isEmpty()) {
            index++;
            String word = StdIn.readString();
            boolean accept = StdRandom.bernoulli(1 / (double) index);
            if (accept) {
                champion = word;
            }
        }
        StdOut.println(champion);
    }
}

/*
 * 
 * NOTE: type your words, press enter followed by Ctrl-D.
 * 
 * Before reading each number, the program uses the method StdIn.isEmpty()
 * to check whether there are any more numbers in the input stream.
 * How do we signal that we have no more data to type? By convention,
 * we type a special sequence of characters known as the end-of-file sequence.
 * Unfortunately, the terminal applications that we typically encounter on
 * modern operating systems use different conventions for this critically
 * important sequence. In this book, we use Ctrl-D...
 * 
 * Computer Science Sedgewick
 * 
 * https://stackoverflow.com/questions/43401347/how-to-make-stdin-isempty-return-true
 * 
 */
