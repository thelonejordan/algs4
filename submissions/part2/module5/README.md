See the Assessment Guide for information on how to interpret this report.

## ASSESSMENT SUMMARY

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     PASSED
PMD:          PASSED
Checkstyle:   PASSED

Correctness:  26/34 tests passed
Memory:       6/6 tests passed
Timing:       18/17 tests passed

Aggregate score: 87.06%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
```

## ASSESSMENT DETAILS

```
The following files were submitted:
----------------------------------
7.3K Jul  4 08:50 SeamCarver.java


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
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 6c: check removeVerticalSeam() with file inputs and random seams
  * 6x5.png
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
  * 8x1.png

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeVerticalSeam(SeamCarver.java:201)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:674)
    TestSeamCarver.checkRemoveVerticalSeam(TestSeamCarver.java:657)
    TestSeamCarver.test6c(TestSeamCarver.java:1441)
    TestSeamCarver.main(TestSeamCarver.java:1891)

    - failed after removing vertical seam[] = { 5 }

==> FAILED

Test 6d: check removeVerticalSeam() with random pictures and random seams
  * 100 random 4-by-6 pictures
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 7a: check removeHorizontalSeam() with file inputs and optimal seams
  * 6x5.png
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
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

Test 7c: check removeHorizontalSeam() with file inputs and random seams
  * 6x5.png
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
  * 100 random 5-by-5 pictures
  * 100 random 6-by-4 pictures
  * 100 random 7-by-10 pictures
  * 10 random 100-by-100 pictures
  * 2 random 250-by-250 pictures
==> passed

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
    - invalid seam = { -1, 0, 1, 2, 1, 0, 0, 1, 1, 1 }
    - failed on trial 1 of 250

  * picture = 3x7.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 2
    - invalid seam = { -1, 0, 0, 0, 1, 2, 2 }
    - failed on trial 1 of 250

  * picture = 7x3.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 6
    - invalid seam = { -2, -1, -2 }
    - failed on trial 3 of 250

  * picture = 10x12.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 5 is not between 0 and 9
    - invalid seam = { 7, 6, 7, 8, 9, 10, 10, 11, 12, 13, 12, 12 }
    - failed on trial 4 of 250

  * picture = 12x10.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 7 is not between 0 and 11
    - invalid seam = { 1, 0, 0, 0, 1, 1, 0, -1, -2, -2 }
    - failed on trial 3 of 250

  * picture = 1x8.png
  * picture = 8x1.png
  * picture = 1x1.png
==> FAILED

Test 9b: check removeHorizontalSeam() with invalid seam
  * picture = 10x10.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 9
    - invalid seam = { 10, 10, 9, 9, 10, 9, 9, 10, 9, 10 }
    - failed on trial 2 of 250

  * picture = 3x7.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 1 is not between 0 and 6
    - invalid seam = { 6, 7, 6 }
    - failed on trial 1 of 250

  * picture = 7x3.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 2
    - invalid seam = { -1, 0, 1, 0, 1, 0, 1 }
    - failed on trial 1 of 250

  * picture = 10x12.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 1 is not between 0 and 11
    - invalid seam = { 11, 12, 12, 12, 12, 11, 10, 9, 10, 11 }
    - failed on trial 6 of 250

  * picture = 12x10.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 8 is not between 0 and 9
    - invalid seam = { 9, 8, 8, 9, 8, 7, 8, 9, 10, 9, 10, 10 }
    - failed on trial 1 of 250

  * picture = 1x8.png
  * picture = 8x1.png
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
  * 250 random 6-by-5 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
  * 250 random 6-by-6 images with p = (0.0, 0.0, 0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  * 250 random 6-by-6 images with p = (0.3, 0.0, 0.3, 0.0, 0.0, 0.0, 0.2, 0.2)
  * 250 random 6-by-6 images with p = (0.0, 0.3, 0.0, 0.3, 0.0, 0.0, 0.2, 0.2)
  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
  * 250 random 6-by-6 images with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)
==> passed

Test 12b: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with optimal seams and medium images
  * 5 random 100-by-110 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
  * 5 random 110-by-100 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
  * 5 random 100-by-100 images with p = (0.0, 0.0, 0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  * 5 random 100-by-100 images with p = (0.3, 0.0, 0.3, 0.0, 0.0, 0.0, 0.2, 0.2)
  * 5 random 100-by-100 images with p = (0.0, 0.3, 0.0, 0.3, 0.0, 0.0, 0.2, 0.2)
  * 5 random 100-by-100 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
  * 5 random 100-by-100 images with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
  * 5 random 100-by-100 images with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)
