See the Assessment Guide for information on how to interpret this report.

## ASSESSMENT SUMMARY

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     FAILED (1 warning)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 4 warnings)

Correctness:  8/41 tests passed
Memory:       1/1 tests passed
Timing:       37/41 tests passed

Aggregate score: 49.76%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
```

## ASSESSMENT DETAILS

```
The following files were submitted:
----------------------------------
1.6K Apr 19 15:51 BruteCollinearPoints.java
1.3K Apr 19 15:51 FastCollinearPoints.java
4.6K Apr 19 15:51 Point.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Point.java
*-----------------------------------------------------------

% javac LineSegment.java
*-----------------------------------------------------------

% javac BruteCollinearPoints.java
*-----------------------------------------------------------

% javac FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Point:

BruteCollinearPoints:

FastCollinearPoints:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------
M C SUA_SUSPICIOUS_UNINITIALIZED_ARRAY SUA: Method FastCollinearPoints.segments() returns an array that appears not to be initialized  At FastCollinearPoints.java:[line 19]
SpotBugs ends with 1 warning.


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] BruteCollinearPoints.java:3:8: Unused import statement for 'edu.princeton.cs.algs4.In'. [UnusedImports]
[WARN] BruteCollinearPoints.java:4:8: Unused import statement for 'edu.princeton.cs.algs4.StdOut'. [UnusedImports]
[WARN] BruteCollinearPoints.java:5:8: Unused import statement for 'edu.princeton.cs.algs4.StdDraw'. [UnusedImports]
[WARN] BruteCollinearPoints.java:19:30: Do not use the letter 'l' as a local variable name. It is hard to distinguish from the number '1'. [LocalVariableName]
Checkstyle ends with 0 errors and 4 warnings.

% custom checkstyle checks for Point.java
*-----------------------------------------------------------

% custom checkstyle checks for BruteCollinearPoints.java
*-----------------------------------------------------------

% custom checkstyle checks for FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Point
*-----------------------------------------------------------
Running 3 total tests.

Test 1: p.slopeTo(q)
  * positive infinite slope, where p and q have coordinates in [0, 500)
  * positive infinite slope, where p and q have coordinates in [0, 32768)
  * negative infinite slope, where p and q have coordinates in [0, 500)
  * negative infinite slope, where p and q have coordinates in [0, 32768)
  * positive zero     slope, where p and q have coordinates in [0, 500)
  * positive zero     slope, where p and q have coordinates in [0, 32768)
  * symmetric for random points p and q with coordinates in [0, 500)
  * symmetric for random points p and q with coordinates in [0, 32768)
  * transitive for random points p, q, and r with coordinates in [0, 500)
  * transitive for random points p, q, and r with coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 500)
  * slopeTo(), where p and q have coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 10)
  * throw a java.lang.NullPointerException if argument is null
==> passed

Test 2: p.compareTo(q)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p and q have coordinates in [0, 500)
  * antisymmetric, where p and q have coordinates in [0, 32768)
  * transitive, where p, q, and r have coordinates in [0, 500)
  * transitive, where p, q, and r have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 500)
  * sign of compareTo(), where p and q have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 10)
  * throw java.lang.NullPointerException exception if argument is null
==> passed

Test 3: p.slopeOrder().compare(q, r)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p, q, and r have coordinates in [0, 500)
  * antisymmetric, where p, q, and r have coordinates in [0, 32768)
  * transitive, where p, q, r, and s have coordinates in [0, 500)
  * transitive, where p, q, r, and s have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 500)
  * sign of compare(), where p, q, and r have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 10)
  * throw java.lang.NullPointerException if either argument is null
==> passed


Total: 3/3 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Point and LineSegment)
********************************************************************************

