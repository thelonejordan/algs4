#!/bin/sh

SUBMISSION_FN=queues.zip

rm $SUBMISSION_FN
zip $SUBMISSION_FN Deque.java RandomizedQueue.java Permutation.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
