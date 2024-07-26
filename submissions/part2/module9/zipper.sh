#!/bin/sh

FOLDER=boggle

rm BoggleSolver.java
cp ../../../$FOLDER/BoggleSolver.java .

sed -i '' '/^package/d' BoggleSolver.java

SUBMISSION_FN=boggle.zip

zip $SUBMISSION_FN BoggleSolver.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
