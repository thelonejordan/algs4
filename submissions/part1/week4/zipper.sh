#!/bin/sh

FOLDER=eightpuzzle

rm Board.java
rm Solver.java
cp ../../../$FOLDER/Board.java .
cp ../../../$FOLDER/Solver.java .

sed -i '' '/^package/d' Board.java
sed -i '' '/^package/d' Solver.java

SUBMISSION_FN=8puzzle.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN Board.java Solver.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
