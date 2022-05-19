#!/usr/bin/env sh


 printf "\033[31m3\n\033[0m"
 sleep 1
 printf "\033[33m2\n\033[0m"
 sleep 1
 printf "\033[32m1\n\033[0m"
 sleep 1
 printf "\033[34mStart\n\033[0m"

rm -f result.txt

cd ./src/main/java
find . -name "*.java" > sources.txt
javac  @sources.txt
cp ../resources/simulation.txt .
java edu.school21.avaj.simulator.application.Main simulation.txt
rm simulation.txt sources.txt
find . -name "*.class" -type f -delete
