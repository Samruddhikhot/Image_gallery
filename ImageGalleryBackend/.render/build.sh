#!/usr/bin/env bash

# Create a temp dir for Java
mkdir -p /tmp/java

# Download JDK 17 (Temurin / Adoptium)
curl -L -o /tmp/java/openjdk.tar.gz https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.10+7/OpenJDK17U-jdk_x64_linux_hotspot_17.0.10_7.tar.gz

# Extract it
tar -xzf /tmp/java/openjdk.tar.gz -C /tmp/java

# Find the extracted folder name dynamically
JAVA_DIR=$(find /tmp/java -maxdepth 1 -type d -name "jdk-17*")

# Set JAVA_HOME and update PATH
export JAVA_HOME=$JAVA_DIR
export PATH=$JAVA_HOME/bin:$PATH

echo "Using JAVA_HOME: $JAVA_HOME"
java -version

# Build Spring Boot project
./mvnw clean install -DskipTests