==> passed

Test 12c: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with random seams on small images
  * 250 random 5-by-6 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
  * 250 random 6-by-5 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
  * 250 random 6-by-6 images with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
  * 250 random 6-by-6 images with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)
==> passed

Test 12d: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
          removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
          energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
          p6, p7, and p8, respectively with random seams on medium images
  * 10 random 100-by-110 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
  * 10 random 110-by-100 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
  * 10 random 110-by-110 images with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
  * 10 random 100-by-100 images with p = (0.2, 0.2, 0.0, 0.0, 0.1, 0.1, 0.2, 0.2)
  * 10 random 110-by-110 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)
==> passed

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
    - failed on operation 1 of 100
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       1-by-8 picture (RGB values given in hex)
       #090905 
       #090606 
       #090409 
       #080005 
       #070502 
       #020807 
       #010503 
       #060107

      SeamCarver carver = new SeamCarver(picture)
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
      Picture picture = new Picture(...)
      
       8-by-1 picture (RGB values given in hex)
       #010200 #080800 #040207 #060601 #000408 #060203 #070400 #080609

      SeamCarver carver = new SeamCarver(picture)
      carver.removeVerticalSeam([0])

  * 50 random 1-by-1 images with p = (0.2, 0.2, 0.0, 0.0, 0.1, 0.1, 0.2, 0.2)
  * 50 random 2-by-8 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12e(TestSeamCarver.java:1809)
    TestSeamCarver.main(TestSeamCarver.java:1942)

    - failed on image 1 of 50
    - failed on operation 23 of 100

  * 50 random 8-by-2 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeVerticalSeam(SeamCarver.java:201)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1074)
    TestSeamCarver.test12e(TestSeamCarver.java:1810)
    TestSeamCarver.main(TestSeamCarver.java:1942)

    - failed on image 1 of 50
    - failed on operation 17 of 100
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       8-by-2 picture (RGB values given in hex)
       #030908 #060800 #030809 #010105 #060100 #030800 #020706 #070201 
       #010802 #070102 #050309 #000408 #060303 #060204 #080205 #040300

      SeamCarver carver = new SeamCarver(picture)
      carver.findVerticalSeam()
      carver.height()  ==> 2
      carver.removeVerticalSeam([0, 0])
      carver.width()   ==> 7
      carver.removeVerticalSeam([0, 0])
      carver.height()  ==> 2
      carver.removeHorizontalSeam([0, 0, 0, 0, 0, 0])
      carver.energy(col, row) for each col and row
      carver.picture()
      carver.width()   ==> 6
      carver.height()  ==> 1
      carver.energy(col, row) for each col and row
      carver.findVerticalSeam()
      carver.energy(col, row) for each col and row
      carver.width()   ==> 6
      carver.findHorizontalSeam()
      carver.removeVerticalSeam([0])

  * 50 random 2-by-2 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)

    java.lang.IllegalArgumentException

    SeamCarver.validateSeam(SeamCarver.java:163)
    SeamCarver.removeHorizontalSeam(SeamCarver.java:195)
    TestSeamCarver.checkRandomIntermixedCalls(TestSeamCarver.java:1015)
    TestSeamCarver.test12e(TestSeamCarver.java:1811)
    TestSeamCarver.main(TestSeamCarver.java:1942)

    - failed on image 1 of 50
    - failed on operation 2 of 100
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       2-by-2 picture (RGB values given in hex)
       #010905 #080203 
       #040906 #010202

      SeamCarver carver = new SeamCarver(picture)
      carver.removeVerticalSeam([0, 0])
      carver.removeHorizontalSeam([0])

==> FAILED

