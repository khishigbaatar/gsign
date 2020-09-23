#!/bin/sh

set -e

FUNC='WF'

cd ../empcon-server
./gradlew json json
cd -

./node_modules/.bin/mocha 2>&1 | tee TestOutputWithColors$FUNC.txt
#Windows PC setup
#./node_modules/.bin/mocha 2>&1

if grep 'Warning' TestOutputWithColors$FUNC.txt
then
  LIGHTRED='\033[1;31m'
  NOCOLOR='\033[0m' # No Color
  echo "\n${LIGHTRED}** Please check the above warnings before committing. **${NOCOLOR}\n";
fi
