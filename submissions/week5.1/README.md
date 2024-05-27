See the Assessment Guide for information on how to interpret this report.

## ASSESSMENT SUMMARY

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     FAILED (5 warnings)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 1 warning)

Correctness:  9/35 tests passed
Memory:       16/16 tests passed
Timing:       26/42 tests passed

Aggregate score: 47.81%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
```

## ASSESSMENT DETAILS

```
The following files were submitted:
----------------------------------
5.2K May 27 15:24 KdTree.java
3.1K May 27 15:24 PointSET.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac PointSET.java
*-----------------------------------------------------------

% javac KdTree.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
PointSET:

KdTree:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------
H D ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD ST: The instance method or constructor 'KdTree()' writes to the static variable 'size', which is generally bad style.  At KdTree.java:[line 33]
M C SPP_USE_ZERO_WITH_COMPARATOR SPP: Method KdTree.contains(KdTree$Node, Point2D) compares the result of a compareTo method to a value other than zero  At KdTree.java:[line 107]
M C SPP_USE_ZERO_WITH_COMPARATOR SPP: Method KdTree.contains(KdTree$Node, Point2D) compares the result of a compareTo method to a value other than zero  At KdTree.java:[line 108]
M D MOM_MISLEADING_OVERLOAD_MODEL MOM: Class KdTree 'overloads' a method with both instance and static versions  At KdTree.java:[lines 55-95]
M D MOM_MISLEADING_OVERLOAD_MODEL MOM: Class KdTree 'overloads' a method with both instance and static versions  At KdTree.java:[lines 105-109]
SpotBugs ends with 5 warnings.


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------

% custom checkstyle checks for PointSET.java
*-----------------------------------------------------------

% custom checkstyle checks for KdTree.java
*-----------------------------------------------------------
[WARN] KdTree.java:4: Declaring 1 non-final static variables ('size') suggests poor design in this class. [StaticVariableCount]
Checkstyle ends with 0 errors and 1 warning.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of PointSET
*-----------------------------------------------------------
Running 8 total tests.

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m

Test 1: insert n random points; check size() and isEmpty() after each insertion
        (size may be less than n because of duplicates)
  * 5 random points in a 1-by-1 grid
  * 50 random points in a 8-by-8 grid
  * 100 random points in a 16-by-16 grid
  * 1000 random points in a 128-by-128 grid
  * 5000 random points in a 1024-by-1024 grid
  * 50000 random points in a 65536-by-65536 grid
==> passed

Test 2: insert n random points; check contains() with random query points
  * 1 random points in a 1-by-1 grid
  * 10 random points in a 4-by-4 grid
  * 20 random points in a 8-by-8 grid
  * 10000 random points in a 128-by-128 grid
  * 100000 random points in a 1024-by-1024 grid
  * 100000 random points in a 65536-by-65536 grid
==> passed

Test 3: insert random points; check nearest() with random query points
  * 10 random points in a 4-by-4 grid
  * 15 random points in a 8-by-8 grid
  * 20 random points in a 16-by-16 grid
  * 100 random points in a 32-by-32 grid
  * 10000 random points in a 65536-by-65536 grid
==> passed

Test 4: insert random points; check range() with random query rectangles
  * 2 random points and random rectangles in a 2-by-2 grid
  * 10 random points and random rectangles in a 4-by-4 grid
  * 20 random points and random rectangles in a 8-by-8 grid
  * 100 random points and random rectangles in a 16-by-16 grid
  * 1000 random points and random rectangles in a 64-by-64 grid
  * 10000 random points and random rectangles in a 128-by-128 grid
==> passed

Test 5: call methods before inserting any points
 * size() and isEmpty()
 * contains()
 * nearest()
 * range()
==> passed

Test 6: call methods with null argument
  * insert()
  * contains()
  * range()
    - throws wrong exception when calling range() with a null argument
    - throws a java.lang.NullPointerException
    - should throw a java.lang.IllegalArgumentException

  * nearest()
    - throws wrong exception when calling nearest() with a null argument
    - throws a java.lang.NullPointerException
    - should throw a java.lang.IllegalArgumentException

==> FAILED

Test 7: check intermixed sequence of calls to insert(), isEmpty(),
        size(), contains(), range(), and nearest() with
        probabilities (p1, p2, p3, p4, p5, p6, p7), respectively
  * 10000 calls with random points in a 1-by-1 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 16-by-16 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 128-by-128 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 1024-by-1024 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 8192-by-8192 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 65536-by-65536 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
==> passed

Test 8: check that two PointSET objects can be created at the same time
==> passed


Total: 7/8 tests passed!


================================================================
Testing correctness of KdTree
*-----------------------------------------------------------
Running 27 total tests.

In the tests below, we consider three classes of points and rectangles.

  * Non-degenerate points: no two points (or rectangles) share either an
                           x-coordinate or a y-coordinate

  * Distinct points:       no two points (or rectangles) share both an
                           x-coordinate and a y-coordinate

  * General points:        no restrictions on the x-coordinates or y-coordinates
                           of the points (or rectangles)

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m (inclusive).

