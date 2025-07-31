#!/usr/bin/env bash

# Set JAVA_HOME
export JAVA_HOME=/opt/render/.java/openjdk
export PATH=$JAVA_HOME/bin:$PATH

echo "Using JAVA_HOME: $JAVA_HOME"
java -version

./mvnw clean install -DskipTests
