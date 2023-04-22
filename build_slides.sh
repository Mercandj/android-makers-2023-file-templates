#!/usr/bin/env bash

BASE_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null && pwd)"

pushd "${BASE_DIR}" >/dev/null || exit

rm -rf ./dist
npx fusuma build
INDEX_HTML_REPLACE_FROM="=\"\\/"
INDEX_HTML_REPLACE_TO="=\".\\/"
sed -i -e "s/${INDEX_HTML_REPLACE_FROM}/${INDEX_HTML_REPLACE_TO}/g" ./dist/index.html
MAIN_JS_REPLACE_FROM="z.p+\""
MAIN_JS_REPLACE_TO="\".\\/"
sed -i -e "s/${MAIN_JS_REPLACE_FROM}/${MAIN_JS_REPLACE_TO}/g" ./dist/main.*.bundle.js
open ./dist/index.html

popd >/dev/null || exit
