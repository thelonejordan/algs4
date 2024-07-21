#!/bin/sh

FOLDER=baseball

rm BaseballElimination.java
cp ../../../$FOLDER/BaseballElimination.java .

sed -i '' '/^package/d' BaseballElimination.java

SUBMISSION_FN=baseball.zip

zip $SUBMISSION_FN BaseballElimination.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
