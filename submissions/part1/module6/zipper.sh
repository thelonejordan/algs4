#!/bin/sh

FOLDER=collinear

rm BruteCollinearPoints.java
rm FastCollinearPoints.java
rm Point.java
cp ../../../$FOLDER/BruteCollinearPoints.java .
cp ../../../$FOLDER/FastCollinearPoints.java .
cp ../../../$FOLDER/Point.java .

sed -i '' '/^package/d' BruteCollinearPoints.java
sed -i '' '/^package/d' FastCollinearPoints.java
sed -i '' '/^package/d' Point.java

SUBMISSION_FN=collinear.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN BruteCollinearPoints.java FastCollinearPoints.java Point.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