Test 1a: insert points from file; check size() and isEmpty() after each insertion
  * input0.txt
  * input1.txt
    - failed after inserting point 1 of 1
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.5 0.5

  * input5.txt
    - failed after inserting point 1 of 5
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.7 0.2

  * input10.txt
    - failed after inserting point 1 of 10
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.372 0.497

  * input25.txt
    - failed after inserting point 1 of 25
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.29 0.17

  * input50.txt
    - failed after inserting point 1 of 50
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.006 0.715

==> FAILED

Test 1b: insert non-degenerate points; check size() and isEmpty() after each insertion
  * 1 random non-degenerate points in a 1-by-1 grid
    - failed after inserting point 1 of 1
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.0 0.0

  * 5 random non-degenerate points in a 8-by-8 grid
    - failed after inserting point 1 of 5
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.875 0.5

  * 10 random non-degenerate points in a 16-by-16 grid
    - failed after inserting point 1 of 10
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.375 0.9375

  * 50 random non-degenerate points in a 128-by-128 grid
    - failed after inserting point 1 of 50
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.34375 0.8125

  * 500 random non-degenerate points in a 1024-by-1024 grid
    - failed after inserting point 1 of 500
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.2412109375 0.873046875

  * 50000 random non-degenerate points in a 65536-by-65536 grid
    - failed after inserting point 1 of 50000
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.4035186767578125 0.4357452392578125

==> FAILED

Test 1c: insert distinct points; check size() and isEmpty() after each insertion
  * 1 random distinct points in a 1-by-1 grid
    - failed after inserting point 1 of 1
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  1.0 0.0

  * 10 random distinct points in a 8-by-8 grid
    - failed after inserting point 1 of 10
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.125 0.625

  * 20 random distinct points in a 16-by-16 grid
    - failed after inserting point 1 of 20
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.4375 0.6875

  * 10000 random distinct points in a 128-by-128 grid
    - failed after inserting point 1 of 10000
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.265625 0.203125

  * 100000 random distinct points in a 1024-by-1024 grid
    - failed after inserting point 1 of 100000
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.44140625 0.263671875

  * 100000 random distinct points in a 65536-by-65536 grid
    - failed after inserting point 1 of 100000
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.3484649658203125 0.8686370849609375

==> FAILED

Test 1d: insert general points; check size() and isEmpty() after each insertion
  * 5 random general points in a 1-by-1 grid
    - failed after inserting point 1 of 5
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  1.0 0.0

  * 10 random general points in a 4-by-4 grid
    - failed after inserting point 1 of 10
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.75 0.75

  * 50 random general points in a 8-by-8 grid
    - failed after inserting point 1 of 50
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  1.0 0.0

  * 100000 random general points in a 16-by-16 grid
    - failed after inserting point 1 of 100000
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  1.0 0.0625

  * 100000 random general points in a 128-by-128 grid
    - failed after inserting point 1 of 100000
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.4375 0.6953125

  * 100000 random general points in a 1024-by-1024 grid
    - failed after inserting point 1 of 100000
    - student   size()    = 0
    - reference size()    = 1
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of points inserted: 
      A  0.1376953125 0.080078125

==> FAILED

Test 2a: insert points from file; check contains() with random query points
  * input0.txt
  * input1.txt
  * input5.txt
    - failed on trial 179 of 10000
    - query point          = (0.2, 0.3)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6

  * input10.txt
==> FAILED

Test 2b: insert non-degenerate points; check contains() with random query points
  * 1 random non-degenerate points in a 1-by-1 grid
    - failed on trial 17 of 10000
    - query point          = (1.0, 0.0)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  1.0 0.0

  * 5 random non-degenerate points in a 8-by-8 grid
    - failed on trial 23 of 10000
    - query point          = (0.375, 0.5)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  0.375 0.5
      B  0.625 0.125
      C  0.0 0.25
      D  0.5 1.0
      E  0.125 0.375

  * 10 random non-degenerate points in a 16-by-16 grid
    - failed on trial 3 of 10000
    - query point          = (0.5625, 0.625)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  0.3125 0.4375
      B  0.4375 0.9375
      C  0.625 0.5
      D  0.6875 0.8125
      E  0.125 1.0
      F  0.5625 0.625
      G  0.0625 0.0
      H  0.375 0.25
      I  0.1875 0.1875
      J  0.0 0.375

  * 20 random non-degenerate points in a 32-by-32 grid
    - failed on trial 19 of 10000
    - query point          = (0.59375, 0.875)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  0.5 0.40625
      B  0.03125 0.78125
      C  0.65625 0.125
      D  0.28125 0.0
      E  0.96875 0.25
      F  0.0 0.375
      G  0.0625 0.625
      H  0.4375 0.1875
      I  0.3125 0.71875
      J  0.84375 0.59375
      K  0.75 0.03125
      L  0.6875 0.28125
      M  0.78125 0.84375
      N  0.34375 0.46875
      O  0.40625 0.8125
      P  0.59375 0.875
      Q  0.5625 0.3125
      R  0.09375 0.90625
      S  0.375 0.6875
      T  0.90625 0.4375

  * 500 random non-degenerate points in a 1024-by-1024 grid
    - failed on trial 1801 of 10000
    - query point          = (0.736328125, 0.2626953125)
    - student   contains() = false
    - reference contains() = true

  * 10000 random non-degenerate points in a 65536-by-65536 grid
==> FAILED