Testing correctness of BruteCollinearPoints
*-----------------------------------------------------------
Running 17 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - no 5 (or more) points are collinear
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
    - segment 1 returned by student segments() is null
    - number of non-null entries in student   segments() = 1
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 2

  * filename = equidistant.txt
    - segment 2 returned by student segments() is null
    - number of non-null entries in student   segments() = 2
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 4

  * filename = input40.txt
    - segment 2 returned by student segments() is null
    - number of non-null entries in student   segments() = 2
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 4

  * filename = input48.txt
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 3
    - number of          entries in reference segments() = 6

==> FAILED

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 5

  * filename = horizontal25.txt
    - segment 13 returned by student segments() is null
    - number of non-null entries in student   segments() = 13
    - number of     null entries in student   segments() = 12
    - number of          entries in reference segments() = 25

==> FAILED

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 250
     20
     11315 19314
     15508 13525
     12934 19568
     15246 18847
      9839 19568
      8443 18717
      4435 18717
      9497 13525
     13369 18847
      1284 13525
      1276 18717
      1326 19314
      8024 19568
      1402 18717
     17735 13525
      4569 19314
     14144 19314
      3765 19568
     10686 18847
     18501 18847

  * 10 random horizontal line segments
    - segment 5 returned by student segments() is null
    - number of non-null entries in student   segments() = 5
    - number of     null entries in student   segments() = 5
    - number of          entries in reference segments() = 10

    - failed on trial 1 of 50

  * 15 random horizontal line segments
    - segment 8 returned by student segments() is null
    - number of non-null entries in student   segments() = 8
    - number of     null entries in student   segments() = 7
    - number of          entries in reference segments() = 15

    - failed on trial 1 of 5

==> FAILED

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 5

  * filename = vertical25.txt
    - segment 13 returned by student segments() is null
    - number of non-null entries in student   segments() = 13
    - number of     null entries in student   segments() = 12
    - number of          entries in reference segments() = 25

==> FAILED

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 250
     20
     17232 11474
      4485  2519
     15576 16269
     17232  6269
     15576 16162
     13528 19035
     15576 13433
     13528  1779
     13528 19532
     19900  3238
     19900  1505
      4485 12691
     19900 18260
      4485 13656
     17232  7910
     19900 17477
      4485 10285
     17232 20456
     15576  4382
     13528 10561

  * 10 random vertical line segments
    - segment 5 returned by student segments() is null
    - number of non-null entries in student   segments() = 5
    - number of     null entries in student   segments() = 5
    - number of          entries in reference segments() = 10

    - failed on trial 1 of 50

  * 15 random vertical line segments
    - segment 8 returned by student segments() is null
    - number of non-null entries in student   segments() = 8
    - number of     null entries in student   segments() = 7
    - number of          entries in reference segments() = 15

    - failed on trial 1 of 5

==> FAILED

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 6: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
    - segment 2 returned by student segments() is null
    - number of non-null entries in student   segments() = 2
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 4

  * filename = input40.txt
    - segment 2 returned by student segments() is null
    - number of non-null entries in student   segments() = 2
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 4

  * filename = input48.txt
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 3
    - number of          entries in reference segments() = 6

==> FAILED

Test 7: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
    - segment 2 returned by student segments() is null
    - number of non-null entries in student   segments() = 2
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 4

  * filename = input40.txt
    - segment 2 returned by student segments() is null
    - number of non-null entries in student   segments() = 2
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 4

  * filename = input48.txt
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 3
    - number of          entries in reference segments() = 6


It is bad style to write code that depends on the particular format of
the output from the toString() method, especially if your reason for
doing so is to circumvent the public API (which intentionally does not
provide access to the x- and y-coordinates).

==> FAILED

