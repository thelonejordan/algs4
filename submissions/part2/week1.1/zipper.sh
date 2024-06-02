#!/bin/sh

SUBMISSION_FN=wordnet.zip

zip $SUBMISSION_FN WordNet.java SAP.java Outcast.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
