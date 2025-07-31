#!/usr/bin/env bash

# Download and extract OpenJDK (e.g., version 17)
mkdir -p /tmp/java
curl -L -o /tmp/java/openjdk.tar.gz https://download.java.net/java/GA/jdk17.0.2/9/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz
tar -xzf /tmp/java/openjdk.tar.gz -C /tmp/java

# Set JAVA_HOME and update PATH
export JAVA_HOME=/tmp/java/jdk-17.0.2
export PATH=$JAVA_HOME/bin:$PATH

echo "Using JAVA_HOME: $JAVA_HOME"
java -version

# Build Spring Boot project
./mvnw clean install -DskipTests