Test 8: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 250
     20
      7528  5625
     11373 15142
      6909  1054
     12058 10155
      5122  7014
      7403  2082
      2224  5994
     10071 11033
      1258  5654
      6088  7354
      8955  7511
      9462  2528
      9908  3506
      8873  5102
     14368 13286
      9016  1550
      7844  2988
     15078 13175
     13283 14162
      5263  3360

  * 10 random line segments
    - segment 5 returned by student segments() is null
    - number of non-null entries in student   segments() = 5
    - number of     null entries in student   segments() = 5
    - number of          entries in reference segments() = 10

    - failed on trial 1 of 100

  * 15 random line segments
    - segment 8 returned by student segments() is null
    - number of non-null entries in student   segments() = 8
    - number of     null entries in student   segments() = 7
    - number of          entries in reference segments() = 15

    - failed on trial 1 of 50

==> FAILED

Test 9: random line segments
  *  1 random line segment
  *  5 random line segments
    - segment 3 returned by student segments() is null
    - number of non-null entries in student   segments() = 3
    - number of     null entries in student   segments() = 2
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 250
     20
      1075   832
     12625 10473
      3116    27
      6888  5713
      5557  5962
     12102 11864
      4879  3123
     10392 11504
      4858  3074
      7217  7862
     12140 11872
      9939  9011
     10620 11552
      6560  6075
     13336 10860
     10255  9183
      5698  4166
      5838  4348
      3399  3492
      3198   171

  * 10 random line segments
    - segment 5 returned by student segments() is null
    - number of non-null entries in student   segments() = 5
    - number of     null entries in student   segments() = 5
    - number of          entries in reference segments() = 10

    - failed on trial 1 of 100

  * 15 random line segments
    - segment 8 returned by student segments() is null
    - number of non-null entries in student   segments() = 8
    - number of     null entries in student   segments() = 7
    - number of          entries in reference segments() = 15

    - failed on trial 1 of 50

==> FAILED

Test 10: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
    - failed after 22 operations involving BruteCollinearPoints
    - first and last call to segments() returned different arrays

    - failed on trial 1 of 100

  * equidistant.txt
    - failed after 4 operations involving BruteCollinearPoints
    - first and last call to segments() returned different arrays

    - sequence of operations was:
          BruteCollinearPoints collinear = new BruteCollinearPoints(points);
          mutate points[] array that was passed to constructor
          collinear.segments()
          collinear.segments()

    - failed on trial 1 of 100

==> FAILED

Test 11: check that data type does not mutate the constructor argument
  * input8.txt
    - data type mutated the points[] array
    - data type should have no side effects unless documented in API

  * equidistant.txt
    - data type mutated the points[] array
    - data type should have no side effects unless documented in API

==> FAILED

Test 12: numberOfSegments() is consistent with segments()
  * filename = input8.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 1
    - length of array returned by segments() = 2

  * filename = equidistant.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 2
    - length of array returned by segments() = 4

  * filename = input40.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 2
    - length of array returned by segments() = 4

  * filename = input48.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 3
    - length of array returned by segments() = 6

  * filename = horizontal5.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 2
    - length of array returned by segments() = 5

  * filename = vertical5.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 2
    - length of array returned by segments() = 5

  * filename = random23.txt
==> FAILED

Test 13: throws an exception if either the constructor argument is null
         or any entry in array is null
  * argument is null
  * Point[] of length 10, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     10
     11579 20998
     11821  3128
     17861  1799
     15342 28387
     30507 16720
     null
      7418 22396
     14088 18204
      1541 21705
     25918  5123

  * Point[] of length 10, number of null entries = 10
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     10
     null
     null
     null
     null
     null
     null
     null
     null
     null
     null

  * Point[] of length 4, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     4
       726  4467
     14626  1848
     null
     13787 24314

  * Point[] of length 3, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     3
     null
     27425 16292
      1038 26956

  * Point[] of length 2, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     2
     30919 28269
     null

  * Point[] of length 1, number of null entries = 1
    - constructor fails to throw an exception
     1
     null

==> FAILED

