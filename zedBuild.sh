#!/bin/bash

set -e

echo "Compiling..."

rm -rf build
mkdir -p build

find src -name "*.java" > sources.txt

javac -g --release 25 -d build @sources.txt

cp -r assets build/ 2>/dev/null || true

echo "Done Compiling."
