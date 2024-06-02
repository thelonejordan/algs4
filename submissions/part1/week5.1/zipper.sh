#!/bin/sh

SUBMISSION_FN=kdtree.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN PointSET.java KdTree.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
