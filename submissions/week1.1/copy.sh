#!/bin/sh

FOLDER=hello

rm HelloWorld.java
rm HelloGoodbye.java
cp ../../$FOLDER/HelloWorld.java .
cp ../../$FOLDER/HelloGoodbye.java .
