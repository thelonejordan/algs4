#!/bin/sh

FOLDER=collinear

rm BruteCollinearPoints.java
rm FastCollinearPoints.java
rm Point.java
cp ../../../$FOLDER/BruteCollinearPoints.java .
cp ../../../$FOLDER/FastCollinearPoints.java .
cp ../../../$FOLDER/Point.java .
