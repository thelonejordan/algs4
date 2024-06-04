#!/bin/sh

FOLDER=wordnet

rm WordNet.java
rm SAP.java
rm Outcast.java
cp ../../../$FOLDER/WordNet.java .
cp ../../../$FOLDER/SAP.java .
cp ../../../$FOLDER/Outcast.java .

sed -i '' '/^package/d' WordNet.java
sed -i '' '/^package/d' SAP.java
sed -i '' '/^package/d' Outcast.java

SUBMISSION_FN=wordnet.zip

zip $SUBMISSION_FN WordNet.java SAP.java Outcast.java
rm $HOME/Downloads/$SUBMISSION_FN
cp $SUBMISSION_FN $HOME/Downloads
