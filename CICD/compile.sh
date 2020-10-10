#!/bin/bash

failon_error () {
RESULT=$?
if [ $RESULT -eq 0 ]; then
  echo " #### successful #### "
else
  echo " #### failed #### "
  exit 1
fi
}

cd /alert-to-care-s3b4/Source

mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install sonar:sonar 

failon_error

mvn clean install
