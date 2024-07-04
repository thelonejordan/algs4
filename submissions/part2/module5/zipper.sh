#!/bin/sh

FOLDER=seamcarving

rm SeamCarver.java
cp ../../../$FOLDER/SeamCarver.java .

sed -i '' '/^package/d' SeamCarver.java

SUBMISSION_FN=seam.zip

zip $SUBMISSION_FN SeamCarver.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
