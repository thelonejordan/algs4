#!/bin/sh

FOLDER=burrowswheeler

rm MoveToFront.java
rm CircularSuffixArray.java
rm BurrowsWheeler.java
cp ../../../$FOLDER/MoveToFront.java .
cp ../../../$FOLDER/CircularSuffixArray.java .
cp ../../../$FOLDER/BurrowsWheeler.java .

sed -i '' '/^package/d' MoveToFront.java
sed -i '' '/^package/d' CircularSuffixArray.java
sed -i '' '/^package/d' BurrowsWheeler.java

SUBMISSION_FN=burrows.zip

zip $SUBMISSION_FN MoveToFront.java CircularSuffixArray.java BurrowsWheeler.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
