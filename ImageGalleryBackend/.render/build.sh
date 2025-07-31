#!/usr/bin/env bash

export JAVA_HOME=/opt/render/.java/openjdk
echo "Using JAVA_HOME: $JAVA_HOME"
java -version

./mvnw clean install -DskipTests
