#!/bin/sh

FOLDER=kdtrees

rm PointSET.java
rm KdTree.java
cp ../../../$FOLDER/PointSET.java .
cp ../../../$FOLDER/KdTree.java .

sed -i '' '/^package/d' PointSET.java
sed -i '' '/^package/d' KdTree.java

SUBMISSION_FN=kdtree.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN PointSET.java KdTree.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
