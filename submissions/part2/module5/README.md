See the Assessment Guide for information on how to interpret this report.

## ASSESSMENT SUMMARY

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     PASSED
PMD:          PASSED
Checkstyle:   PASSED

Correctness:  18/34 tests passed
Memory:       6/6 tests passed
Timing:       3/17 tests passed

Aggregate score: 55.29%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
```

## ASSESSMENT DETAILS

```
The following files were submitted:
----------------------------------
7.2K Jul  4 08:21 SeamCarver.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac SeamCarver.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
SeamCarver:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------

% custom checkstyle checks for SeamCarver.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of SeamCarver
*-----------------------------------------------------------
Running 34 total tests.

Test 1a: check energy() with file inputs
  * 6x5.png
  * 4x6.png
  * 10x12.png
  * 3x7.png
  * 5x6.png
  * 7x3.png
  * 7x10.png
  * 12x10.png
  * stripes.png
  * diagonals.png
  * chameleon.png
  * HJoceanSmall.png
  * 1x8.png
  * 8x1.png
  * 1x1.png
==> passed

Test 1b: check energy() with random pictures
  * 100 random 4-by-6 pictures
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 1c: check energy() with random pictures in which the RGB components
         of each pixel are in a small range
  * 100 random 4-by-6 pictures
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 2a: check width() with file inputs
  * 6x5.png
  * 4x6.png
==> passed

Test 2b: check width() with random pictures
  * 10 random 4-by-6 pictures
  * 10 random 5-by-5 pictures
  * 10 random 6-by-4 pictures
  * 10 random 7-by-10 pictures
==> passed

Test 3a: check height() with file inputs
  * 6x5.png
  * 4x6.png
==> passed

Test 3b: check height() with random pictures
  * 10 random 4-by-6 pictures
  * 10 random 5-by-5 pictures
  * 10 random 6-by-4 pictures
  * 10 random 7-by-10 pictures
==> passed

Test 4a: check findVerticalSeam() with file inputs
  * 6x5.png
  * 4x6.png
  * 10x12.png
  * 3x7.png
  * 5x6.png
  * 7x3.png
  * 7x10.png
  * 12x10.png
  * stripes.png
  * diagonals.png
  * chameleon.png
  * HJoceanSmall.png
  * 1x8.png
  * 8x1.png
  * 1x1.png
==> passed

Test 4b: check findVerticalSeam() with random pictures
  * 100 random 4-by-6 pictures
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 8-by-8 pictures
  * 100 random 7-by-10 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 4c: check findVerticalSeam() with random pictures in which
         the RGB values of each pixel are in a small range
  * 100 random 4-by-6 pictures
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 100 random 8-by-8 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 5a: check findHorizontalSeam() with file inputs
  * 6x5.png
  * 4x6.png
  * 10x12.png
  * 3x7.png
  * 5x6.png
  * 7x3.png
  * 7x10.png
  * 12x10.png
  * stripes.png
  * diagonals.png
  * chameleon.png
  * HJoceanSmall.png
  * 1x8.png
  * 8x1.png
  * 1x1.png
==> passed

