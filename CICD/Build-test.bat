@echo off
title Build Test

cd ../Source

echo #################################

echo 1. Verifying JAVA version

echo Minimun Java version Required = 8

CALL java -version

echo #################################


echo 2. Verifying Maven 

echo Install latest verion of Maven and add mvn to PATH

CALL mvn -version

echo #################################

echo 3. Clean Project 

echo Removing Target....

CALL mvn clean

echo #################################
echo 4. Run Tests 

echo Running Unit Tests and Integration Tests

CALL mvn test

echo #################################

PAUSE

