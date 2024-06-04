#!/bin/sh

FOLDER=queues

rm Deque.java
rm RandomizedQueue.java
rm Permutation.java
cp ../../../$FOLDER/Deque.java .
cp ../../../$FOLDER/RandomizedQueue.java .
cp ../../../$FOLDER/Permutation.java .

sed -i '' '/^package/d' Deque.java
sed -i '' '/^package/d' RandomizedQueue.java
sed -i '' '/^package/d' Permutation.java

SUBMISSION_FN=queues.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN Deque.java RandomizedQueue.java Permutation.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