Test 2c: insert distinct points; check contains() with random query points
  * 1 random distinct points in a 1-by-1 grid
    - failed on trial 4 of 10000
    - query point          = (0.0, 0.0)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  0.0 0.0

  * 10 random distinct points in a 4-by-4 grid
    - failed on trial 3 of 10000
    - query point          = (0.0, 1.0)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  0.25 0.0
      B  0.25 0.5
      C  0.75 0.25
      D  0.5 0.25
      E  0.5 1.0
      F  0.5 0.5
      G  0.0 0.5
      H  0.75 1.0
      I  0.0 1.0
      J  0.25 0.75

  * 20 random distinct points in a 8-by-8 grid
    - failed on trial 7 of 10000
    - query point          = (0.25, 1.0)
    - student   contains() = false
    - reference contains() = true
    - sequence of points inserted: 
      A  0.0 0.125
      B  0.5 0.125
      C  1.0 0.375
      D  0.875 0.5
      E  0.625 0.5
      F  1.0 0.125
      G  0.75 0.375
      H  0.375 0.5
      I  0.75 0.125
      J  0.375 0.375
      K  0.25 0.25
      L  0.875 0.875
      M  0.25 0.375
      N  0.125 0.75
      O  0.5 0.25
      P  0.25 1.0
      Q  0.375 1.0
      R  0.0 0.25
      S  0.125 0.25
      T  0.0 1.0

  * 10000 random distinct points in a 128-by-128 grid
    - failed on trial 1 of 10000
    - query point          = (0.984375, 0.0)
    - student   contains() = false
    - reference contains() = true

  * 100000 random distinct points in a 1024-by-1024 grid
    - failed on trial 3 of 10000
    - query point          = (0.2197265625, 0.5673828125)
    - student   contains() = false
    - reference contains() = true

  * 100000 random distinct points in a 65536-by-65536 grid
==> FAILED

Test 2d: insert general points; check contains() with random query points
  * 10000 random general points in a 1-by-1 grid
    - failed on trial 1 of 10000
    - query point          = (0.0, 0.0)
    - student   contains() = false
    - reference contains() = true

  * 10000 random general points in a 16-by-16 grid
    - failed on trial 1 of 10000
    - query point          = (0.875, 0.375)
    - student   contains() = false
    - reference contains() = true

  * 10000 random general points in a 128-by-128 grid
    - failed on trial 1 of 10000
    - query point          = (0.9921875, 0.6484375)
    - student   contains() = false
    - reference contains() = true

  * 10000 random general points in a 1024-by-1024 grid
    - failed on trial 13 of 10000
    - query point          = (0.22265625, 0.904296875)
    - student   contains() = false
    - reference contains() = true

==> FAILED

Test 3a: insert points from file; check range() with random query rectangles
  * input0.txt
  * input1.txt
  * input5.txt
    - failed on trial 1 of 10000
    - query rectangle = [0.154, 0.52] x [0.329, 0.665]
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - student   range():  null
    - reference range():  B 

  * input10.txt
    - failed on trial 1 of 10000
    - query rectangle = [0.175, 0.382] x [0.28, 0.842]
    - sequence of points inserted: 
      A  0.372 0.497
      B  0.564 0.413
      C  0.226 0.577
      D  0.144 0.179
      E  0.083 0.51
      F  0.32 0.708
      G  0.417 0.362
      H  0.862 0.825
      I  0.785 0.725
      J  0.499 0.208
    - student   range():  null
    - reference range():  A C F 

==> FAILED

Test 3b: insert non-degenerate points; check range() with random query rectangles
  * 1 random non-degenerate points and random rectangles in a 2-by-2 grid
  * 5 random non-degenerate points and random rectangles in a 8-by-8 grid
  * 10 random non-degenerate points and random rectangles in a 16-by-16 grid
  * 20 random non-degenerate points and random rectangles in a 32-by-32 grid
  * 500 random non-degenerate points and random rectangles in a 1024-by-1024 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.275390625, 0.30859375] x [0.0625, 0.6318359375]
    - student   range():  null
    - reference range():  K O P E L B S T Q 

  * 10000 random non-degenerate points and random rectangles in a 65536-by-65536 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.1381378173828125, 0.32537841796875] x [0.4681243896484375, 0.6020660400390625]
    - student   range():  null
    - reference range():  P S Z E L H Y J E F O W F M B V X U J H Q C A B Y Z ...

==> FAILED

Test 3c: insert distinct points; check range() with random query rectangles
  * 2 random distinct points and random rectangles in a 2-by-2 grid
  * 10 random distinct points and random rectangles in a 4-by-4 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.25, 0.75] x [0.0, 0.75]
    - sequence of points inserted: 
      A  1.0 0.75
      B  0.0 0.5
      C  0.5 0.25
      D  0.0 0.75
      E  0.0 0.25
      F  1.0 0.5
      G  0.5 0.5
      H  0.5 0.75
      I  0.25 0.25
      J  0.75 0.5
    - student   range():  null
    - reference range():  C I G H J 

  * 20 random distinct points and random rectangles in a 8-by-8 grid
  * 100 random distinct points and random rectangles in a 16-by-16 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.375, 0.9375] x [0.5, 0.9375]
    - student   range():  null
    - reference range():  L E K J F H G R R G P V S D F P C X E I M O F L H 

  * 1000 random distinct points and random rectangles in a 64-by-64 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.34375, 0.90625] x [0.78125, 0.96875]
    - student   range():  null
    - reference range():  I U T K R N G U X M I G Q R B V B W D R P B F Y B I ...

  * 10000 random distinct points and random rectangles in a 128-by-128 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.296875, 0.8671875] x [0.609375, 0.765625]
    - student   range():  null
    - reference range():  B I N A Q R Q A S L M F H L T Q D F N S F R X G Q V ...

