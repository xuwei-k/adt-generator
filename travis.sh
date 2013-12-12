wget http://typesafe.artifactoryonline.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/$TRAVIS_SCALA_VERSION/sbt-launch.jar &&
rm project/build.properties &&
echo "sbt.version=$TRAVIS_SCALA_VERSION" > project/build.properties &&
java -XX:MaxPermSize=1G -Xmx2G -jar ./sbt-launch.jar scripted