Test 14: check that the constructor throws an exception if duplicate points
  * 50 points
    - failed on trial 1 of 5
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

  * 25 points
    - failed on trial 1 of 10
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

  * 5 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     5
     16656   144
      3149  3945
      3149  3945
     11754 21906
     18354  1765

  * 4 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     4
     19730 15581
     30052 30535
     11768 14441
     30052 30535

  * 3 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     3
      4327 24451
     13710 15578
     13710 15578

  * 2 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     2
      2034 17023
      2034 17023

==> FAILED


Total: 3/17 tests passed!


================================================================
Testing correctness of FastCollinearPoints
*-----------------------------------------------------------
Running 21 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 2

  * filename = equidistant.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 4

  * filename = input40.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 4

  * filename = input48.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 6

  * filename = input299.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 6

==> FAILED

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

  * filename = horizontal25.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 25

  * filename = horizontal50.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 50

  * filename = horizontal75.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 75

  * filename = horizontal100.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 100

==> FAILED

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 1

    - failed on trial 1 of 500
     4
      5286  5401
     18887  5401
     18268  5401
     13617  5401

  *  5 random horizontal line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 250
     20
     15213 18165
     11862  6423
      7117 18165
     14366  6423
      8795 11187
      4451 11187
      6890  6423
      6811 18165
     11687 11187
      9223  6423
     13907 11827
     15822  6124
     14308 11827
     17833 11827
     14849  6124
      6784  6124
      3722 11827
     17040  6124
     10304 18165
     18475 11187

  * 10 random horizontal line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 10

    - failed on trial 1 of 50

  * 15 random horizontal line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 15

    - failed on trial 1 of 5

==> FAILED

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

  * filename = vertical25.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 25

  * filename = vertical50.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 50

  * filename = vertical75.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 75

  * filename = vertical100.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 100

==> FAILED

Test 3b: random vertical line segments
  *  1 random vertical line segment
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 1

    - failed on trial 1 of 500
     4
     17078 10079
     17078  3464
     17078 15495
     17078  1037

  *  5 random vertical line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 250
     20
      5925  8264
      9303  1114
      9303 16612
      1407 16362
     15943 10835
     17195  7541
     15943  8652
      5925 13958
     17195  5326
     17195 15740
      9303  7008
      1407  7590
      9303 12015
      5925 16821
     15943 13044
     17195 17830
      1407 20459
      5925 18943
     15943  3690
      1407  5076

  * 10 random vertical line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 10

    - failed on trial 1 of 50

  * 15 random vertical line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 15

    - failed on trial 1 of 5

==> FAILED

Test 4a: points from a file with no line segments
  * filename = random23.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

  * filename = random38.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

  * filename = random91.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

  * filename = random152.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

==> FAILED

Test 4b: random points with no line segments
  *  5 random points
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

    - failed on trial 1 of 500
     5
      5068 16002
     13152 23121
     21897 20015
      9642  8967
     24136  4043

  * 10 random points
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

    - failed on trial 1 of 250
     10
     32146 10601
      7063 20940
      3267 31765
     28586 15221
     21203  3387
     27266  7418
     30339 17521
     18307 21409
     20493 17343
     12214 30520

  * 20 random points
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

    - failed on trial 1 of 100
     20
     12630  5294
     28906 18547
     22236 28719
      4823  8979
     26133 21150
      1710 12241
     23931 23054
      6236  1417
     13507 26741
     22032 10680
     32264 13344
     22811 24683
      3052 31110
     27438 11568
       798   248
      3978  3528
     27497 23915
     31088 27075
      5584 12729
     28931 23810

  * 50 random points
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

    - failed on trial 1 of 10

==> FAILED

Test 5a: points from a file with 5 or more on some line segments
  * filename = input9.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 1

  * filename = input10.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 2

  * filename = input20.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

  * filename = input50.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 7

  * filename = input80.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 31

  * filename = input300.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 6

  * filename = inarow.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

==> FAILED

Test 5b: points from a file with 5 or more on some line segments
  * filename = kw1260.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 288

  * filename = rs1423.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 443

==> FAILED