==> FAILED

Test 3d: insert general points; check range() with random query rectangles
  * 5000 random general points and random rectangles in a 2-by-2 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.5, 1.0] x [0.0, 0.0]
    - student   range():  null
    - reference range():  L D 

  * 5000 random general points and random rectangles in a 16-by-16 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.25, 0.375] x [0.625, 0.75]
    - student   range():  null
    - reference range():  G H P X S C G G Q 

  * 5000 random general points and random rectangles in a 128-by-128 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.09375, 0.4765625] x [0.3515625, 0.453125]
    - student   range():  null
    - reference range():  A L P F J T V Q H H U K S V E L J X B K N Q P R T X ...

  * 5000 random general points and random rectangles in a 1024-by-1024 grid
    - failed on trial 1 of 10000
    - query rectangle = [0.4765625, 0.583984375] x [0.328125, 0.708984375]
    - student   range():  null
    - reference range():  F L L G X J T I G T O V H L N D P T S G M N Q R V I ...

==> FAILED

Test 3e: insert random points; check range() with tiny rectangles
         enclosing each point
  * 5 tiny rectangles and 5 general points in a 2-by-2 grid
    - failed on trial 0 of 5
    - query rectangle = [0.75, 1.0] x [0.0, 0.25]
    - sequence of points inserted: 
      A  1.0 0.0
      B  0.0 0.0
      C  0.5 1.0
      D  1.0 0.5
      E  0.0 1.0
    - student   range():  null
    - reference range():  A 

  * 10 tiny rectangles and 10 general points in a 4-by-4 grid
    - failed on trial 0 of 10
    - query rectangle = [0.375, 0.625] x [0.375, 0.625]
    - sequence of points inserted: 
      A  0.5 0.5
      B  0.25 0.5
      C  1.0 0.25
      D  0.5 0.0
      E  0.5 0.5
      F  0.0 1.0
      G  0.5 1.0
      H  0.0 0.25
      I  0.0 0.0
      J  0.25 0.25
    - student   range():  null
    - reference range():  E 

  * 20 tiny rectangles and 20 general points in a 8-by-8 grid
    - failed on trial 0 of 20
    - query rectangle = [0.8125, 0.9375] x [0.0, 0.0625]
    - sequence of points inserted: 
      A  0.875 0.0
      B  0.625 0.5
      C  0.375 0.625
      D  0.375 0.125
      E  0.0 0.875
      F  0.625 0.75
      G  0.875 0.75
      H  1.0 0.75
      I  0.625 0.25
      J  0.0 0.75
      K  0.875 0.125
      L  1.0 0.375
      M  0.25 0.25
      N  0.875 0.125
      O  0.625 0.0
      P  1.0 1.0
      Q  0.375 0.0
      R  0.0 0.125
      S  0.25 0.375
      T  0.375 0.875
    - student   range():  null
    - reference range():  A 

  * 5000 tiny rectangles and 5000 general points in a 128-by-128 grid
    - failed on trial 0 of 5000
    - query rectangle = [0.94921875, 0.95703125] x [0.23046875, 0.23828125]
    - student   range():  null
    - reference range():  A 

  * 5000 tiny rectangles and 5000 general points in a 1024-by-1024 grid
    - failed on trial 0 of 5000
    - query rectangle = [0.96728515625, 0.96826171875] x [0.37451171875, 0.37548828125]
    - student   range():  null
    - reference range():  A 

  * 5000 tiny rectangles and 5000 general points in a 65536-by-65536 grid
    - failed on trial 0 of 5000
    - query rectangle = [0.6785659790039062, 0.6785812377929688] x [0.7042160034179688, 0.7042312622070312]
    - student   range():  null
    - reference range():  A 

==> FAILED

Test 4a: insert points from file; check range() with random query rectangles
         and check traversal of k-d tree
  * input5.txt
    - student range() returns wrong set of points
    - student   range():  empty
    - reference range():  B D 
    - performs incorrect traversal of k-d tree during call to range()
    - query rectangle = [0.13, 0.52] x [0.36, 0.75]
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - student k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference k-d tree nodes involved in calls to Point2D methods:
      A B C D 
    - failed on trial 1 of 1000

  * input10.txt
    - student range() returns wrong set of points
    - student   range():  empty
    - reference range():  C 
    - performs incorrect traversal of k-d tree during call to range()
    - query rectangle = [0.14, 0.3] x [0.47, 0.75]
    - sequence of points inserted: 
      A  0.372 0.497
      B  0.564 0.413
      C  0.226 0.577
      D  0.144 0.179
      E  0.083 0.51
      F  0.32 0.708
      G  0.417 0.362
      H  0.862 0.825
      I  0.785 0.725
      J  0.499 0.208
    - student k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference k-d tree nodes involved in calls to Point2D methods:
      A C D E F 
    - failed on trial 1 of 1000

==> FAILED

