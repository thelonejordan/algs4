#!/bin/sh

FOLDER=percolation

rm Percolation.java
rm PercolationStats.java
cp ../../../$FOLDER/Percolation.java .
cp ../../../$FOLDER/PercolationStats.java .

sed -i '' '/^package/d' Percolation.java
sed -i '' '/^package/d' PercolationStats.java

SUBMISSION_FN=percolation.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN Percolation.java PercolationStats.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