Test 6: points from a file with fewer than 4 points
  * filename = input1.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

  * filename = input2.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

  * filename = input3.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

==> FAILED

Test 7: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 4

  * filename = input40.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 4

  * filename = input48.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 6

  * filename = input299.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 6

==> FAILED

Test 8: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 4

  * filename = input40.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 4

  * filename = input48.txt
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 6


It is bad style to write code that depends on the particular format of
the output from the toString() method, especially if your reason for
doing so is to circumvent the public API (which intentionally does not
provide access to the x- and y-coordinates).

==> FAILED

Test 9: random line segments, none vertical or horizontal
  *  1 random line segment
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 1

    - failed on trial 1 of 500
     4
      5466  6527
     17382  6695
      2487  6485
       501  6457

  *  5 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 500
     20
      5209  1700
      9066 13483
      8305  7540
      3261  4711
     11199  8689
      2668  6151
      3666  5323
     10795  8372
     14113  1205
     16451 12810
      7563  5836
     11194  7327
      4698  6431
       426   427
      8352  6935
     14603  7323
     14428  5138
     14497 19220
     14498  6012
     13336 17030

  * 25 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 25

    - failed on trial 1 of 100

  * 50 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 50

    - failed on trial 1 of 15

  * 100 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 100

    - failed on trial 1 of 2

==> FAILED

Test 10: random line segments
  *  1 random line segment
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 1

    - failed on trial 1 of 500
     4
      7013  6592
      6727  4986
      6311  2650
      6298  2577

  *  5 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 5

    - failed on trial 1 of 500
     20
      8373  7082
     12281 12718
     11719  5244
     11719  4048
      8556 10794
      8373  6690
      8373  3610
     11545 11742
     11719  4968
     10114 13682
     13154 11647
     10032 13530
     13477 14304
     10237 13910
      8373  6914
     13154  6547
     12097 12474
     13154  7897
     13154  8497
     11719  4462

  * 25 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 25

    - failed on trial 1 of 100

  * 50 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 50

    - failed on trial 1 of 15

  * 100 random line segments
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 100

    - failed on trial 1 of 2

==> FAILED

Test 11: random distinct points in a given range
  * 5 random points in a 10-by-10 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

    - failed on trial 1 of 500
     5
         8     4
         3     9
         7     0
         5     5
         9     9

  * 10 random points in a 10-by-10 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

    - failed on trial 1 of 500
     10
         6     0
         0     0
         8     2
         8     5
         6     4
         4     5
         1     8
         2     0
         6     8
         2     2

  * 50 random points in a 10-by-10 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 40

    - failed on trial 1 of 100

  * 90 random points in a 10-by-10 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 130

    - failed on trial 1 of 50

  * 200 random points in a 50-by-50 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 232

    - failed on trial 1 of 10

==> FAILED

Test 12: m*n points on an m-by-n grid
  * 3-by-3 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 0

  * 4-by-4 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 10

  * 5-by-5 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 16

  * 10-by-10 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 154

  * 20-by-20 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 2446

  * 5-by-4 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 13

  * 6-by-4 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 16

  * 10-by-4 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 38

  * 15-by-4 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 79

  * 25-by-4 grid
    - segment 0 returned by student segments() is null
    - number of non-null entries in student   segments() = 0
    - number of     null entries in student   segments() = 1
    - number of          entries in reference segments() = 213

==> FAILED

Test 13: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==> passed

Test 14: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 15: numberOfSegments() is consistent with segments()
  * filename = input8.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 0
    - length of array returned by segments() = 1

  * filename = equidistant.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 0
    - length of array returned by segments() = 1

  * filename = input40.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 0
    - length of array returned by segments() = 1

  * filename = input48.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 0
    - length of array returned by segments() = 1

  * filename = horizontal5.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 0
    - length of array returned by segments() = 1

  * filename = vertical5.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 0
    - length of array returned by segments() = 1

  * filename = random23.txt
    - segments() and numberOfSegments() are inconsistent
    - numberOfSegments()                     = 0
    - length of array returned by segments() = 1

