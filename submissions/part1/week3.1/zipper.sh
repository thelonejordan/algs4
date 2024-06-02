#!/bin/sh

SUBMISSION_FN=collinear.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN BruteCollinearPoints.java FastCollinearPoints.java Point.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