Test 4b: insert non-degenerate points; check range() with random query rectangles
         and check traversal of k-d tree
  * 3 random non-degenerate points and 1000 random rectangles in a 4-by-4 grid
    - student range() returns wrong set of points
    - student   range():  empty
    - reference range():  C 
    - performs incorrect traversal of k-d tree during call to range()
    - query rectangle = [0.0, 1.0] x [0.0, 0.5]
    - sequence of points inserted: 
      A  0.5 0.75
      B  0.75 1.0
      C  0.25 0.25
    - student k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference k-d tree nodes involved in calls to Point2D methods:
      A C B 
    - failed on trial 1 of 1000

  * 6 random non-degenerate points and 1000 random rectangles in a 8-by-8 grid
    - student range() returns correct set of points
    - student   range():  empty
    - reference range():  empty
    - performs incorrect traversal of k-d tree during call to range()
    - query rectangle = [0.5, 0.625] x [0.125, 0.875]
    - sequence of points inserted: 
      A  0.125 0.625
      B  0.875 0.375
      C  0.375 0.0
      D  0.25 1.0
      E  1.0 0.25
      F  0.75 0.75
    - student k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference k-d tree nodes involved in calls to Point2D methods:
      A B C E D F 
    - failed on trial 1 of 1000

  * 10 random non-degenerate points and 1000 random rectangles in a 16-by-16 grid
    - student range() returns wrong set of points
    - student   range():  empty
    - reference range():  E 
    - performs incorrect traversal of k-d tree during call to range()
    - query rectangle = [0.3125, 0.9375] x [0.1875, 0.4375]
    - sequence of points inserted: 
      A  1.0 0.3125
      B  0.0 0.5
      C  0.8125 1.0
      D  0.5625 0.0625
      E  0.6875 0.375
      F  0.875 0.5625
      G  0.0625 0.6875
      H  0.625 0.625
      I  0.4375 0.9375
      J  0.125 0.125
    - student k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference k-d tree nodes involved in calls to Point2D methods:
      A B D J E 
    - failed on trial 1 of 1000

  * 20 random non-degenerate points and 1000 random rectangles in a 32-by-32 grid
    - student range() returns correct set of points
    - student   range():  empty
    - reference range():  empty
    - performs incorrect traversal of k-d tree during call to range()
    - query rectangle = [0.09375, 0.3125] x [0.5625, 0.8125]
    - sequence of points inserted: 
      A  0.5 0.71875
      B  0.65625 0.46875
      C  0.28125 0.84375
      D  0.96875 0.59375
      E  0.375 0.1875
      F  0.84375 0.78125
      G  0.34375 0.0625
      H  0.6875 0.625
      I  0.53125 0.3125
      J  0.21875 0.15625
      K  0.1875 0.875
      L  0.8125 0.53125
      M  0.4375 0.90625
      N  0.125 0.125
      O  0.90625 0.0
      P  0.40625 0.65625
      Q  0.25 0.9375
      R  0.9375 0.96875
      S  0.78125 0.09375
      T  0.625 0.40625
    - student k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference k-d tree nodes involved in calls to Point2D methods:
      A C E G J N 
    - failed on trial 1 of 1000

  * 30 random non-degenerate points and 1000 random rectangles in a 64-by-64 grid
    - student range() returns wrong set of points
    - student   range():  empty
    - reference range():  C Q T D G U B 
    - performs incorrect traversal of k-d tree during call to range()
    - query rectangle = [0.25, 0.5625] x [0.359375, 0.84375]
    - number of entries in student   solution: 0
    - number of entries in reference solution: 18
    - 18 missing entries in student solution, including:
      '(0.046875, 0.921875)'

    - failed on trial 1 of 1000

==> FAILED

Test 5a: insert points from file; check nearest() with random query points
  * input0.txt
  * input1.txt
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.5, 0.5)

  * input5.txt
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.4, 0.7)

  * input10.txt
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.499, 0.208)

==> FAILED

Test 5b: insert non-degenerate points; check nearest() with random query points
  * 5 random non-degenerate points in a 8-by-8 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.25, 0.875)

  * 10 random non-degenerate points in a 16-by-16 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.9375, 0.5)

  * 20 random non-degenerate points in a 32-by-32 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.75, 0.875)

  * 30 random non-degenerate points in a 64-by-64 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.203125, 0.78125)

  * 10000 random non-degenerate points in a 65536-by-65536 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.6200714111328125, 0.4708709716796875)

==> FAILED

Test 5c: insert distinct points; check nearest() with random query points
  * 10 random distinct points in a 4-by-4 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.0, 0.5)

  * 15 random distinct points in a 8-by-8 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.125, 0.25)

  * 20 random distinct points in a 16-by-16 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.75, 0.25)

  * 100 random distinct points in a 32-by-32 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.5625, 0.875)

  * 10000 random distinct points in a 65536-by-65536 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.780059814453125, 0.596405029296875)

==> FAILED

Test 5d: insert general points; check nearest() with random query points
  * 10000 random general points in a 16-by-16 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (1.0, 0.25)

  * 10000 random general points in a 128-by-128 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.1953125, 0.5625)

  * 10000 random general points in a 1024-by-1024 grid
    - failed on trial 1 of 10000
    - student   nearest()  = null
    - reference nearest()  = (0.8876953125, 0.4404296875)

==> FAILED

