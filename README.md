# Welcome to Algorithms Parts I, II

```
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

### Installation

* https://formulae.brew.sh/formula/openjdk
* https://formulae.brew.sh/formula/checkstyle
* https://formulae.brew.sh/formula/spotbugs
* https://formulae.brew.sh/formula/pmd

### Course

* [Syllabus](https://www.coursera.org/learn/algorithms-part1/resources/CrmR4)
* [Assessment Guide]( https://www.coursera.org/learn/algorithms-part1/resources/R2mre)
* https://coursera.cs.princeton.edu/algs4/assignments/hello/specification.php
* https://coursera.cs.princeton.edu/algs4/assignments/hello/faq.php

* https://algs4.cs.princeton.edu/home/
* https://lift.cs.princeton.edu/java/mac/ (configurations files are here)
* https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/package-summary.html
* https://github.com/kevin-wayne/algs4
* https://algs4.cs.princeton.edu/code/algs4-data.zip
* https://algs4.cs.princeton.edu/code/


### Jars

* https://algs4.cs.princeton.edu/code/algs4.jar
* https://introcs.cs.princeton.edu/code/stdlib.jar
* http://introcs.cs.princeton.edu/java/stdlib/stdlib-package.jar

### Commands

Compile a program

```sh
javac HelloWorld.java
```

```sh
# include jar lib
# javac -cp $PWD:$PWD/example.jar HelloWorld.java
javac -cp .:example.jar HelloWorld.java
```

Run a program

```sh
java HelloWorld
```

```sh
# include jar lib
# javac -cp $PWD:$PWD/example.jar HelloWord
java -cp .:example.jar HelloWord
```

To run SpotBugs 4.2.3, type the following command in the terminal:

```sh
spotbugs HelloWorld.class
```

The argument must be a list of .class files. Here is a list of [bug descriptions](https://spotbugs.github.io/#bug-descriptions).

To run PMD 6.34.0, type the following command in the terminal:

```sh
pmd HelloWorld.java
```

The argument must be either a single .java file or a directory containing one or more .java files. Here is a list of [bug patterns](https://pmd.github.io/pmd-6.34.0/pmd_rules_java.html).

To run Checkstyle 10.12.1, type one of the following commands in the terminal, depending on whether you are COS 126, COS 226, or Coursera student:

```sh
checkstyle -cos126 HelloWorld.java
checkstyle -cos226 HelloWorld.java
checkstyle -coursera HelloWorld.java
```

```sh
checkstyle -c checkstyle-coursera.xml HelloWorld.java
```

The argument must be a list of .java files. Here is a list of [available checks](http://checkstyle.sourceforge.net/checks.html).


How do I specify EOF to signal that standard input is empty? (Relevant to `RandomWord`)

On Mac OS X and Linux, type `Enter` `Ctrl-D`. On Windows, type `Enter` `Ctrl-Z` `Enter`, even in Git Bash.


### More

* https://openjdk.org/jeps/330
