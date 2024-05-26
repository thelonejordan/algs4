See the Assessment Guide for information on how to interpret this report.

## ASSESSMENT SUMMARY

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     PASSED
PMD:          PASSED
Checkstyle:   FAILED (1 error, 1 warning)

Correctness:  No tests available for autograding.
Memory:       No tests available for autograding.
Timing:       No tests available for autograding.

Aggregate score: 10.00%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 90% ]
```

## ASSESSMENT DETAILS

```
The following files were submitted:
----------------------------------
2.0K May 26 18:38 KdTree.java
2.8K May 26 18:38 PointSET.java


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


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] KdTree.java:4:8: Unused import statement for 'edu.princeton.cs.algs4.SET'. [UnusedImports]
Checkstyle ends with 0 errors and 1 warning.

% custom checkstyle checks for PointSET.java
*-----------------------------------------------------------

% custom checkstyle checks for KdTree.java
*-----------------------------------------------------------
Checkstyle ends with 1 errors.
[ERROR] KdTree.java:1: You must declare a nested class to represent kd-tree nodes. [Design]
Checkstyle ends with 1 error and 0 warnings.


================================================================


ABORTING: you must fix any Checkstyle errors (not warnings).
```