Test 6a: insert points from file; check nearest() with random query points
         and check traversal of k-d tree
  * input5.txt
    - student   nearest() = null
    - reference nearest() = (0.4, 0.7)
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.34, 0.53)
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B D C 
    - failed on trial 1 of 1000

  * input10.txt
    - student   nearest() = null
    - reference nearest() = (0.862, 0.825)
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (1.0, 0.76)
    - sequence of points inserted: 
      A  0.372 0.497
      B  0.564 0.413
      C  0.226 0.577
      D  0.144 0.179
      E  0.083 0.51
      F  0.32 0.708
      G  0.417 0.362
      H  0.862 0.825
      I  0.785 0.725
      J  0.499 0.208
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B H I 
    - failed on trial 1 of 1000

==> FAILED

Test 6b: insert non-degenerate points; check nearest() with random query points
         and check traversal of k-d tree
  * 5 random non-degenerate points in a 8-by-8 grid
    - student   nearest() = null
    - reference nearest() = (0.5, 0.375)
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.375, 0.25)
    - sequence of points inserted: 
      A  0.5 0.375
      B  0.875 1.0
      C  0.125 0.75
      D  0.625 0.5
      E  1.0 0.0
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A C B D 
    - failed on trial 1 of 1000

  * 10 random non-degenerate points in a 16-by-16 grid
    - student   nearest() = null
    - reference nearest() = (0.6875, 0.6875)
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.5625, 0.8125)
    - sequence of points inserted: 
      A  0.4375 0.5
      B  0.875 0.75
      C  0.6875 0.6875
      D  0.8125 0.0
      E  0.375 0.0625
      F  0.0625 1.0
      G  0.3125 0.5625
      H  0.125 0.625
      I  0.1875 0.4375
      J  0.625 0.25
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B C J D E F G H 
    - failed on trial 1 of 1000

  * 20 random non-degenerate points in a 32-by-32 grid
    - student   nearest() = null
    - reference nearest() = (0.3125, 0.34375)
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.375, 0.28125)
    - sequence of points inserted: 
      A  0.53125 0.84375
      B  0.09375 0.625
      C  0.90625 0.25
      D  0.25 0.3125
      E  0.84375 0.78125
      F  0.1875 0.71875
      G  0.8125 0.53125
      H  0.15625 1.0
      I  0.34375 0.375
      J  0.96875 0.65625
      K  0.3125 0.34375
      L  0.9375 0.90625
      M  0.59375 0.6875
      N  0.03125 0.5
      O  0.71875 0.75
      P  0.6875 0.875
      Q  0.0625 0.8125
      R  0.78125 0.46875
      S  1.0 0.4375
      T  0.125 0.96875
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      empty
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B D I K 
    - failed on trial 1 of 1000

  * 30 random non-degenerate points in a 64-by-64 grid
    - student   nearest() = null
    - reference nearest() = (0.109375, 0.75)
    - performs incorrect traversal of k-d tree during call to nearest()
    - number of student   entries = 0
    - number of reference entries = 10
    - failed on trial 1 of 1000

  * 50 random non-degenerate points in a 128-by-128 grid
    - student   nearest() = null
    - reference nearest() = (0.5234375, 0.484375)
    - performs incorrect traversal of k-d tree during call to nearest()
    - number of student   entries = 0
    - number of reference entries = 16
    - failed on trial 1 of 1000

  * 1000 random non-degenerate points in a 2048-by-2048 grid
    - student   nearest() = null
    - reference nearest() = (0.08154296875, 0.92822265625)
    - performs incorrect traversal of k-d tree during call to nearest()
    - number of student   entries = 0
    - number of reference entries = 26
    - failed on trial 1 of 1000

==> FAILED

Test 7: check with no points
  * size() and isEmpty()
  * contains()
  * nearest()
  * range()
==> passed

Test 8: check that the specified exception is thrown with null arguments
  * argument to insert() is null
  * argument to contains() is null
  * argument to range() is null
    - fails to throw an exception when calling range() with a null argument

  * argument to nearest() is null
    - fails to throw an exception when calling nearest() with a null argument

==> FAILED

Test 9a: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with non-degenerate points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 2 of 20000
    - student   isEmpty() = true
    - reference isEmpty() = false
    - sequence of operations was:
           st.insert(1.0, 1.0)
           st.isEmpty()  ==>  true

  * 20000 calls with non-degenerate points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 3 of 20000
    - rectangle = [0.1875, 1.0] x [0.4375, 0.75]
    - student   range():  null
    - reference range():  G 
    - sequence of operations was:
           st.insert(0.125, 1.0)
           st.insert(0.9375, 0.6875)
           st.range([0.1875, 1.0] x [0.4375, 0.75])  ==>  null

  * 20000 calls with non-degenerate points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 5 of 20000
    - rectangle = [0.3203125, 0.578125] x [0.5625, 0.953125]
    - student   range():  null
    - reference range():  M K 
    - sequence of operations was:
           st.insert(0.484375, 0.90625)
           st.insert(0.5546875, 0.640625)
           st.contains((0.40625, 0.625))  ==>  false
           st.insert(0.6484375, 0.71875)
           st.range([0.3203125, 0.578125] x [0.5625, 0.953125])  ==>  null

  * 20000 calls with non-degenerate points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 6 of 20000
    - student   nearest()  = null
    - reference nearest()  = (0.5771484375, 0.4501953125)
    - reference distanceSquaredTo() = 0.10260009765625
    - sequence of operations was:
           st.isEmpty()  ==>  true
           st.insert(0.421875, 0.841796875)
           st.insert(0.935546875, 0.72265625)
           st.insert(9.765625E-4, 0.927734375)
           st.insert(0.5771484375, 0.4501953125)
           st.nearest((0.2646484375, 0.5205078125))   ==>  null

  * 20000 calls with non-degenerate points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 3 of 20000
    - student   nearest()  = null
    - reference nearest()  = (0.200439453125, 0.39013671875)
    - reference distanceSquaredTo() = 0.087586119771004
    - sequence of operations was:
           st.insert(0.200439453125, 0.39013671875)
           st.insert(0.2236328125, 0.8212890625)
           st.nearest((0.1806640625, 0.0948486328125))   ==>  null

  * 20000 calls with non-degenerate points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 3 of 20000
    - student   nearest()  = null
    - reference nearest()  = (0.4469451904296875, 0.4627685546875)
    - reference distanceSquaredTo() = 0.258761147269979
    - sequence of operations was:
           st.size()  ==>  0
           st.insert(0.4469451904296875, 0.4627685546875)
           st.nearest((0.1247406005859375, 0.0691375732421875))   ==>  null

