#!/bin/sh

set -e

cd ../empcon-server
./gradlew json
cd -

./node_modules/.bin/mocha --no-timeouts

./bin/printClient.sh
