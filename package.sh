#!/bin/bash

TARGET_DIR=.packages

rm huiyin-*.zip
rm -rf $TARGET_DIR
mkdir -p $TARGET_DIR/dist

git clone . $TARGET_DIR/source-code
rm -rf $TARGET_DIR/source-code/.git

boot dist -- target -d $TARGET_DIR/dist

(cd $TARGET_DIR && zip -r ../huiyin-$(date +"%Y%m%d-%H%M%S") *)