Test 5b: check findHorizontalSeam() with random pictures
  * 100 random 4-by-6 pictures
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 100 random 8-by-8 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 5c: check findHorizontalSeam() with random pictures in which the RGB
         components of each pixel are in a small range
  * 100 random 4-by-6 pictures
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 100 random 8-by-8 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 6a: check removeVerticalSeam() with file inputs and optimal seams
  * 6x5.png

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6a(TestSeamCarver.java:1398)
    TestSeamCarver.main(TestSeamCarver.java:1885)

    - failed after removing vertical seam[] = { 3, 4, 3, 2, 1 }

  * 10x12.png
    - failed after removing vertical seam[] = { 5, 6, 7, 8, 7, 7, 6, 7, 6, 5, 6, 5 }
    - student picture() does not match reference picture()
    - student   picture is 10-by-11
    - reference picture is 9-by-12

  * 3x7.png
    - failed after removing vertical seam[] = { 0, 1, 1, 1, 1, 1, 0 }
    - student picture() does not match reference picture()
    - student   picture is 3-by-6
    - reference picture is 2-by-7

  * 5x6.png
    - failed after removing vertical seam[] = { 1, 2, 2, 3, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-5
    - reference picture is 4-by-6

  * 7x3.png

    java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6a(TestSeamCarver.java:1402)
    TestSeamCarver.main(TestSeamCarver.java:1885)

    - failed after removing vertical seam[] = { 2, 3, 2 }

  * 7x10.png
    - failed after removing vertical seam[] = { 2, 3, 4, 3, 4, 3, 3, 2, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 7-by-9
    - reference picture is 6-by-10

  * 12x10.png

    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6a(TestSeamCarver.java:1404)
    TestSeamCarver.main(TestSeamCarver.java:1885)

    - failed after removing vertical seam[] = { 6, 7, 7, 6, 6, 7, 7, 7, 8, 7 }

  * stripes.png
    - failed after removing vertical seam[] = { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
    - student picture() does not match reference picture()
    - student   picture is 9-by-11
    - reference picture is 8-by-12

  * diagonals.png
    - failed after removing vertical seam[] = { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
    - student picture() does not match reference picture()
    - student   picture is 9-by-11
    - reference picture is 8-by-12

  * chameleon.png

    java.lang.ArrayIndexOutOfBoundsException: Index 300 out of bounds for length 300

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6a(TestSeamCarver.java:1407)
    TestSeamCarver.main(TestSeamCarver.java:1885)

    - failed after removing vertical seam[] = [ suppresed (300 entries) ]

  * HJoceanSmall.png

    java.lang.ArrayIndexOutOfBoundsException: Index 285 out of bounds for length 285

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6a(TestSeamCarver.java:1408)
    TestSeamCarver.main(TestSeamCarver.java:1885)

    - failed after removing vertical seam[] = [ suppresed (285 entries) ]

  * 8x1.png

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeVerticalSeam(SeamCarver.java:201)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6a(TestSeamCarver.java:1409)
    TestSeamCarver.main(TestSeamCarver.java:1885)

    - failed after removing vertical seam[] = { 0 }

==> FAILED

Test 6b: check removeVerticalSeam() with random pictures and optimal seams
  * 100 random 4-by-6 pictures
    - failed after removing vertical seam[] = { 1, 2, 2, 2, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 4-by-5
    - reference picture is 3-by-6

    - failed on trial 1 of 100

  * 100 random 5-by-5 pictures
    - failed after removing vertical seam[] = { 1, 2, 3, 3, 2 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-4
    - reference picture is 4-by-5

    - failed on trial 1 of 100

  * 100 random 6-by-4 pictures

    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:762)
    TestSeamCarver.test6b(TestSeamCarver.java:1419)
    TestSeamCarver.main(TestSeamCarver.java:1888)

    - failed after removing vertical seam[] = { 0, 1, 2, 1 }

    - failed on trial 1 of 100

  * 100 random 7-by-10 pictures
    - failed after removing vertical seam[] = { 4, 5, 5, 5, 4, 4, 3, 3, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 7-by-9
    - reference picture is 6-by-10

    - failed on trial 1 of 100

  * 10 random 100-by-100 pictures
    - failed after removing vertical seam[] = [ suppresed (100 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 100-by-99
    - reference picture is 99-by-100

    - failed on trial 1 of 10

  * 2 random 250-by-250 pictures
    - failed after removing vertical seam[] = [ suppresed (250 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 250-by-249
    - reference picture is 249-by-250

    - failed on trial 1 of 2

==> FAILED

Test 6c: check removeVerticalSeam() with file inputs and random seams
  * 6x5.png

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6c(TestSeamCarver.java:1430)
    TestSeamCarver.main(TestSeamCarver.java:1891)

    - failed after removing vertical seam[] = { 1, 0, 0, 0, 1 }

  * 10x12.png
    - failed after removing vertical seam[] = { 4, 4, 4, 4, 5, 4, 3, 2, 1, 1, 2, 2 }
    - student picture() does not match reference picture()
    - student   picture is 10-by-11
    - reference picture is 9-by-12

  * 3x7.png
    - failed after removing vertical seam[] = { 2, 2, 2, 1, 2, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 3-by-6
    - reference picture is 2-by-7

  * 5x6.png
    - failed after removing vertical seam[] = { 3, 4, 4, 3, 4, 3 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-5
    - reference picture is 4-by-6

  * 7x3.png

    java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6c(TestSeamCarver.java:1434)
    TestSeamCarver.main(TestSeamCarver.java:1891)

    - failed after removing vertical seam[] = { 3, 3, 3 }

  * 7x10.png
    - failed after removing vertical seam[] = { 5, 6, 5, 4, 4, 3, 4, 4, 5, 6 }
    - student picture() does not match reference picture()
    - student   picture is 7-by-9
    - reference picture is 6-by-10

  * 12x10.png

    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6c(TestSeamCarver.java:1436)
    TestSeamCarver.main(TestSeamCarver.java:1891)

    - failed after removing vertical seam[] = { 5, 6, 7, 6, 6, 5, 4, 5, 4, 3 }

  * stripes.png
    - failed after removing vertical seam[] = { 4, 5, 5, 4, 3, 2, 3, 3, 3, 2, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 9-by-11
    - reference picture is 8-by-12

  * diagonals.png
    - failed after removing vertical seam[] = { 8, 8, 8, 8, 8, 7, 7, 6, 5, 6, 7, 6 }
    - student picture() does not match reference picture()
    - student   picture is 9-by-11
    - reference picture is 8-by-12

  * chameleon.png

    java.lang.ArrayIndexOutOfBoundsException: Index 300 out of bounds for length 300

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6c(TestSeamCarver.java:1439)
    TestSeamCarver.main(TestSeamCarver.java:1891)

    - failed after removing vertical seam[] = [ suppresed (300 entries) ]

  * HJoceanSmall.png

    java.lang.ArrayIndexOutOfBoundsException: Index 285 out of bounds for length 285

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6c(TestSeamCarver.java:1440)
    TestSeamCarver.main(TestSeamCarver.java:1891)

    - failed after removing vertical seam[] = [ suppresed (285 entries) ]

  * 8x1.png

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeVerticalSeam(SeamCarver.java:201)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6c(TestSeamCarver.java:1441)
    TestSeamCarver.main(TestSeamCarver.java:1891)

    - failed after removing vertical seam[] = { 0 }

==> FAILED

Test 6d: check removeVerticalSeam() with random pictures and random seams
  * 100 random 4-by-6 pictures
    - failed after removing vertical seam[] = { 2, 1, 1, 2, 3, 3 }
    - student picture() does not match reference picture()
    - student   picture is 4-by-5
    - reference picture is 3-by-6

    - failed on trial 1 of 100

  * 100 random 5-by-5 pictures
    - failed after removing vertical seam[] = { 4, 4, 3, 3, 4 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-4
    - reference picture is 4-by-5

    - failed on trial 1 of 100

  * 100 random 6-by-4 pictures

    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:762)
    TestSeamCarver.test6d(TestSeamCarver.java:1451)
    TestSeamCarver.main(TestSeamCarver.java:1894)

    - failed after removing vertical seam[] = { 2, 1, 2, 1 }

    - failed on trial 1 of 100

  * 100 random 7-by-10 pictures
    - failed after removing vertical seam[] = { 3, 3, 4, 5, 6, 6, 6, 6, 5, 4 }
    - student picture() does not match reference picture()
    - student   picture is 7-by-9
    - reference picture is 6-by-10

    - failed on trial 1 of 100

  * 10 random 100-by-100 pictures
    - failed after removing vertical seam[] = [ suppresed (100 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 100-by-99
    - reference picture is 99-by-100

    - failed on trial 1 of 10

  * 2 random 250-by-250 pictures
    - failed after removing vertical seam[] = [ suppresed (250 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 250-by-249
    - reference picture is 249-by-250

    - failed on trial 1 of 2

==> FAILED

Test 7a: check removeHorizontalSeam() with file inputs and optimal seams
  * 6x5.png
    - failed after removing horizontal seam[] = { 1, 2, 1, 2, 1, 0 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-5
    - reference picture is 6-by-4

  * 10x12.png

    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7a(TestSeamCarver.java:1462)
    TestSeamCarver.main(TestSeamCarver.java:1897)

    - failed after removing vertical seam[] = { 8, 9, 10, 10, 10, 9, 10, 10, 9, 8 }

  * 3x7.png

    java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7a(TestSeamCarver.java:1463)
    TestSeamCarver.main(TestSeamCarver.java:1897)

    - failed after removing vertical seam[] = { 1, 2, 1 }

  * 5x6.png

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7a(TestSeamCarver.java:1464)
    TestSeamCarver.main(TestSeamCarver.java:1897)

    - failed after removing vertical seam[] = { 2, 3, 2, 3, 2 }

  * 7x3.png
    - failed after removing horizontal seam[] = { 0, 1, 1, 1, 1, 1, 0 }
    - student picture() does not match reference picture()
    - student   picture is 6-by-3
    - reference picture is 7-by-2

  * 7x10.png

    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7a(TestSeamCarver.java:1466)
    TestSeamCarver.main(TestSeamCarver.java:1897)

    - failed after removing vertical seam[] = { 6, 7, 7, 7, 8, 8, 7 }

  * 12x10.png
    - failed after removing horizontal seam[] = { 7, 8, 7, 8, 7, 6, 5, 6, 6, 5, 4, 3 }
    - student picture() does not match reference picture()
    - student   picture is 11-by-10
    - reference picture is 12-by-9

  * stripes.png

    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7a(TestSeamCarver.java:1468)
    TestSeamCarver.main(TestSeamCarver.java:1897)

    - failed after removing vertical seam[] = { 0, 1, 1, 1, 1, 1, 1, 1, 0 }

  * diagonals.png

    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7a(TestSeamCarver.java:1469)
    TestSeamCarver.main(TestSeamCarver.java:1897)

    - failed after removing vertical seam[] = { 0, 1, 1, 1, 1, 1, 1, 1, 0 }

  * chameleon.png
    - failed after removing horizontal seam[] = [ suppresed (600 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 599-by-300
    - reference picture is 600-by-299

  * HJoceanSmall.png
    - failed after removing horizontal seam[] = [ suppresed (507 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 506-by-285
    - reference picture is 507-by-284

  * 1x8.png

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7a(TestSeamCarver.java:1472)
    TestSeamCarver.main(TestSeamCarver.java:1897)

    - failed after removing vertical seam[] = { 0 }

==> FAILED

Test 7b: check removeHorizontalSeam() with random pictures and optimal seams
  * 100 random 4-by-6 pictures

    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:746)
    TestSeamCarver.test7b(TestSeamCarver.java:1480)
    TestSeamCarver.main(TestSeamCarver.java:1900)

    - failed after removing vertical seam[] = { 3, 4, 3, 2 }

    - failed on trial 1 of 100

  * 100 random 5-by-5 pictures
    - failed after removing horizontal seam[] = { 1, 2, 3, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 4-by-5
    - reference picture is 5-by-4

    - failed on trial 1 of 100

  * 100 random 6-by-4 pictures
    - failed after removing horizontal seam[] = { 1, 2, 1, 2, 1, 0 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-4
    - reference picture is 6-by-3

    - failed on trial 1 of 100

  * 100 random 7-by-10 pictures

    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:746)
    TestSeamCarver.test7b(TestSeamCarver.java:1483)
    TestSeamCarver.main(TestSeamCarver.java:1900)

    - failed after removing vertical seam[] = { 3, 4, 5, 4, 3, 2, 1 }

    - failed on trial 1 of 100

  * 10 random 100-by-100 pictures
    - failed after removing horizontal seam[] = [ suppresed (100 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 99-by-100
    - reference picture is 100-by-99

    - failed on trial 1 of 10

  * 2 random 250-by-250 pictures
    - failed after removing horizontal seam[] = [ suppresed (250 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 249-by-250
    - reference picture is 250-by-249

    - failed on trial 1 of 2

==> FAILED

Test 7c: check removeHorizontalSeam() with file inputs and random seams
  * 6x5.png
    - failed after removing horizontal seam[] = { 4, 4, 4, 3, 4, 4 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-5
    - reference picture is 6-by-4

  * 10x12.png

    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7c(TestSeamCarver.java:1493)
    TestSeamCarver.main(TestSeamCarver.java:1903)

    - failed after removing vertical seam[] = { 2, 1, 0, 0, 0, 1, 1, 0, 0, 1 }

  * 3x7.png

    java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7c(TestSeamCarver.java:1494)
    TestSeamCarver.main(TestSeamCarver.java:1903)

    - failed after removing vertical seam[] = { 3, 2, 2 }

  * 5x6.png

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7c(TestSeamCarver.java:1495)
    TestSeamCarver.main(TestSeamCarver.java:1903)

    - failed after removing vertical seam[] = { 1, 0, 0, 1, 1 }

  * 7x3.png
    - failed after removing horizontal seam[] = { 0, 1, 0, 1, 2, 2, 1 }
    - student picture() does not match reference picture()
    - student   picture is 6-by-3
    - reference picture is 7-by-2

  * 7x10.png

    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7c(TestSeamCarver.java:1497)
    TestSeamCarver.main(TestSeamCarver.java:1903)

    - failed after removing vertical seam[] = { 9, 9, 9, 9, 8, 8, 8 }

  * 12x10.png
    - failed after removing horizontal seam[] = { 6, 7, 7, 8, 8, 9, 9, 8, 8, 8, 7, 7 }
    - student picture() does not match reference picture()
    - student   picture is 11-by-10
    - reference picture is 12-by-9

  * stripes.png

    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7c(TestSeamCarver.java:1499)
    TestSeamCarver.main(TestSeamCarver.java:1903)

    - failed after removing vertical seam[] = { 8, 8, 8, 7, 8, 8, 9, 10, 9 }

  * diagonals.png

    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7c(TestSeamCarver.java:1500)
    TestSeamCarver.main(TestSeamCarver.java:1903)

    - failed after removing vertical seam[] = { 0, 1, 1, 1, 1, 1, 1, 1, 0 }

  * chameleon.png
    - failed after removing horizontal seam[] = [ suppresed (600 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 599-by-300
    - reference picture is 600-by-299

  * HJoceanSmall.png
    - failed after removing horizontal seam[] = [ suppresed (507 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 506-by-285
    - reference picture is 507-by-284

  * 1x8.png

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:701)
    TestSeamCarver.test7c(TestSeamCarver.java:1503)
    TestSeamCarver.main(TestSeamCarver.java:1903)

    - failed after removing vertical seam[] = { 0 }

==> FAILED

Test 7d: check removeHorizontalSeam() with random pictures and random seams
  * 100 random 4-by-6 pictures

    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:746)
    TestSeamCarver.test7d(TestSeamCarver.java:1511)
    TestSeamCarver.main(TestSeamCarver.java:1906)

    - failed after removing vertical seam[] = { 3, 4, 5, 5 }

    - failed on trial 1 of 100

  * 100 random 5-by-5 pictures
    - failed after removing horizontal seam[] = { 3, 2, 2, 3, 2 }
    - student picture() does not match reference picture()
    - student   picture is 4-by-5
    - reference picture is 5-by-4

    - failed on trial 1 of 100

  * 100 random 6-by-4 pictures
    - failed after removing horizontal seam[] = { 3, 2, 2, 2, 2, 2 }
    - student picture() does not match reference picture()
    - student   picture is 5-by-4
    - reference picture is 6-by-3

    - failed on trial 1 of 100

  * 100 random 7-by-10 pictures

    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:718)
    TestSeamCarver.checkRemoveHorizontalSeam(TestSeamCarver.java:746)
    TestSeamCarver.test7d(TestSeamCarver.java:1514)
    TestSeamCarver.main(TestSeamCarver.java:1906)

    - failed after removing vertical seam[] = { 1, 2, 1, 0, 0, 1, 0 }

    - failed on trial 1 of 100

  * 10 random 100-by-100 pictures
    - failed after removing horizontal seam[] = [ suppresed (100 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 99-by-100
    - reference picture is 100-by-99

    - failed on trial 1 of 10

  * 2 random 250-by-250 pictures
    - failed after removing horizontal seam[] = [ suppresed (250 entries) ]
    - student picture() does not match reference picture()
    - student   picture is 249-by-250
    - reference picture is 250-by-249

    - failed on trial 1 of 2

==> FAILED

Test 8: check energy() with invalid arguments
  * picture = 6x5.png, call energy(-1, 4)
  * picture = 6x5.png, call energy(6, 4)
  * picture = 6x5.png, call energy(5, 5)
  * picture = 6x5.png, call energy(4, -1)
  * picture = 6x5.png, call energy(4, 5)
==> passed

Test 9a: check removeVerticalSeam() with invalid seam
  * picture = 10x10.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 9
    - invalid seam = { 12, 12, 12, 12, 12, 12, 11, 11, 12, 12 }
    - failed on trial 4 of 250

  * picture = 3x7.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 2
    - invalid seam = { 6, 5, 4, 4, 4, 4, 5 }
    - failed on trial 1 of 250

  * picture = 7x3.png
    - throws wrong exception when calling removeVerticalSeam()
      with an invalid seam
    - throws a java.lang.ArrayIndexOutOfBoundsException
    - should throw a java.lang.IllegalArgumentException
    - entry 0 is not between 0 and 6
    - invalid seam = { -1, 0, 0 }
    - failed on trial 2 of 250

  * picture = 10x12.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 9
    - invalid seam = { -1, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 1 }
    - failed on trial 1 of 250

  * picture = 12x10.png
    - throws wrong exception when calling removeVerticalSeam()
      with an invalid seam
    - throws a java.lang.ArrayIndexOutOfBoundsException
    - should throw a java.lang.IllegalArgumentException
    - entry 0 is not between 0 and 11
    - invalid seam = { 13, 13, 12, 12, 11, 12, 13, 12, 13, 13 }
    - failed on trial 6 of 250

  * picture = 1x8.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 0
    - invalid seam = { -1, 0, 0, 0, 0, 0, 0, 0 }
    - failed on trial 1 of 250

  * picture = 8x1.png
  * picture = 1x1.png
==> FAILED

Test 9b: check removeHorizontalSeam() with invalid seam
  * picture = 10x10.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 7 is not between 0 and 9
    - invalid seam = { 1, 2, 1, 2, 1, 0, 0, -1, -2, -2 }
    - failed on trial 4 of 250

  * picture = 3x7.png
    - throws wrong exception when calling removeHorizontalSeam()
      with an invalid seam
    - throws a java.lang.ArrayIndexOutOfBoundsException
    - should throw a java.lang.IllegalArgumentException
    - entry 0 is not between 0 and 6
    - invalid seam = { 9, 9, 9 }
    - failed on trial 1 of 250

  * picture = 7x3.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 2
    - invalid seam = { -1, 0, 0, 1, 0, 0, 1 }
    - failed on trial 1 of 250

  * picture = 10x12.png
    - throws wrong exception when calling removeHorizontalSeam()
      with an invalid seam
    - throws a java.lang.ArrayIndexOutOfBoundsException
    - should throw a java.lang.IllegalArgumentException
    - entry 0 is not between 0 and 11
    - invalid seam = { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14 }
    - failed on trial 2 of 250

  * picture = 12x10.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 9
    - invalid seam = { 11, 12, 11, 12, 13, 13, 14, 13, 14, 13, 13, 13 }
    - failed on trial 1 of 250

  * picture = 1x8.png
  * picture = 8x1.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 0
    - invalid seam = { -1, 0, 0, -1, 0, 0, 0, 0 }
    - failed on trial 1 of 250

  * picture = 1x1.png
==> FAILED

Test 9c: check removeHorizontalSeam() and removeVerticalSeam() with null arguments
  * picture = 6x5.png
  * picture = 3x7.png
==> passed

Test 10a: check that client can mutate the Picture object that is passed to the constructor
==> passed

Test 10b: check that client can mutate the Picture object that is returned by picture()
==> passed

Test 11: check constructor with null argument
==> passed

Test 12a: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with optimal seams and small images
  * 250 random 5-by-6 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12a(TestSeamCarver.java:1722)
    TestSeamCarver.main(TestSeamCarver.java:1930)

    - failed on image 1 of 250
    - failed on operation 1 of 5
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       5-by-6 picture (RGB values given in hex)
       #010704 #040808 #020107 #030506 #090501 
       #030504 #010502 #010407 #060102 #070505 
       #010705 #080502 #070604 #080104 #060100 
       #050600 #000801 #090101 #040400 #030401 
       #000405 #000303 #090503 #060503 #060206 
       #000606 #000002 #000609 #020506 #010602

      SeamCarver carver = new SeamCarver(picture)
      carver.removeHorizontalSeam([1, 2, 3, 2, 1])

  * 250 random 6-by-5 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1074)
    TestSeamCarver.test12a(TestSeamCarver.java:1723)
    TestSeamCarver.main(TestSeamCarver.java:1930)

    - failed on image 1 of 250
    - failed on operation 3 of 5
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-5 picture (RGB values given in hex)
       #010402 #050506 #070907 #090004 #050405 #070200 
       #010003 #060401 #060502 #040503 #010000 #090302 
       #050506 #050006 #020406 #030101 #080509 #030207 
       #000100 #090901 #080309 #030807 #040308 #020509 
       #090109 #080203 #020507 #020402 #060100 #070106

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.picture()
      carver.removeVerticalSeam([3, 4, 3, 3, 2])

  * 250 random 6-by-6 images with p = (0.0, 0.0, 0.3, 0.3, 0.1, 0.1, 0.1, 0.1)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:164)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12a(TestSeamCarver.java:1724)
    TestSeamCarver.main(TestSeamCarver.java:1930)

    - failed on image 1 of 250
    - failed on operation 2 of 5
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #060101 #050407 #030101 #070501 #070007 #080409 
       #060901 #000003 #070909 #030202 #090604 #010507 
       #090002 #010103 #020000 #000700 #060305 #000606 
       #090908 #010809 #060305 #000206 #070809 #070103 
       #070500 #030106 #040002 #050005 #070108 #050402 
       #050800 #070405 #080305 #050804 #030903 #020305

      SeamCarver carver = new SeamCarver(picture)
      carver.removeHorizontalSeam([0, 1, 1, 2, 1, 0])
      carver.removeHorizontalSeam([1, 2, 3, 2, 2, 1])

  * 250 random 6-by-6 images with p = (0.3, 0.0, 0.3, 0.0, 0.0, 0.0, 0.2, 0.2)
    - failed on image 2 of 250
    - failed on operation 5 of 5
    - energy(1, 2) returns wrong value
    - student   energy  = 12.449899597988733
    - reference energy  = 10.908712114635714
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #010708 #050109 #070309 #010805 #080304 #050803 
       #050704 #020600 #030304 #080409 #010309 #090600 
       #090404 #060808 #010503 #040903 #090701 #000007 
       #020500 #090806 #010502 #080908 #060601 #010603 
       #020301 #080308 #000202 #060900 #080808 #070606 
       #050103 #030605 #020402 #080007 #010302 #060708

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.findHorizontalSeam()
      carver.findHorizontalSeam()
      carver.removeHorizontalSeam([2, 3, 3, 3, 4, 3])
      carver.energy(col, row) for each col and row

  * 250 random 6-by-6 images with p = (0.0, 0.3, 0.0, 0.3, 0.0, 0.0, 0.2, 0.2)
    - failed on image 1 of 250
    - failed on operation 3 of 5
    - picture() returns wrong value
    - student   picture is 6-by-5
    - reference picture is 5-by-6
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #020300 #000002 #050404 #010605 #000506 #030704 
       #090908 #000008 #030705 #090409 #070803 #060303 
       #030204 #040202 #050006 #090702 #060701 #010404 
       #030508 #010009 #040703 #080001 #040705 #010504 
       #030303 #020204 #060900 #070707 #080504 #000606 
       #010403 #060307 #040004 #020305 #060007 #080403

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeVerticalSeam([0, 1, 1, 1, 1, 0])
      carver.picture()

  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
    - failed on image 1 of 250
    - failed on operation 2 of 5
    - picture() returns wrong value
    - student   picture is 5-by-6
    - reference picture is 6-by-5
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #040903 #070701 #000007 #030004 #080907 #020607 
       #050700 #070202 #020202 #080105 #070808 #020207 
       #030406 #090904 #030102 #040504 #010409 #080005 
       #070205 #050809 #040906 #030105 #010209 #000100 
       #030403 #080608 #070301 #010806 #060601 #080906 
       #080500 #080606 #080709 #020408 #030807 #010808

      SeamCarver carver = new SeamCarver(picture)
      carver.removeHorizontalSeam([3, 4, 4, 4, 4, 3])
      carver.picture()

  * 250 random 6-by-6 images with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:164)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12a(TestSeamCarver.java:1729)
    TestSeamCarver.main(TestSeamCarver.java:1930)

    - failed on image 2 of 250
    - failed on operation 2 of 5
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #010706 #010702 #020303 #010205 #030005 #030002 
       #010901 #060106 #070600 #030104 #020802 #080200 
       #060809 #070308 #010604 #080806 #060102 #050900 
       #000204 #090709 #030801 #040409 #090602 #070701 
       #040404 #030609 #000209 #020309 #080807 #070307 
       #050909 #080909 #010508 #050804 #040500 #050707

      SeamCarver carver = new SeamCarver(picture)
      carver.removeVerticalSeam([1, 2, 2, 2, 1, 0])
      carver.removeHorizontalSeam([1, 2, 2, 1, 0])

==> FAILED

Test 12b: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with optimal seams and medium images
  * 5 random 100-by-110 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 100

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12b(TestSeamCarver.java:1743)
    TestSeamCarver.main(TestSeamCarver.java:1933)

    - failed on image 1 of 5
    - failed on operation 2 of 100
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeHorizontalSeam()

  * 5 random 110-by-100 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 100

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1074)
    TestSeamCarver.test12b(TestSeamCarver.java:1744)
    TestSeamCarver.main(TestSeamCarver.java:1933)

    - failed on image 1 of 5
    - failed on operation 1 of 100
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.removeVerticalSeam()

  * 5 random 100-by-100 images with p = (0.0, 0.0, 0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
    - failed on image 1 of 5
    - failed on operation 2 of 100
    - picture() returns wrong value
    - student   picture is 99-by-100
    - reference picture is 100-by-99
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.removeHorizontalSeam()
      carver.picture()

  * 5 random 100-by-100 images with p = (0.3, 0.0, 0.3, 0.0, 0.0, 0.0, 0.2, 0.2)
    - failed on image 1 of 5
    - failed on operation 3 of 100
    - picture() returns wrong value
    - student   picture is 99-by-100
    - reference picture is 100-by-99
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeHorizontalSeam()
      carver.picture()

  * 5 random 100-by-100 images with p = (0.0, 0.3, 0.0, 0.3, 0.0, 0.0, 0.2, 0.2)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:164)
    SeamCarver.removeVerticalSeam(SeamCarver.java:201)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1074)
    TestSeamCarver.test12b(TestSeamCarver.java:1747)
    TestSeamCarver.main(TestSeamCarver.java:1933)

    - failed on image 1 of 5
    - failed on operation 3 of 100
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.energy(col, row) for each col and row
      carver.removeVerticalSeam()
      carver.removeVerticalSeam()

  * 5 random 100-by-100 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:164)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12b(TestSeamCarver.java:1748)
    TestSeamCarver.main(TestSeamCarver.java:1933)

    - failed on image 1 of 5
    - failed on operation 2 of 100
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.removeVerticalSeam()
      carver.removeHorizontalSeam()

  * 5 random 100-by-100 images with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
  * 5 random 100-by-100 images with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:164)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12b(TestSeamCarver.java:1750)
    TestSeamCarver.main(TestSeamCarver.java:1933)

    - failed on image 1 of 5
    - failed on operation 5 of 100
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.width()   ==> 100
      carver.findVerticalSeam()
      carver.height()  ==> 100
      carver.removeHorizontalSeam()
      carver.removeHorizontalSeam()

==> FAILED

Test 12c: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with random seams on small images
  * 250 random 5-by-6 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12c(TestSeamCarver.java:1765)
    TestSeamCarver.main(TestSeamCarver.java:1936)

    - failed on image 1 of 250
    - failed on operation 2 of 5
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       5-by-6 picture (RGB values given in hex)
       #080102 #080506 #000707 #030106 #090607 
       #030805 #010207 #050003 #090006 #070200 
       #060108 #000400 #070003 #090103 #010802 
       #000103 #060400 #090407 #050301 #000504 
       #020401 #040808 #050903 #010207 #060206 
       #040601 #080405 #010407 #020502 #000103

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeHorizontalSeam([3, 4, 3, 2, 1])

  * 250 random 6-by-5 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1074)
    TestSeamCarver.test12c(TestSeamCarver.java:1766)
    TestSeamCarver.main(TestSeamCarver.java:1936)

    - failed on image 1 of 250
    - failed on operation 2 of 5
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-5 picture (RGB values given in hex)
       #080909 #020607 #070405 #030401 #000903 #080900 
       #020100 #040505 #070704 #030205 #030300 #020605 
       #030907 #030104 #010204 #060606 #060201 #030108 
       #010504 #020006 #020604 #020104 #090407 #000702 
       #000708 #090101 #060806 #070300 #030801 #040103

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeVerticalSeam([5, 4, 5, 5, 5])

  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
    - length of student   seam = 5
    - length of reference seam = 6

    - failed on image 2 of 250
    - failed on operation 2 of 5
    - findHorizontalSeam() returns wrong seam
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #030005 #040901 #020303 #010702 #020807 #030300 
       #090206 #050505 #090908 #000202 #000501 #030709 
       #030909 #040101 #000104 #020502 #010101 #010504 
       #010602 #010301 #060004 #030701 #070207 #050608 
       #000309 #060302 #050008 #060409 #030205 #060305 
       #070506 #070005 #050100 #040702 #010803 #000604

      SeamCarver carver = new SeamCarver(picture)
      carver.removeHorizontalSeam([5, 5, 5, 4, 5, 4])
      carver.findHorizontalSeam()

  * 250 random 6-by-6 images with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)
    - length of student   seam = 6
    - length of reference seam = 5

    - failed on image 1 of 250
    - failed on operation 3 of 5
    - findVerticalSeam() returns wrong seam
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #060106 #040901 #070507 #090707 #020609 #040609 
       #050300 #080209 #090002 #090105 #040103 #030402 
       #060606 #050303 #010408 #040202 #070304 #050107 
       #050402 #010709 #050401 #030907 #080008 #070100 
       #070305 #050103 #050406 #040402 #060008 #040500 
       #010803 #050404 #020504 #020704 #060202 #070408

      SeamCarver carver = new SeamCarver(picture)
      carver.findHorizontalSeam()
      carver.removeHorizontalSeam([3, 2, 1, 2, 2, 3])
      carver.findVerticalSeam()

==> FAILED

Test 12d: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with random seams on medium images
  * 10 random 100-by-110 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 100

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:196)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12d(TestSeamCarver.java:1784)
    TestSeamCarver.main(TestSeamCarver.java:1939)

    - failed on image 1 of 10
    - failed on operation 1 of 100
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.removeHorizontalSeam()

  * 10 random 110-by-100 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)

    java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 100

    SeamCarver.removeSeam(SeamCarver.java:185)
    SeamCarver.removeVerticalSeam(SeamCarver.java:202)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1074)
    TestSeamCarver.test12d(TestSeamCarver.java:1785)
    TestSeamCarver.main(TestSeamCarver.java:1939)

    - failed on image 1 of 10
    - failed on operation 3 of 100
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.picture()
      carver.removeVerticalSeam()

  * 10 random 110-by-110 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
    - failed on image 1 of 10
    - failed on operation 3 of 100
    - picture() returns wrong value
    - student   picture is 110-by-109
    - reference picture is 109-by-110
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeVerticalSeam()
      carver.picture()

  * 10 random 100-by-100 images with p = (0.2, 0.2, 0.0, 0.0, 0.1, 0.1, 0.2, 0.2)
  * 10 random 110-by-110 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)
    - failed on image 1 of 10
    - failed on operation 4 of 100
    - height() returns wrong value
    - student   height() = 109
    - reference height() = 110
    - sequence of operations was:
      SeamCarver carver = new SeamCarver(picture)
      carver.findHorizontalSeam()
      carver.energy(col, row) for each col and row
      carver.removeVerticalSeam()
      carver.height()  ==> 109

==> FAILED

Test 12e: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with optimal seams
          (tests corner cases when width = 1 or 2 and/or height = 1 or 2)
  * 50 random 1-by-8 images with p = (0.1, 0.1, 0.2, 0.0, 0.1, 0.1, 0.2, 0.2)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12e(TestSeamCarver.java:1806)
    TestSeamCarver.main(TestSeamCarver.java:1942)

    - failed on image 1 of 50
    - failed on operation 3 of 100
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       1-by-8 picture (RGB values given in hex)
       #070403 
       #040508 
       #020105 
       #070200 
       #060705 
       #090701 
       #070405 
       #040809

      SeamCarver carver = new SeamCarver(picture)
      carver.energy(col, row) for each col and row
      carver.width()   ==> 1
      carver.removeHorizontalSeam([0])

  * 50 random 8-by-1 images with p = (0.1, 0.1, 0.0, 0.2, 0.1, 0.1, 0.2, 0.2)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeVerticalSeam(SeamCarver.java:201)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1074)
    TestSeamCarver.test12e(TestSeamCarver.java:1807)
    TestSeamCarver.main(TestSeamCarver.java:1942)

    - failed on image 1 of 50
    - failed on operation 1 of 100
    - sequence of operations was:
      Picture pi

...

WARNING: the grading output was truncated due to excessive length.
Typically, this is because you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception). A large amount of output
can also arise from failing many tests.
```
