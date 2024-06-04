#!/bin/sh

FOLDER=hello

rm HelloWorld.java
rm HelloGoodbye.java
cp ../../../$FOLDER/HelloWorld.java .
cp ../../../$FOLDER/HelloGoodbye.java .

sed -i '' '/^package/d' HelloWorld.java
sed -i '' '/^package/d' HelloGoodbye.java

SUBMISSION_FN=hello.zip

zip $SUBMISSION_FN HelloWorld.java HelloGoodbye.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