==> FAILED

Test 9b: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with distinct points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 3 of 20000
    - student   nearest()  = null
    - reference nearest()  = (1.0, 1.0)
    - reference distanceSquaredTo() = 1
    - sequence of operations was:
           st.isEmpty()  ==>  true
           st.insert(1.0, 1.0)
           st.nearest((1.0, 0.0))   ==>  null

  * 20000 calls with distinct points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 2 of 20000
    - student   nearest()  = null
    - reference nearest()  = (0.3125, 0.9375)
    - reference distanceSquaredTo() = 0.59765625
    - sequence of operations was:
           st.insert(0.3125, 0.9375)
           st.nearest((0.125, 0.1875))   ==>  null

  * 20000 calls with distinct points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 9 of 20000
    - student   size() = 0
    - reference size() = 3
    - sequence of operations was:
           st.insert(0.890625, 0.5)
           st.contains((0.6171875, 0.8984375))  ==>  false
           st.contains((0.6953125, 0.765625))  ==>  false
           st.contains((0.03125, 1.0))  ==>  false
           st.range([0.109375, 0.296875] x [0.1171875, 0.2421875])  ==>  null
           st.insert(0.1640625, 0.5859375)
           st.insert(0.9609375, 0.4140625)
           st.contains((0.7421875, 0.2890625))  ==>  false
           st.size()  ==>  0

  * 20000 calls with distinct points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 8 of 20000
    - student   size() = 0
    - reference size() = 5
    - sequence of operations was:
           st.isEmpty()  ==>  true
           st.insert(0.8779296875, 0.0478515625)
           st.insert(0.357421875, 0.2646484375)
           st.insert(0.2119140625, 0.869140625)
           st.insert(0.8583984375, 0.515625)
           st.range([0.2939453125, 0.607421875] x [0.5390625, 0.9267578125])  ==>  null
           st.insert(0.8759765625, 0.716796875)
           st.size()  ==>  0

  * 20000 calls with distinct points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 3 of 20000
    - student   nearest()  = null
    - reference nearest()  = (0.480224609375, 0.4422607421875)
    - reference distanceSquaredTo() = 0.124210491776466
    - sequence of operations was:
           st.insert(0.480224609375, 0.4422607421875)
           st.range([0.0084228515625, 0.1656494140625] x [0.1136474609375, 0.7149658203125])  ==>  null
           st.nearest((0.651123046875, 0.75048828125))   ==>  null

  * 20000 calls with distinct points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 4 of 20000
    - rectangle = [0.4236297607421875, 0.7995758056640625] x [0.03765869140625, 0.254608154296875]
    - student   range():  null
    - reference range():  V 
    - sequence of operations was:
           st.insert(0.5168304443359375, 0.839080810546875)
           st.insert(0.2534637451171875, 0.27032470703125)
           st.insert(0.5423431396484375, 0.1865997314453125)
           st.range([0.4236297607421875, 0.7995758056640625] x [0.03765869140625, 0.254608154296875])  ==>  null

==> FAILED

