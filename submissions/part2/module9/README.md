See the Assessment Guide for information on how to interpret this report.

## ASSESSMENT SUMMARY

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     PASSED
PMD:          FAILED (1 warning)
Checkstyle:   FAILED (0 errors, 2 warnings)

Correctness:  0/13 tests passed
Memory:       0/3 tests passed
Timing:       1/9 tests passed

Aggregate score: 12.22%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
```

## ASSESSMENT DETAILS

```
The following files were submitted:
----------------------------------
5.4K Jul 28 20:43 BoggleSolver.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac BoggleSolver.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
BoggleSolver:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------
BoggleSolver.java:13: The private instance (or static) variable 'dict' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
PMD ends with 1 warning.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] BoggleSolver.java:62:18: The method 'DFS' must start with a lowercase letter and use camelCase. [MethodName]
[WARN] BoggleSolver.java:75:18: The method 'DFS' must start with a lowercase letter and use camelCase. [MethodName]
Checkstyle ends with 0 errors and 2 warnings.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of BoggleSolver
*-----------------------------------------------------------
Tests 1-9 create one BoggleSolver object corresponding to the specified
dictionary and call getAllValidWords() with several different boards
as arguments.

Running 13 total tests.

Test 1: check getAllValidWords() on two fixed 4-by-4 boards given in assignment
  * dictionary = dictionary-algs4.txt; board = board4x4.txt
  * dictionary = dictionary-algs4.txt; board = board-q.txt
    - number of entries in student   solution: 21
    - number of entries in reference solution: 29
    - 8 missing entries in student solution, including:
      'REQUIRE'

         4 4
         S  N  R  T  
         O  I  E  L  
         E  Qu T  T  
         R  S  A  T

==> FAILED

Test 2: check getAllValidWords() on fixed 4-by-4 boards
  * dictionary = dictionary-yawl.txt; board = board4x4.txt
  * dictionary = dictionary-yawl.txt; board = board-points1.txt
  * dictionary = dictionary-yawl.txt; board = board-points2.txt
  * dictionary = dictionary-yawl.txt; board = board-points3.txt
  * dictionary = dictionary-yawl.txt; board = board-points4.txt
  * dictionary = dictionary-yawl.txt; board = board-points5.txt
==> passed

Test 3: check getAllValidWords() on more fixed 4-by-4 boards
  * dictionary = dictionary-yawl.txt; board = board-points100.txt
  * dictionary = dictionary-yawl.txt; board = board-points200.txt
  * dictionary = dictionary-yawl.txt; board = board-points300.txt
  * dictionary = dictionary-yawl.txt; board = board-points400.txt
  * dictionary = dictionary-yawl.txt; board = board-points500.txt
  * dictionary = dictionary-yawl.txt; board = board-points750.txt
  * dictionary = dictionary-yawl.txt; board = board-points1000.txt
  * dictionary = dictionary-yawl.txt; board = board-points1250.txt
  * dictionary = dictionary-yawl.txt; board = board-points1500.txt
  * dictionary = dictionary-yawl.txt; board = board-points2000.txt
==> passed

Test 4: check getAllValidWords() on random Hasbro boards
  * dictionary = dictionary-yawl.txt; board = 10 random Hasbro boards
  * dictionary = dictionary-yawl.txt; board = 50 random Hasbro boards


WARNING: the time limit of 100 seconds was exceeded, so not all tests could be completed.
         This usually indicates a performance bug or an infinite loop.




Total: 0/13 tests passed:<font color = #990000><b> Could not complete tests, which results in a reported score of 0.</b></font>
================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of BoggleSolver
*-----------------------------------------------------------
Running 3 total tests.

Test 1: memory with dictionary-algs4.txt (must be <= 2x reference solution)
  * memory of dictionary[]           = 450264 bytes
  * memory of student   BoggleSolver = 36245968 bytes
  * memory of reference BoggleSolver = 5091200 bytes
  * student / reference              = 7.12
==> FAILED

Test 2: memory with dictionary-shakespeare.txt (must be <= 2x reference solution)
  * memory of dictionary[]           = 1754288 bytes
  * memory of student   BoggleSolver = 121674264 bytes
  * memory of reference BoggleSolver = 17307792 bytes
  * student / reference              = 7.03
==> FAILED

Test 3: memory with dictionary-yawl.txt (must be <= 2x reference solution)
  * memory of dictionary[]           = 20260488 bytes
  * memory of student   BoggleSolver = 1229787664 bytes
  * memory of reference BoggleSolver = 177012856 bytes
  * student / reference              = 6.95
==> FAILED


Total: 0/3 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing BoggleSolver
*-----------------------------------------------------------
All timing tests are for random 4-by-4 boards (using the Hasbro dice).
The dictionary is specified with each test.

Running 9 total tests.

Test 1: timing constructor (must be <= 5x reference solution)
 *  dictionary-algs4.txt
    - student   solution time (in seconds): 0.01
    - reference solution time (in seconds): 0.00
    - ratio:                                3.29

==> passed

 *  dictionary-enable2k.txt
    - student   solution time (in seconds): 0.12
    - reference solution time (in seconds): 0.02
    - ratio:                                5.75

==> FAILED

 *  dictionary-yawl.txt
    - student   solution time (in seconds): 0.17
    - reference solution time (in seconds): 0.03
    - ratio:                                6.52

==> FAILED

 *  dictionary-zingarelli2005.txt

    java.lang.OutOfMemoryError: Java heap space

    edu.princeton.cs.algs4.TrieSET$Node.<init>(TrieSET.java:47)
    edu.princeton.cs.algs4.TrieSET$Node.<init>(TrieSET.java:46)
    edu.princeton.cs.algs4.TrieSET.add(TrieSET.java:89)
    edu.princeton.cs.algs4.TrieSET.add(TrieSET.java:96)
    edu.princeton.cs.algs4.TrieSET.add(TrieSET.java:96)
    ...
    BoggleSolver.<init>(BoggleSolver.java:23)
    TimeBoggleSolver.timeForConstructor(TimeBoggleSolver.java:29)
    TimeBoggleSolver.testConstructor(TimeBoggleSolver.java:92)
    TimeBoggleSolver.test1(TimeBoggleSolver.java:117)
    TimeBoggleSolver.main(TimeBoggleSolver.java:180)

==> FAILED

Test 2: timing getAllValidWords() for 5.0 seconds using dictionary-yawl.txt
        (must be <= 2x reference solution)
    - reference solution calls per second: 7381.68
    - student   solution calls per second: 0.64
    - reference / student ratio:           11467.04

=> FAILED    student <= 10000x reference
=> FAILED    student <=    25x reference
=> FAILED    student <=    10x reference
=> FAILED    student <=     5x reference
=> FAILED    student <=     2x reference


Total: 1/9 tests passed!


================================================================
```
