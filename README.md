# Welcome to Algorithms Parts I, II

*by [Robert Sedgewick](https://sedgewick.io/), [Kevin Wayne](https://www.cs.princeton.edu/people/profile/wayne)*

```text
        __        __   _
        \ \      / /__| | ___ ___  _ __ ___   ___
         \ \ /\ / / _ \ |/ __/ _ \| '_ ` _ \ / _ \
          \ V  V /  __/ | (_| (_) | | | | | |  __/
           \_/\_/ \___|_|\___\___/|_| |_| |_|\___|

                           _
                          | |_ ___
                          | __/ _ \
                          | || (_) |
                           \__\___/

     _    _                  _ _   _
    / \  | | __ _  ___  _ __(_) |_| |__  _ __ ___  ___
   / _ \ | |/ _` |/ _ \| '__| | __| '_ \| '_ ` _ \/ __|
  / ___ \| | (_| | (_) | |  | | |_| | | | | | | | \__ \
 /_/   \_\_|\__, |\___/|_|  |_|\__|_| |_|_| |_| |_|___/
            |___/
      ____            _           ___        ___ ___
     |  _ \ __ _ _ __| |_ ___    |_ _|      |_ _|_ _|
     | |_) / _` | '__| __/ __|    | |        | | | |
     |  __/ (_| | |  | |_\__ \    | |   _    | | | |
     |_|   \__,_|_|   \__|___/   |___| ( )  |___|___|
                                       |/
```

## Coursera

* [Algorithms Part I](https://www.coursera.org/learn/algorithms-part1)
* [Algorithms Part II](https://www.coursera.org/learn/algorithms-part2)

## Course Book

* [Algorithms 4th Edition](http://algs4.cs.princeton.edu/home/)

## Solutions (Part I)

* [Percolation](percolation)
* [Deques and Randomized Queues](queues)
* [Collinear Points](collinear)
* [8 Puzzle](eightpuzzle)
* [Kd-Trees](kdtrees)

## Solutions (Part II)

* [WordNet](wordnet)
* [Seam Carving](seamcarving)
* [Baseball Elimination](baseball)
* [Boggle](boggle)
* [Burrows-Wheeler](burrowswheeler)

## Basic Commands (Java)

Compile a program (say Program.java)

```sh
javac Program.java
```

```sh
# include jar lib
javac -cp .:example.jar Program.java
```

Execute a program

```sh
java Program
```

```sh
# include jar lib
java -cp .:example.jar Program
```

## Appendix

Install our Java programming environment (optional). Install our custom IntelliJ programming environment by following these step-by-step instructions for your operating system:
- [Mac OSX](https://lift.cs.princeton.edu/java/mac/)
- [Windows](https://lift.cs.princeton.edu/java/windows)
- [Linux](https://lift.cs.princeton.edu/java/linux)

After following these instructions, the commands `javac-algs4` and `java-algs4` will classpath in [`algs4.jar`](https://algs4.cs.princeton.edu/code/algs4.jar), which contains Java classes for I/O and all of the algorithms in the textbook. To access a class in `algs4.jar`, you need an import statement, such as the ones below:

```java
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
```

> Note that your code must be in the *default package*; if you use a package statement, the autograder will reject your submission.

For uninstalling, checkout the FAQ section for details.
Also, by default, the installer overwrite any pre-existing Bash configuration files, such as .bashrc. If you wish to preserve your version, see the FAQ.

Our autoinstaller customizes the command line in a few ways by copying these three configuration files: [`.bashrc`](https://lift.cs.princeton.edu/java/.bashrc), [`.bash_profile`](https://lift.cs.princeton.edu/java/.bash_profile), and [`.inputrc`](https://lift.cs.princeton.edu/java/.inputrc).
The autoinstaller creates a backup copy of your `.bashrc` file by appending a timestamp to the filename, e.g., `.bashrc.20210706-191748`.

### Jars

* https://algs4.cs.princeton.edu/code/algs4.jar
* https://introcs.cs.princeton.edu/code/stdlib.jar
* http://introcs.cs.princeton.edu/java/stdlib/stdlib-package.jar

### Course links

* https://algs4.cs.princeton.edu/code/
* https://algs4.cs.princeton.edu/code/algs4-data.zip
* https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/package-summary.html

### More links

* https://github.com/kevin-wayne/algs4
* https://openjdk.org/jeps/330