==> FAILED

Test 16: throws an exception if either constructor argument is null
         or any entry in array is null
  * argument is null
    - constructor fails to throw an exception
     0

  * Point[] of length 10, number of null entries = 1
    - constructor fails to throw an exception
     10
     19186  7721
      4974 25399
      3214 29805
      7416  1105
     17690 30186
      2227  9442
     12740 32338
     17336 14268
     27317 14449
     null

  * Point[] of length 10, number of null entries = 10
    - constructor fails to throw an exception
     10
     null
     null
     null
     null
     null
     null
     null
     null
     null
     null

  * Point[] of length 4, number of null entries = 1
    - constructor fails to throw an exception
     4
     12452 14827
     15816  1029
      1477 16122
     null

  * Point[] of length 3, number of null entries = 1
    - constructor fails to throw an exception
     3
     24883 22580
     25469  2942
     null

  * Point[] of length 2, number of null entries = 1
    - constructor fails to throw an exception
     2
     26413 23607
     null

  * Point[] of length 1, number of null entries = 1
    - constructor fails to throw an exception
     1
     null

==> FAILED

Test 17: check that the constructor throws an exception if duplicate points
  * 50 points
    - failed on trial 1 of 5
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points


  * 25 points
    - failed on trial 1 of 10
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points


  * 5 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     5
      4528   962
     27830 13017
     27830 13017
      4666 16579
     20825 20860

  * 4 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     4
      8799 13597
     28520 14639
      8799 13597
     22766 21145

  * 3 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     3
     18789  5076
     13325  7927
     13325  7927

  * 2 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points

     2
     27592 14457
     27592 14457

==> FAILED


Total: 2/21 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point
*-----------------------------------------------------------
Running 1 total tests.

The maximum amount of memory per Point object is 32 bytes.

Student memory = 24 bytes (passed)

Total: 1/1 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing BruteCollinearPoints
*-----------------------------------------------------------
Running 10 total tests.

Test 1a-1e: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00        5460           0           5460                   48         
=> passed    32   0.00      107880           0         107880                  123         
=> passed    64   0.03     1906128           0        1906128                  310         
=> passed   128   0.07    32004000           0       32004000                  730         
=> passed   256   0.73   524377920           0      524377920                 1717         
==> 5/5 tests passed

Test 2a-2e: Find collinear points among n/4 arbitrary line segments


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00        5460           0           5460                   47         
=> passed    32   0.00      107880           0         107880                  122         
=> passed    64   0.01     1906128           0        1906128                  309         
=> passed   128   0.11    32004000           0       32004000                  737         
=> passed   256   1.61   524377920           0      524377920                 1729         
==> 5/5 tests passed

Total: 10/10 tests passed!


================================================================



Timing FastCollinearPoints
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00           0           0              0                    0         
=> passed   128   0.00           0           0              0                    0         
=> passed   256   0.00           0           0              0                    0         
=> passed   512   0.00           0           0              0                    0         
=> passed  1024   0.00           0           0              0                    0         
=> passed  2048   0.00           0           0              0                    0         
==> 6/6 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (0 / 0) = NaN
=> FAILED (lg ratio is much greater than 2, your algorithm is probably cubic (or worse))

==> 6/7 tests passed

Test 2a-2g: Find collinear points among the n points on an n-by-1 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00           0           0              0                    0         
=> passed   128   0.00           0           0              0                    0         
=> passed   256   0.00           0           0              0                    0         
=> passed   512   0.00           0           0              0                    0         
=> passed  1024   0.00           0           0              0                    0         
=> passed  2048   0.00           0           0              0                    0         
=> passed  4096   0

...

WARNING: the grading output was truncated due to excessive length.
Typically, this is because you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception). A large amount of output
can also arise from failing many tests.
```
