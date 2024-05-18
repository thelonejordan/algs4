#!/bin/sh

SUBMISSION_FN=8puzzle.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN Board.java Solver.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
