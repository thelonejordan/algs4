#!/bin/sh

SUBMISSION_FN=hello.zip

zip $SUBMISSION_FN HelloWorld.java HelloGoodbye.java
rm $HOME/Downloads/$SUBMISSION_FN
cp hello.zip $HOME/Downloads
