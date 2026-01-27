#!/bin/sh

set -x
mvn jar:jar install:install help:evaluate -Dexpression=project.name
set +x

set -x
NAME=$(mvn -q -DforceStdout help:evaluate -Dexpression=project.name)
set +x
echo "Name: $NAME"

set -x
VERSION=$(mvn -q -DforceStdout help:evaluate -Dexpression=project.version)
set +x
echo "Version: $VERSION"

set -x
java -jar target/"$NAME"-"$VERSION".jar
