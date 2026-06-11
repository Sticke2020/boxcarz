#!/bin/bash

set -e

echo "Compiling..."

rm -rf build
mkdir -p build

find src -name "*.java" > sources.txt

javac --release 25 -g -d build @sources.txt

cp -r assets build/ 2>/dev/null || true

echo "Running..."

java -cp build com.boxcarz.Main
