#!/bin/bash

TARGET_DIR=.packages
TARGET_FILE=huiyin.zip

rm $TARGET_FILE
rm -rf $TARGET_DIR
mkdir -p $TARGET_DIR/dist

gulp
git clone . $TARGET_DIR/source-code
cp -r dist/* $TARGET_DIR/dist

(cd $TARGET_DIR && zip -r ../$TARGET_FILE *)
