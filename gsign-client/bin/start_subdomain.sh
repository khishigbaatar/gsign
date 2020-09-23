#!/bin/sh

SERVER_URL=$1 ./node_modules/.bin/webpack-dev-server --config ./webpack.config.subdomain.js --content-base ../dist/ --port $2 $3
