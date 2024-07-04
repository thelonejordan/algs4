See the Assessment Guide for information on how to interpret this report.

## ASSESSMENT SUMMARY

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     PASSED
PMD:          PASSED
Checkstyle:   PASSED

Correctness:  31/34 tests passed
Memory:       6/6 tests passed
Timing:       18/17 tests passed

Aggregate score: 95.88%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]
```

## ASSESSMENT DETAILS

```
The following files were submitted:
----------------------------------
7.3K Jul  4 09:17 SeamCarver.java


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
==> passed

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
==> passed

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
==> passed

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
==> passed

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
    - entry 3 is not between 0 and 9
    - invalid seam = { 9, 8, 9, 10, 9, 9, 9, 8, 8, 7 }
    - failed on trial 1 of 250

  * picture = 3x7.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 2
    - invalid seam = { 6, 5, 5, 5, 5, 5, 5 }
    - failed on trial 1 of 250

  * picture = 7x3.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 2 is not between 0 and 6
    - invalid seam = { 5, 6, 7 }
    - failed on trial 3 of 250

  * picture = 10x12.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 1 is not between 0 and 9
    - invalid seam = { 0, -1, 0, 1, 2, 2, 2, 3, 2, 3, 2, 3 }
    - failed on trial 4 of 250

  * picture = 12x10.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 1 is not between 0 and 11
    - invalid seam = { 11, 12, 12, 12, 13, 13, 13, 12, 12, 12 }
    - failed on trial 1 of 250

  * picture = 1x8.png
  * picture = 8x1.png
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 7
    - invalid seam = { 10 }
    - failed on trial 1 of 250

  * picture = 1x1.png
==> FAILED

Test 9b: check removeHorizontalSeam() with invalid seam
  * picture = 10x10.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 9
    - invalid seam = { 13, 13, 14, 13, 14, 13, 13, 12, 13, 12 }
    - failed on trial 1 of 250

  * picture = 3x7.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 6
    - invalid seam = { -1, 0, 1 }
    - failed on trial 1 of 250

  * picture = 7x3.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 2 is not between 0 and 2
    - invalid seam = { 2, 2, 3, 2, 2, 3, 3 }
    - failed on trial 2 of 250

  * picture = 10x12.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 8 is not between 0 and 11
    - invalid seam = { 10, 9, 9, 9, 10, 10, 10, 11, 12, 12 }
    - failed on trial 1 of 250

  * picture = 12x10.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 9
    - invalid seam = { -1, -2, -2, -1, 0, -1, -2, -1, -1, -1, -1, -2 }
    - failed on trial 1 of 250

  * picture = 1x8.png
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 7
    - invalid seam = { -1 }
    - failed on trial 1 of 250

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
  * 50 random 8-by-1 images with p = (0.1, 0.1, 0.0, 0.2, 0.1, 0.1, 0.2, 0.2)
  * 50 random 1-by-1 images with p = (0.2, 0.2, 0.0, 0.0, 0.1, 0.1, 0.2, 0.2)
  * 50 random 2-by-8 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 50 random 8-by-2 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 50 random 2-by-2 images with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)
==> passed

Test 12f: check intermixed calls to removeHorizontalSeam(), and removeVerticalSeam(),
          and picture(), with optimal or invalid seams on small images
  * 250 random 5-by-6 images with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
    - failed on image 2 of 250
    - failed on operation 5 of 5
    - fails to throw an exception when calling removeHorizontalSeam()
      with an invalid seam
    - entry 0 is not between 0 and 4
    - invalid seam = { -1, 0, 1, 0, 1 }
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       5-by-6 picture (RGB values given in hex)
       #060206 #080309 #080407 #090906 #070308 
       #050802 #070007 #070403 #040800 #020409 
       #040801 #040107 #050506 #090903 #040005 
       #070802 #080402 #080203 #060801 #050802 
       #050603 #080709 #040300 #080503 #040307 
       #070106 #040804 #020006 #040500 #080203

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.picture()
      carver.picture()
      carver.removeHorizontalSeam([3, 4, 3, 2, 1])
      carver.removeHorizontalSeam([-1, 0, 1, 0, 1])

  * 250 random 6-by-5 images with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
    - failed on image 1 of 250
    - failed on operation 5 of 5
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 4 is not between 0 and 4
    - invalid seam = { 2, 3, 4, 4, 5 }
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-5 picture (RGB values given in hex)
       #060103 #050304 #020504 #090908 #080807 #090000 
       #030908 #030007 #030609 #060406 #090002 #030002 
       #060404 #080501 #090203 #050305 #060409 #040508 
       #010207 #070807 #030101 #020005 #080503 #070808 
       #080409 #030602 #080901 #030203 #080501 #060103

      SeamCarver carver = new SeamCarver(picture)
      carver.picture()
      carver.removeVerticalSeam([3, 4, 4, 3, 2])
      carver.picture()
      carver.picture()
      carver.removeVerticalSeam([2, 3, 4, 4, 5])

  * 250 random 6-by-6 images with p = (0.0, 0.0, 0.3, 0.3, 0.0, 0.0, 0.0, 0.4)
    - failed on image 1 of 250
    - failed on operation 1 of 5
    - fails to throw an exception when calling removeVerticalSeam()
      with an invalid seam
    - entry 5 is not between 0 and 5
    - invalid seam = { 3, 4, 5, 5, 5, 6 }
    - sequence of operations was:
      Picture picture = new Picture(...)
      
       6-by-6 picture (RGB values given in hex)
       #060708 #040600 #020207 #050804 #040807 #050909 
       #090103 #010500 #060101 #050306 #010100 #050405 
       #090703 #060805 #090508 #080109 #040308 #020108 
       #000502 #020006 #070002 #060303 #020407 #090808 
       #050500 #070409 #070207 #040908 #000007 #030602 
       #020703 #000905 #030802 #000503 #000405 #050106

      SeamCarver carver = new SeamCarver(picture)
      carver.removeVerticalSeam([3, 4, 5, 5, 5, 6])

==> FAILED


Total: 31/34 tests passed!


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
  * student   solution calls per second:      18.89
  * reference solution calls per second:      54.37
  * reference / student ratio:                 2.88

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   4.5x reference

Tests 4a-4c: time findVerticalSeam() and removeVerticalSeam()
             for a given 736-by-584 picture
  * student   solution calls per second:       8.83
  * reference solution calls per second:      10.65
  * reference / student ratio:                 1.21

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   2.3x reference

Tests 5a-5c: time removeHorizontalSeam() for a given 736-by-584 picture
  * student   solution calls per second:      68.39
  * reference solution calls per second:      18.90
  * reference / student ratio:                 0.28

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   4.5x reference

Tests 6a-6c: time findHorizontalSeam() and removeHorizontalSeam()
             for a given 736-by-584 picture
  * student   solution calls per second:      16.48
  * reference solution calls per second:       6.62
  * reference / student ratio:                 0.40

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   2.3x reference

Tests 7a-7c: time findHorizontalSeam(), removeHorizontalSeam(), findVerticalSeam(),
             and removeVerticalSeam() for a given 736-by-584 picture
  * student   solution calls per second:       5.88
  * reference solution calls per second:       4.23
  * reference / student ratio:                 0.72

=> passed      student <= 150.0x reference
=> passed      student <=  15.0x reference
=> passed      student <=   1.5x reference
=> optimized   student <=   0.8x reference

Total: 18/17 tests passed!


================================================================
```
