#!/bin/sh

cf push $1 -p ./dist/ -b staticfile_buildpack