Test 12f: check intermixed calls to removeHorizontalSeam(), and removeVerticalSeam(),
          and picture(), with optimal or invalid seams on small images
  * 250 random 5-by-6 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
    - failed on image 1 of 250
    - failed on operation 1 of 5
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 5
    - invalid seam = { -1, 0, 1, 2, 1 }
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       5-by-6 picture (RGB values given in hex)
       #090309 #040003 #020604 #010505 #030803 
       #010706 #010905 #020704 #090204 #030305 
       #020209 #040409 #030207 #050602 #080408 
       #090402 #030806 #060203 #080202 #010101 
       #070302 #020406 #040103 #070100 #040100 
       #040707 #060107 #040008 #080302 #050909

      SeamCarver carver = new SeamCarver(picture)
      carver.removeHorizontalSeam([-1, 0, 1, 2, 1])

  * 250 random 6-by-5 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
    - failed on image 5 of 250
    - failed on operation 1 of 5
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 5
    - invalid seam = { 6, 5, 5, 5, 6 }
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-5 picture (RGB values given in hex)
       #050806 #010006 #040303 #060906 #040808 #050200 
       #020802 #060906 #010807 #020402 #040508 #050108 
       #020903 #080908 #000209 #010707 #080101 #020109 
       #050804 #050103 #060607 #070809 #080407 #000609 
       #060907 #060503 #000304 #000408 #040205 #060606

      SeamCarver carver = new SeamCarver(picture)
      carver.removeVerticalSeam([6, 5, 5, 5, 6])

  * 250 random 6-by-6 images with p = (0.0, 0.0, 0.3, 0.3, 0.0, 0.0, 0.0, 0.4)
    - failed on image 2 of 250
    - failed on operation 2 of 5
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 5
    - invalid seam = { -1, 0, 1, 2, 3, 3 }
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #050308 #030707 #030908 #020409 #060709 #020604 
       #060509 #020703 #060904 #070605 #070604 #090400 
       #000000 #000706 #030007 #020709 #010309 #080205 
       #090608 #050705 #020908 #020404 #080307 #000907 
       #090000 #040007 #010102 #060505 #060509 #050109 
       #070201 #040808 #090507 #080509 #080303 #020902

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeVerticalSeam([-1, 0, 1, 2, 3, 3])

==> FAILED


Total: 26/34 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of SeamCarver
*-----------------------------------------------------------
Running 6 total tests.

Memory usage of a SeamCarver after removing 2 horizontal
and 2 vertical seams from an n-by-n image.

Maximum allowed memory is ~ 12 n^2 bytes.

                 n       student (bytes)
-------------------------------------------
=> passed       16         2352
=> passed       32         5168
=> passed       64        16944
=> passed      128        65080
=> passed      256       259640
=> passed      512      1041976
==> 6/6 tests passed

Total: 6/6 tests passed!

Estimated student memory (bytes) = 4.00 n^2 - 15.93 n + 1582.28   (R^2 = 1.000)

================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing SeamCarver
*-----------------------------------------------------------
Reference solution is unoptimized.

Running 17 total tests.

Test 1: create a SeamCarver object for a given 736-by-584 picture;
        then call findHorizontalSeam(), removeHorizontalSeam(),
        findVerticalSeam(), removeVerticalSeam(), and picture()
        one each; count total number of calls to methods in Picture
  * constructor calls        = 7
  * get()    calls per pixel = 0.0
  * set()    calls per pixel = 0.0
  * getRGB() calls per pixel = 12.9
  * setRGB() calls per pixel = 5.0
==> passed

Test 2: create a SeamCarver object for a given 736-by-584 picture;
        then call findHorizontalSeam(), removeHorizontalSeam(),
        findVerticalSeam(), and removeVerticalSeam(), and picture();
        once each; count total number of calls to methods in Color
  * constructor calls per pixel = 0.0
  * getRed()    calls per pixel = 0.0
  * getGreen()  calls per pixel = 0.0
  * getBlue()   calls per pixel = 0.0
  * getRGB()    calls per pixel = 0.0
  * equal number of calls to getRed(), getGreen(), and getBlue()
==> passed

Tests 3a-3c: time removeVerticalSeam() for a given 736-by-584 picture
  * student   solution calls per second:      19.77
  * reference solution calls per second:      62.25
  * reference / student ratio:                 3.15

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   4.5x reference

Tests 4a-4c: time findVerticalSeam() and removeVerticalSeam()
             for a given 736-by-584 picture
  * student   solution calls per second:       9.25
  * reference solution calls per second:      10.35
  * reference / student ratio:                 1.12

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   2.3x reference

Tests 5a-5c: time removeHorizontalSeam() for a given 736-by-584 picture
  * student   solution calls per second:      60.66
  * reference solution calls per second:      18.32
  * reference / student ratio:                 0.30

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   4.5x reference

Tests 6a-6c: time findHorizontalSeam() and removeHorizontalSeam()
             for a given 736-by-584 picture
  * student   solution calls per second:      16.23
  * reference solution calls per second:       6.56
  * reference / student ratio:                 0.40

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   2.3x reference

Tests 7a-7c: time findHorizontalSeam(), removeHorizontalSeam(), findVerticalSeam(),
             and removeVerticalSeam() for a given 736-by-584 picture
  * student   solution calls per second:       6.04
  * reference solution calls per second:       4.05
  * reference / student ratio:                 0.67

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   1.5x reference
=> optimized   student <=   0.8x reference

Total: 18/17 tests passed!


================================================================
```
