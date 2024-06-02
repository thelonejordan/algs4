#!/bin/sh

SUBMISSION_FN=percolation.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN Percolation.java PercolationStats.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