Test 9c: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with general points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 3 of 20000
    - student   nearest()  = null
    - reference nearest()  = (1.0, 1.0)
    - reference distanceSquaredTo() = 1
    - sequence of operations was:
           st.insert(1.0, 1.0)
           st.range([0.0, 0.0] x [0.0, 1.0])  ==>  null
           st.nearest((1.0, 0.0))   ==>  null

  * 20000 calls with general points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 2 of 20000
    - student   nearest()  = null
    - reference nearest()  = (1.0, 0.9375)
    - reference distanceSquaredTo() = 1.15625
    - sequence of operations was:
           st.insert(1.0, 0.9375)
           st.nearest((0.375, 0.0625))   ==>  null

  * 20000 calls with general points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 2 of 20000
    - student   nearest()  = null
    - reference nearest()  = (0.0, 0.2578125)
    - reference distanceSquaredTo() = 0.01715087890625
    - sequence of operations was:
           st.insert(0.0, 0.2578125)
           st.nearest((0.0390625, 0.3828125))   ==>  null

  * 20000 calls with general points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 5 of 20000
    - student   size() = 0
    - reference size() = 2
    - sequence of operations was:
           st.insert(0.9033203125, 0.0703125)
           st.contains((0.1591796875, 0.7255859375))  ==>  false
           st.range([0.3115234375, 0.6943359375] x [0.015625, 0.7333984375])  ==>  null
           st.insert(0.0537109375, 0.3994140625)
           st.size()  ==>  0

  * 20000 calls with general points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 4 of 20000
    - student   size() = 0
    - reference size() = 2
    - sequence of operations was:
           st.insert(0.324462890625, 0.8123779296875)
           st.insert(0.8787841796875, 0.2906494140625)
           st.range([0.839111328125, 0.9395751953125] x [0.396484375, 0.6959228515625])  ==>  null
           st.size()  ==>  0

  * 20000 calls with general points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 8 of 20000
    - rectangle = [0.3001556396484375, 0.5053863525390625] x [0.35650634765625, 0.9099273681640625]
    - student   range():  null
    - reference range():  I 
    - sequence of operations was:
           st.size()  ==>  0
           st.insert(0.62261962890625, 0.5613555908203125)
           st.range([0.145660400390625, 0.6511688232421875] x [0.178680419921875, 0.2655181884765625])  ==>  null
           st.contains((0.2863616943359375, 0.4239044189453125))  ==>  false
           st.insert(0.7546234130859375, 0.505645751953125)
           st.insert(0.4545440673828125, 0.486053466796875)
           st.contains((0.8203887939453125, 0.71112060546875))  ==>  false
           st.range([0.3001556396484375, 0.5053863525390625] x [0.35650634765625, 0.9099273681640625])  ==>  null

==> FAILED

Test 10: insert n random points into two different KdTree objects;
        check that repeated calls to size(), contains(), range(),
        and nearest() with the same arguments yield same results
  * 10 random general points in a 4-by-4 grid
  * 20 random general points in a 8-by-8 grid
  * 100 random general points in a 128-by-128 grid
  * 1000 random general points in a 65536-by-65536 grid
==> passed


Total: 2/27 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point2D
*-----------------------------------------------------------
Memory of Point2D object = 32 bytes

================================================================



Analyzing memory of RectHV
*-----------------------------------------------------------
Memory of RectHV object = 48 bytes

================================================================



Analyzing memory of PointSET
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a PointSET with n points (including Point2D and RectHV objects).
Maximum allowed memory is 96n + 200 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          264                264
=> passed        2          360                360
=> passed        5          648                648
=> passed       10         1128               1128
=> passed       25         2568               2568
=> passed      100         9768               9768
=> passed      400        38568              38568
=> passed      800        76968              76968
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)
Estimated reference memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)

================================================================



Analyzing memory of KdTree
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a KdTree with n points (including Point2D and RectHV objects).
Maximum allowed memory is 312n + 192 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          160                160
=> passed        2          160                288
=> passed        5          160                672
=> passed       10          160               1312
=> passed       25          160               3232
=> passed      100          160              12832
=> passed      400          160              51232
=> passed      800          160             102432
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 0.00 n + 160.00  (R^2 = NaN)
Estimated reference memory (bytes) = 128.00 n + 32.00  (R^2 = 1.000)

================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing PointSET
*-----------------------------------------------------------
Running 14 total tests.


Inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000    1724638         
=> passed   320000    1753798         
=> passed   640000    1488044         
=> passed  1280000    1061768         
==> 4/4 tests passed

Performing contains() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000     549829         
=> passed   320000     600162         
=> passed   640000     579546         
=> passed  1280000     477597         
==> 4/4 tests passed

Performing range() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       4946         
=> passed    20000       1709         
=> passed    40000        758         
==> 3/3 tests passed

Performing nearest() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       6996         
=> passed    20000       2039         
=> passed    40000        860         
==> 3/3 tests passed

Total: 14/14 tests passed!


================================================================



Timing KdTree
*-----------------------------------------------------------
Running 28 total tests.


Test 1a-d: Insert n points into a 2d tree. The table gives the average number of calls
           to methods in RectHV and Point per call to insert().

                                                                                                Point2D
               n      ops per second       RectHV()           x()               y()             equals()
----------------------------------------------------------------------------------------------------------------
=> passed   160000    9588903               1.0               0.0               0.0               0.0         
=> passed   320000   66484886               1.0               0.0               0.0               0.0         
=> passed   640000   69360852               1.0               0.0               0.0               0.0         
=> passed  1280000   73402454               1.0               0.0               0.0               0.0         
==> 4/4 tests passed


Test 2a-h: Perform contains() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to contains().

                                                                               Point2D
               n      ops per second       x()               y()               equals()
-----------------------------------------------------------------------------------------------
=> passed    10000    1180815               0.0               0.0               0.0         
=> passed    20000    1246571               0.0               0.0               0.0         
=> passed    40000    1249076               0.0               0.0               0.0         
=> passed    80000    1250223               0.0               0.0               0.0         
=> passed   160000    1250369               0.0               0.0               0.0         
=> passed   320000    1251229               0.0               0.0               0.0         
=> passed   640000    1197976               0.0               0.0               0.0     

...

WARNING: the grading output was truncated due to excessive length.
Typically, this is because you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception). A large amount of output
can also arise from failing many tests.
```
