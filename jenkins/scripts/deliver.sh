#!/bin/sh

set -x
mvn jar:jar install:install help:evaluate -Dexpression=project.name

export NAME="mvn -q -DforceStdout help:evaluate -Dexpression=project.name"
echo "Name: $NAME"

export VERSION="mvn -q -DforceStdout help:evaluate -Dexpression=project.version"
echo "Version: $VERSION"

java -jar target/$NAME-$VERSION.jar
set +x
