#!/bin/sh

SERVER_URL=$1 ./node_modules/.bin/webpack-dev-server --content-base ../dist/ --port $2 $3
