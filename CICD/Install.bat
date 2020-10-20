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

echo 5. Build Artifact package - JAR

echo Generating JAR

CALL mvn install

echo #################################

echo 1. Verify Java ------------ Done
echo 2. Verify Maven ------------ Done
echo 3. Clean Project ------------ Done
echo 4. Run Tests ------------ Done
echo 5. Build Artifact -JAR ------------ Done

echo #################################

echo Do you want to start the server? (Y/N)
set /p choice=
IF /i "%choice%"=="Y" goto yes
IF /i "%choice%"=="N" goto no

echo Invalid choice
goto commonexit

:yes

cd target

echo Starting server..........
 
CALL java -jar alert-to-care-0.0.1-SNAPSHOT.jar

:no
echo -----------------Build Successful-----------------

PAUSE

