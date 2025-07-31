#!/usr/bin/env bash

# Runtime Java setup
mkdir -p /tmp/java

curl -L -o /tmp/java/openjdk.tar.gz https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.10+7/OpenJDK17U-jdk_x64_linux_hotspot_17.0.10_7.tar.gz

tar -xzf /tmp/java/openjdk.tar.gz -C /tmp/java

JAVA_DIR=$(find /tmp/java -maxdepth 1 -type d -name "jdk-17*")

export JAVA_HOME=$JAVA_DIR
export PATH=$JAVA_HOME/bin:$PATH

echo "JAVA version at runtime:"
java -version

# Run your app
java -jar target/ImageGalleryBackend-0.0.1-SNAPSHOT.jar
