#!/usr/bin/env bash

# --- 1. Install Java 17 ---
mkdir -p /tmp/java
curl -L -o /tmp/java/openjdk.tar.gz https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.10%2B7/OpenJDK17U-jdk_x64_linux_hotspot_17.0.10_7.tar.gz
tar -xzf /tmp/java/openjdk.tar.gz -C /tmp/java

export JAVA_HOME=/tmp/java/jdk-17.0.10+7
export PATH=$JAVA_HOME/bin:$PATH

# --- 2. Build Spring Boot project with Maven Wrapper ---
./mvnw clean package -DskipTests

# --- 3. Run the JAR from target/ ---
java -jar target/ImageGallery.jar
